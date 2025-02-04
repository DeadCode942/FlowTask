/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author AHW STORE
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BackupManager 
{
    private DatabaseHandler databaseHandler;

    public BackupManager()
    {
        databaseHandler = new DatabaseHandler();
    }

    public boolean createBackup(User user, Backup backup, String path, String fileName) 
    {
    if (databaseHandler.addBackup(backup))
    {
        String data = databaseHandler.exportDataBase(user);
        if (data != null) 
        {
            try (FileOutputStream fi = new FileOutputStream(new File(path + fileName))) {
                fi.write(data.getBytes());
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
    }
    return false;
}

    public boolean restoreBackup(File f) 
    {
    try (BufferedReader reader = new BufferedReader(new FileReader(f))) 
    {
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null)
        {
            content.append(line).append("\n");
        }
        return databaseHandler.importDataBase(content.toString());
    }
    catch (IOException e) 
    {
        e.printStackTrace();
        return false;
    }
}
    
    public boolean addBackup(Backup backup) 
    {
        return databaseHandler.addBackup(backup);
    }

    public boolean updateNotification(Backup backup) 
    {
        return databaseHandler.updateBackup(backup);
    }

    public boolean deleteNotification(Backup backup) 
    {
        return databaseHandler.deleteBackup(backup);
    }

    public List<Backup> getBackupByUser (User user) 
    {
        if (user == null)
        {
          System.out.println("المستخدم غير صالحة!");
          return new ArrayList<>();
        }
        return databaseHandler.getBackupsByUser (user);
    }
}
