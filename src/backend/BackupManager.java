/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

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

    public boolean createBackup(User user, Backup backup, String path, String fileName) throws IOException 
    {
    if (!databaseHandler.addBackup(backup)) 
    {
        System.err.println("فشل في إضافة النسخة الاحتياطية إلى قاعدة البيانات.");
        return false;
    }

    String data = databaseHandler.exportDataBase(user);
    if (data == null) 
    {
        System.err.println("فشل في تصدير بيانات قاعدة البيانات.");
        return false;
    }

    File file = new File(path + fileName);
    if (!file.exists() && !file.createNewFile())
    {
        System.err.println("فشل في إنشاء ملف النسخة الاحتياطية: " + file.getAbsolutePath());
        return false;
    }
        System.out.println("1");
    try (FileOutputStream fileOutputStream = new FileOutputStream(file))
    {
        fileOutputStream.write(data.getBytes());
        System.out.println("تم إنشاء النسخة الاحتياطية بنجاح في: " + file.getAbsolutePath());
        return true;
    }
    catch (IOException e) 
    {
        System.err.println("حدث خطأ أثناء الكتابة في ملف النسخة الاحتياطية: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
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
