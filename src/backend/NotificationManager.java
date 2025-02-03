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

public class NotificationManager 
{
    private DatabaseHandler databaseHandler;

    public NotificationManager()
    {
        databaseHandler = new DatabaseHandler();
    }

    public int sendNotification(int taskId, String message, Date sendTime)
    {
        Notification notification = new Notification(0, taskId, message, sendTime);
        int notificationId = databaseHandler.addNotification(notification);
        return notificationId;
    }

    public int scheduleNotification(int taskId, String message, Date taskDueDate, int minutesBefore)
    {
        Date sendTime = new Date(taskDueDate.getTime() - (minutesBefore * 60 * 1000));
        return sendNotification(taskId, message, sendTime);
    }

    public List<Notification> getNotificationsByTask(Task task) 
    {
        return databaseHandler.getNotificationsByTask(task.getTaskId());
    }
}