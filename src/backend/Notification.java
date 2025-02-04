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

public class Notification
{
    private int notificationId;
    private int taskId;
    private String message;
    private Date sendTime;

    public Notification(int notificationId, int taskId, String message, Date sendTime)
    {
        this.notificationId = notificationId;
        this.taskId = taskId;
        this.message = message;
        this.sendTime = sendTime;
    }
    
    public Notification(int taskId, String message, Date sendTime)
    {
        this.taskId = taskId;
        this.message = message;
        this.sendTime = sendTime;
    }

    public int getNotificationId() 
    {
        return notificationId;
    }

    public void setNotificationId(int notificationId)
    {
        this.notificationId = notificationId;
    }

    public int getTaskId() 
    {
        return taskId;
    }

    public void setTaskId(int taskId) 
    {
        this.taskId = taskId;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Date getSendTime() 
    {
        return sendTime;
    }

    public void setSendTime(Date sendTime)
    {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() 
    {
        return "Notification{" +
               "notificationId=" + notificationId +
               ", taskId=" + taskId +
               ", message='" + message + '\'' +
               ", sendTime=" + sendTime +
               '}';
    }
}