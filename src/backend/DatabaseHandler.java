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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler 
{
    private static final String URL = "jdbc:sqlite:taskflow.db";

    public Connection connect()
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء الاتصال بقاعدة البيانات: " + e.getMessage());
        }
        return conn;
    }

    public boolean addUser(User user) {
        String sql = "INSERT INTO Users (name, phone_number, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhoneNumber());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.executeUpdate();
            System.out.println("تمت إضافة المستخدم بنجاح!");
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء إضافة المستخدم: " + e.getMessage());
        }
        return true;
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE user_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
            System.out.println("تم حذف المستخدم بنجاح!");
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء حذف المستخدم: " + e.getMessage());
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE Users SET name = ?, phone_number = ?, email = ?, password = ? WHERE user_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhoneNumber());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setInt(5, user.getUserId());
            pstmt.executeUpdate();
            System.out.println("تم تعديل المستخدم بنجاح!");
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء تعديل المستخدم: " + e.getMessage());
        }
    }

    public User getUserById(int userId) {
        String sql = "SELECT * FROM Users WHERE user_id = ?";
        User user = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("phone_number"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء استرجاع المستخدم: " + e.getMessage());
        }
        return user;
    }

    public void addTask(Task task) {
        String sql = "INSERT INTO Tasks (user_id, title, description, due_date, priority, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setInt(1, task.getUserId());
            pstmt.setString(2, task.getTitle());
            pstmt.setString(3, task.getDescription());
            pstmt.setDate(4, new java.sql.Date(task.getDueDate().getTime()));
            pstmt.setInt(5, task.getPriority());
            pstmt.setString(6, task.getStatus());
            pstmt.executeUpdate();
            System.out.println("تمت إضافة المهمة بنجاح!");
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء إضافة المهمة: " + e.getMessage());
        }
    }

    public void updateTask(Task task) {
        String sql = "UPDATE Tasks SET title = ?, description = ?, due_date = ?, priority = ?, status = ? WHERE task_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setDate(3, new java.sql.Date(task.getDueDate().getTime()));
            pstmt.setInt(4, task.getPriority());
            pstmt.setString(5, task.getStatus());
            pstmt.setInt(6, task.getTaskId());
            pstmt.executeUpdate();
            System.out.println("تم تعديل المهمة بنجاح!");
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء تعديل المهمة: " + e.getMessage());
        }
    }

    public void deleteTask(int taskId) {
        String sql = "DELETE FROM Tasks WHERE task_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();
            System.out.println("تم حذف المهمة بنجاح!");
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء حذف المهمة: " + e.getMessage());
        }
    }

    public List<Task> getTasksByUser(int userID) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM Tasks WHERE user_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Task task = new Task(
                    rs.getInt("task_id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getDate("due_date"),
                    rs.getInt("priority"),
                    rs.getString("status")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء استرجاع مهام المستخدم: " + e.getMessage());
        }
        return tasks;
    }
    
     public int addNotification(Notification notification) {
        String sql = "INSERT INTO Notifications (task_id, message, send_time) VALUES (?, ?, ?)";
        int notificationId = -1;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, notification.getTaskId());
            pstmt.setString(2, notification.getMessage());
            pstmt.setTimestamp(3, new java.sql.Timestamp(notification.getSendTime().getTime()));
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                notificationId = rs.getInt(1);
            }
            System.out.println("تمت إضافة الإشعار بنجاح! ID: " + notificationId);
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء إضافة الإشعار: " + e.getMessage());
        }
        return notificationId;
    }

    public List<Notification> getNotificationsByTask(int taskID) {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM Notifications WHERE task_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Notification notification = new Notification(
                    rs.getInt("notification_id"),
                    rs.getInt("task_id"),
                    rs.getString("message"),
                    rs.getTimestamp("send_time")
                );
                notifications.add(notification);
            }
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء استرجاع الإشعارات: " + e.getMessage());
        }
        return notifications;
    }
    
    public void addBackup(Backup backup) {
        String sql = "INSERT INTO Backups (user_id, backup_date, backup_data) VALUES (?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, backup.getUserId());
            pstmt.setTimestamp(2, new java.sql.Timestamp(backup.getBackupDate().getTime()));
            pstmt.setString(3, backup.getBackupData());
            pstmt.executeUpdate();
            System.out.println("تمت إضافة النسخة الاحتياطية بنجاح!");
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء إضافة النسخة الاحتياطية: " + e.getMessage());
        }
    }

    public List<Backup> getBackupsByUser(int userID) {
        List<Backup> backups = new ArrayList<>();
        String sql = "SELECT * FROM Backups WHERE user_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Backup backup = new Backup(
                    rs.getInt("backup_id"),
                    rs.getInt("user_id"),
                    rs.getTimestamp("backup_date"),
                    rs.getString("backup_data")
                );
                backups.add(backup);
            }
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء استرجاع النسخ الاحتياطية: " + e.getMessage());
        }
        return backups;
    }
}
