/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author AHW STORE
 */
public class Backup 
{
    private int backupId;
    private int userId;
    private String backupDate;

    public Backup(int backupId, int userId, String backupDate) 
    {
        this.backupId = backupId;
        this.userId = userId;
        this.backupDate = backupDate;
    }

    public Backup(int userId, String backupDate)
    {
        this.userId = userId;
        this.backupDate = backupDate;
    }

    public String getBackupDate()
    {
        return backupDate;
    }

    public void setBackupDate(String backupDate)
    {
        this.backupDate = backupDate;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Backup backup = (Backup) obj;
        return backupId == backup.backupId;
    }

    public int getBackupId() {
        return backupId;
    }

    public void setBackupId(int backupId) {
        this.backupId = backupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(backupId);
    }

    
}
