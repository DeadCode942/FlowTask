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


public class BackupManager 
{
    private DatabaseHandler databaseHandler;

    public BackupManager()
    {
        databaseHandler = new DatabaseHandler();
    }

    public boolean createBackup(User user,Backup backup,String path,String fileName)
    {
        if(databaseHandler.addBackup(backup))
        {
            if (databaseHandler.exportDataBase(user) != null)
            {
                try 
                {
                    FileOutputStream fi = new FileOutputStream(new File("c://database.txt"));
                    fi.write(databaseHandler.exportDataBase(user).getBytes());
                    fi.close();
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
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line  = "";
            while ( reader.readLine() !=  null)
            { 
                line = reader.readLine();
            }
            if(databaseHandler.importDataBase(line))
            {
                return true;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
