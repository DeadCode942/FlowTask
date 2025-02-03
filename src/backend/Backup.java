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

public class Backup 
{
    private int backupId;
    private int userId;
    private Date backupDate;
    private String backupData; 
    
    public Backup(int backupId, int userId, Date backupDate, String backupData) 
    {
        this.backupId = backupId;
        this.userId = userId;
        this.backupDate = backupDate;
        this.backupData = backupData;
    }

    public int getBackupId() 
    {
        return backupId;
    }

    public void setBackupId(int backupId)
    {
        this.backupId = backupId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public Date getBackupDate()
    {
        return backupDate;
    }

    public void setBackupDate(Date backupDate)
    {
        this.backupDate = backupDate;
    }

    public String getBackupData()
    {
        return backupData;
    }

    public void setBackupData(String backupData) 
    {
        this.backupData = backupData;
    }

    @Override
    public String toString()
    {
        return "Backup{" +
               "backupId=" + backupId +
               ", userId=" + userId +
               ", backupDate=" + backupDate +
               ", backupData='" + backupData + '\'' +
               '}';
    }
}
