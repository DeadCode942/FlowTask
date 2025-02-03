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

public class Main {
    public static void main(String[] args) {
        // إنشاء مستخدم
        User user = new User(1, "Youssef", "0123456789", "youssef@example.com", "password123");
        System.out.println("تم إنشاء المستخدم: " + user);

        // إنشاء مهمة
        Date dueDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000); // بعد يوم من الآن
        Task task = new Task(1, user.getUserId(), "Task 1", "Description 1", dueDate, 1, "Pending");
        System.out.println("تم إنشاء المهمة: " + task);

        // إنشاء إشعار
        Date sendTime = new Date();
        Notification notification = new Notification(1, task.getTaskId(), "Reminder: Task 1", sendTime);
        System.out.println("تم إنشاء الإشعار: " + notification);

        // إنشاء نسخة احتياطية
        Backup backup = new Backup(1, user.getUserId(), new Date(), "Backup Data");
        System.out.println("تم إنشاء النسخة الاحتياطية: " + backup);

        // اختبار DatabaseHandler
       DatabaseHandler dbHandler = new DatabaseHandler();

        // إضافة المستخدم
        dbHandler.addUser(user);
        System.out.println("تمت إضافة المستخدم بنجاح!");

        // استرجاع المستخدم
        User retrievedUser = dbHandler.getUserById(user.getUserId());
        System.out.println("المستخدم المسترجع: " + retrievedUser);

        // تعديل المستخدم
        user.setName("Youssef Hassan");
        user.setEmail("youssef.hassan@example.com");
        dbHandler.updateUser(user);
        System.out.println("تم تعديل المستخدم بنجاح!");

        // استرجاع المستخدم بعد التعديل
        User updatedUser = dbHandler.getUserById(user.getUserId());
        System.out.println("المستخدم بعد التعديل: " + updatedUser);

        
        dbHandler.addTask(task);
        System.out.println("تمت إضافة المهمة!");

        // استرجاع المهام الخاصة بالمستخدم
        List<Task> tasks = dbHandler.getTasksByUser(user.getUserId());
        System.out.println("المهام الخاصة بالمستخدم:");
        for (Task t : tasks) {
            System.out.println(t);
        }

        // إضافة الإشعار
        int notificationId = dbHandler.addNotification(notification);
        System.out.println("تمت إضافة الإشعار! ID: " + notificationId);

        // استرجاع الإشعارات الخاصة بالمهمة
        List<Notification> notifications = dbHandler.getNotificationsByTask(task.getTaskId());
        System.out.println("الإشعارات الخاصة بالمهمة:");
        for (Notification n : notifications) {
            System.out.println(n);
        }

        // إضافة النسخة الاحتياطية
        dbHandler.addBackup(backup);
        System.out.println("تمت إضافة النسخة الاحتياطية!");

        // استرجاع النسخ الاحتياطية الخاصة بالمستخدم
        List<Backup> backups = dbHandler.getBackupsByUser(user.getUserId());
        System.out.println("النسخ الاحتياطية الخاصة بالمستخدم:");
        for (Backup b : backups) {
            System.out.println(b);
        }

        // تعديل المهمة
        task.setStatus("Completed");
        dbHandler.updateTask(task);
        System.out.println("تم تعديل المهمة بنجاح!");


    }
}