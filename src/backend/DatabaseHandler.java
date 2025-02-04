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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler 
{
    private static final String URL = "jdbc:sqlite:taskflow.db";

    public Connection connect()
    {
        Connection conn = null;
        try 
        {
            conn = DriverManager.getConnection(URL);
        }
        catch (SQLException e)
        {
            System.out.println("حدث خطأ أثناء الاتصال بقاعدة البيانات: " + e.getMessage());
        }
        return conn;
    }

    public boolean addUser(User user)
    {
        String sql = "INSERT INTO Users (user_id , name, phone_number, email, password) VALUES (?,?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPhoneNumber());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.executeUpdate();
            System.out.println("تمت إضافة المستخدم بنجاح!");
            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println("حدث خطأ أثناء إضافة المستخدم: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUser(User user) 
    {
        String sql = "DELETE FROM Users WHERE user_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, user.getUserId());
            pstmt.executeUpdate();
            System.out.println("تم حذف المستخدم بنجاح!");
            return true;
        } 
        catch (SQLException e)
        {
            System.out.println("حدث خطأ أثناء حذف المستخدم: " + e.getMessage());
            return false;
        }
    }

    public boolean updateUser(User user) 
    {
        String sql = "UPDATE Users SET name = ?, phone_number = ?, email = ?, password = ? WHERE user_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhoneNumber());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setInt(5, user.getUserId());
            pstmt.executeUpdate();
            System.out.println("تم تعديل المستخدم بنجاح!");
            return true;
        } 
        catch (SQLException e)
        {
            System.out.println("حدث خطأ أثناء تعديل المستخدم: " + e.getMessage());
            return false;
        }
    }

    public User getUser (String email, String password) {
    String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";
    User user = null;

    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql))
    {
        pstmt.setString(1, email);
        pstmt.setString(2, password);
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
    }
    catch (SQLException e) 
    {
        System.out.println("حدث خطأ أثناء استرجاع المستخدم: " + e.getMessage());
    }
    return user;
    }
    
   public boolean addTask(Task task) 
   {
    String sql = "INSERT INTO Tasks (user_id, title, description, status, star_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, task.getUserId());
        pstmt.setString(2, task.getTitle());
        pstmt.setString(3, task.getDescription());
        pstmt.setString(4, String.valueOf(task.isStatus()));
        pstmt.setDate(5, new java.sql.Date(task.getStartDate().getTime()));
        pstmt.setDate(6, new java.sql.Date(task.getEndDate().getTime()));
        pstmt.executeUpdate();
        System.out.println("تمت إضافة المهمة بنجاح!");
        return true;
    }
    catch (SQLException e) 
    {
        System.out.println("حدث خطأ أثناء إضافة المهمة: " + e.getMessage());
        return false;
    }
   }

    public boolean updateTask(Task task)
    {
        String sql = "UPDATE Tasks SET title = ?, description = ?, status = ?, star_date = ?, end_date = ? WHERE task_id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3,String.valueOf(task.isStatus()));
            pstmt.setDate(4, (Date) task.getStartDate());
            pstmt.setDate(5, (Date) task.getEndDate());
            pstmt.setInt(6, task.getTaskId());
            pstmt.executeUpdate();
            System.out.println("تمت تعديل المهمة بنجاح!");
            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println("حدث خطأ أثناء تعديل المهمة: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteTask(Task task) 
    {
        String sql = "DELETE FROM Tasks WHERE task_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, task.getTaskId());
            pstmt.executeUpdate();
            System.out.println("تم حذف المهمة بنجاح!");
            return true;
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء حذف المهمة: " + e.getMessage());
            return false;
        }
    }

    public List<Task> getTasksByUser (User user)
    {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM Tasks WHERE user_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, user.getUserId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                Task task = new Task(
                    rs.getInt("task_id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getDate("star_date"),
                    rs.getDate("end_date"),
                    Boolean.parseBoolean(rs.getString("status"))
                );
                tasks.add(task);
            }
        }
        catch (SQLException e) 
        {
            System.out.println("حدث خطأ أثناء استرجاع مهام المستخدم: " + e.getMessage());
        }
    return tasks;
}
    
    public boolean addBackup(Backup backup) 
    {
        if (backup.getUserId() <= 0)
        {
            System.out.println("معرف المستخدم غير صالح!");
            return false;
        }
        String sql = "INSERT INTO Backups (user_id, backup_date) VALUES (?, ?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setInt(1, backup.getUserId());
            pstmt.setTimestamp(2, new java.sql.Timestamp(backup.getBackupDate().getTime()));
            pstmt.executeUpdate();
            System.out.println("تمت إضافة النسخة الاحتياطية بنجاح!");
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("حدث خطأ أثناء إضافة النسخة الاحتياطية: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteBackup(Backup backup) 
    {
        String sql = "DELETE FROM Backups WHERE backup_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setInt(1, backup.getBackupId());
            pstmt.executeUpdate();
            System.out.println("تم حذف المهمة بنجاح!");
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("حدث خطأ أثناء حذف المهمة: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateBackup(Backup backup)
    {
    String sql = "UPDATE Backups SET backup_date = ? WHERE backup_id = ?";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql))
    {
        pstmt.setTimestamp(1, new java.sql.Timestamp(backup.getBackupDate().getTime()));
        pstmt.setInt(2, backup.getBackupId());
        pstmt.executeUpdate();
        System.out.println("تمت تعديل النسخة الاحتياطية بنجاح!");
        return true;
    } 
    catch (SQLException e)
    {
        System.out.println("حدث خطأ أثناء تعديل النسخة الاحتياطية: " + e.getMessage());
        return false;
    }
}
    
    public List<Backup> getBackupsByUser (User user)
    {
    List<Backup> backups = new ArrayList<>();
    String sql = "SELECT * FROM Backups WHERE user_id = ?";

    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql))
    {
        pstmt.setInt(1, user.getUserId());
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) 
        {
            Backup backup = new Backup(
                rs.getInt("backup_id"),
                rs.getInt("user_id"),
                rs.getTimestamp("backup_date") // استخدام Timestamp مباشرة
            );
            backups.add(backup);
        }
    } 
    catch (SQLException e) 
    {
        System.out.println("حدث خطأ أثناء استرجاع النسخ الاحتياطية: " + e.getMessage());
    }
    return backups;
}
    
   public String exportDataBase(User user)
    {
        StringBuilder code = new StringBuilder();
        List<Task> tasks = getTasksByUser(user);
        List<Backup> backups = getBackupsByUser(user);
        code.append("INSERT INTO Users (user_id, name, phone_number, email, password) VALUES (")
                .append(user.getUserId()).append(",").append("\'"+user.getName()+"\'").append(",")
                .append("\'"+user.getPhoneNumber()+"\'").append(",").append("\'"+user.getEmail()+"\'").append(",")
                .append("\'"+user.getPassword()+"\');").append("\n").append("--user\n");
        for (Task task : tasks)
        {
            code.append("INSERT INTO Tasks (task_id, user_id, title, description, status, star_date,end_date) VALUES (")
                    .append(task.getTaskId()).append(",").append(task.getUserId()).append(",")
                    .append("\'"+task.getTitle()+"\'").append(",").append("\'"+task.getDescription()+"\'").append(",")
                    .append("\'"+task.isStatus()+"\'").append(",").append("\'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getStartDate())+"\'").append(",")
                    .append("\'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getEndDate())+"\');").append("\n");
        }
        code.append("--task\n");
        
        code.append("--notification\n");
        for (Backup backup : backups)
        {
            code.append("INSERT INTO Backups (backup_id ,user_id, backup_date) VALUES (")
                    .append(backup.getBackupId()).append(",").append(user.getUserId()).append(",").append("")
                    .append("\'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(backup.getBackupDate())+"\');").append("\n");
        }
        code.append("--backup\n");
        return code.toString();
    }
     
    public boolean importDataBase(String s) 
    {
    String[] sql = s.split(";");
    try (Connection conn = this.connect(); Statement st = conn.createStatement()) 
    {
        for (String code : sql) 
        {
            st.executeUpdate(code);
        }
        return true;
    } 
    catch (SQLException ex) 
    {
        ex.printStackTrace();
        return false;
    }
}
}