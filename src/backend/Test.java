/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

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
     public static void main(String[] args) {
        User user = new User(9,"youssf", "fdgfd", "sdfs", "dsf");
        Task task = new Task(user.getUserId(), "rfdgfd", "dfgdfg", new Date(System.currentTimeMillis()) , new Date(System.currentTimeMillis()),true);
        Backup backup = new Backup(user.getUserId(), new Date(System.currentTimeMillis()));
        StringBuilder code = new StringBuilder();
        code.append("INSERT INTO Users (user_id, name, phone_number, email, password) VALUES (")
                .append(user.getUserId()).append(",").append("\'"+user.getName()+"\'").append(",")
                .append("\'"+user.getPhoneNumber()+"\'").append(",").append("\'"+user.getEmail()+"\'").append(",")
                .append("\'"+user.getPassword()+"\');").append("\n");
        
        ///////////////////////////////////////////////////////////////
        code.append("INSERT INTO Tasks (task_id, user_id, title, description, status, star_date,end_date) VALUES (")
                     .append(task.getTaskId()).append(",").append(task.getUserId()).append(",")
                     .append("\'"+task.getTitle()+"\'").append(",").append("\'"+task.getDescription()+"\'").append(",")
                     .append("\'"+task.isStatus()+"\'").append(",").append("\'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getStartDate())+"\'").append(",")
                     .append("\'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getEndDate())+"\');").append("\n");
        
        /////////////////////////////////////////////////////////////////
        code.append("INSERT INTO Backups (user_id, backup_date) VALUES (")
                     .append(user.getUserId()).append(",").append("")
                     .append("\'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(backup.getBackupDate())+"\');").append("\n");
        System.out.print(code.toString());
     String g ="INSERT INTO Users (user_id, name, phone_number, email, password) VALUES (9,'youssf','fdgfd','sdfs','dsf');\n" +
"INSERT INTO Tasks (task_id, user_id, title, description, status, star_date,end_date) VALUES (0,9,'rfdgfd','dfgdfg','true','2025-02-03 22:44:39','2025-02-03 22:44:39');\n" +
"INSERT INTO Backups (user_id, backup_date) VALUES (9,'2025-02-03 22:44:39');";
         System.out.println(g);
         String f[]= g.split(";");
         for (String string : f) {
             System.out.print(string);
         }
     }
     
           
        }