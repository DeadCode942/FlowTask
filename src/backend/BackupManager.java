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
import java.util.Date;
import java.util.List;

public class BackupManager 
{
    private DatabaseHandler databaseHandler;

    public BackupManager()
    {
        databaseHandler = new DatabaseHandler();
    }

    public void createBackup(int userId)
    {
        Date backupDate = new Date();

        String backupData = convertDataToText(userId);

        Backup backup = new Backup(0, userId, backupDate, backupData);
        databaseHandler.addBackup(backup);
    }

    public void restoreBackup(int backupId) {
        Backup backup = databaseHandler.getBackupsByUser(backupId).get(0);
        String backupData = backup.getBackupData();

        restoreDataFromText(backupData);
    }

    private String convertDataToText(int userId)
    {
        StringBuilder data = new StringBuilder();
        data.append("Tasks:\n");
        for (Task task : databaseHandler.getTasksByUser(userId)) 
        {
            data.append(task.toString()).append("\n");
        }
        data.append("Notifications:\n");
        for (Notification notification : databaseHandler.getNotificationsByTask(userId))
        {
            data.append(notification.toString()).append("\n");
        }
        return data.toString();
    }

    private void restoreDataFromText(String backupData) 
    {
        System.out.println("تم استعادة البيانات من النسخة الاحتياطية:\n" + backupData);
    }
}
