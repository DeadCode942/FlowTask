/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;

/**
 *
 * @author AHW STORE
 */
public class Backup 
{
    private int backupId;
    private int userId;
    private Date backupDate;
    
    public Backup(int backupId, int userId, Date backupDate) 
    {
        this.backupId = backupId;
        this.userId = userId;
        this.backupDate = backupDate;
    }

    public Backup(int userId, Date backupDate)
    {
        this.userId = userId;
        this.backupDate = backupDate;
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

    @Override
    public String toString() {
        return "Backup{" + "backupId=" + backupId + ", userId=" + userId + ", backupDate=" + backupDate + '}';
    }

   
   
}
