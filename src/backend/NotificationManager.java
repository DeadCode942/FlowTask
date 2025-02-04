package backend;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author AHW STORE
 */


public class NotificationManager 
{
    private DatabaseHandler databaseHandler;

    public NotificationManager() 
    {
        databaseHandler = new DatabaseHandler();
    }

    public boolean addNotification(Notification notification) 
    {
        return databaseHandler.addNotification(notification);
    }

    public boolean updateNotification(Notification notification) 
    {
        return databaseHandler.updateNotification(notification);
    }

    public boolean deleteNotification(Notification notification) 
    {
        return databaseHandler.deleteNotification(notification);
    }

    public List<Notification> getNotificationsByTask(Task task)
    {
        if (task == null) 
        {
            System.out.println("المهمة غير صالحة!");
            return new ArrayList<>();
        }
        return databaseHandler.getNotificationByTask(task);
    }
}