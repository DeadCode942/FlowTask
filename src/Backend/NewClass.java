/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author AHW STORE
 */
public class NewClass
{
    public static void main(String[] args)
    {
        BackupManager backupManager = new BackupManager();
        backupManager.restoreBackup(new File("E:\\df.txt"));
    }
}
 
