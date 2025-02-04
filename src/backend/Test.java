/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AHW STORE
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        User user = new User(4,"youssef", "01018120346", "yhassan5335.gamil.com", "hhyy");
        User user2 = null;
        DatabaseHandler dh = new DatabaseHandler();
        TaskManager tm = new TaskManager();
        Task t =new Task(20,user.getUserId(), "school", "go to", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), true);
        BackupManager bm = new BackupManager();
        Backup b = new Backup(user.getUserId(), new Date(System.currentTimeMillis()));


        System.out.println("ff");
        AuthService.registerUser(user);
        System.out.println("dd");
        user2 = AuthService.login("yhassan5335.gamil.com", "hhyy");
        System.err.println(user);
        System.out.println(user2);
        if (user2 == null)
        {
            System.exit(0);
        }
        System.out.println("dfdf");
        if(!user.equals(user2))
        {
            System.exit(1);
        }
        System.out.println("wellcom");
        if(!tm.addTask(t))
        {
            System.exit(1);
        }
        System.out.println("1");
        
        System.out.println("2d");
        if (bm.createBackup(user, b, "E:\\", "ddf.txt"))
        {
        }
    }
}