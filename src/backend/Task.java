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
import java.util.Objects;

public class Task {
    private int taskId;
    private int userId;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private String status;

    public Task(int taskId, int userId, String title, String description, Date dueDate, int priority, String status) 
    {
        this.taskId = taskId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }

    public int getTaskId()
    {
        return taskId;
    }

    public void setTaskId(int taskId) 
    {
        this.taskId = taskId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public Date getDueDate() 
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate) 
    {
        this.dueDate = dueDate;
    }

    public int getPriority() 
    {
        return priority;
    }

    public void setPriority(int priority) 
    {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        return taskId == other.taskId &&
               userId == other.userId &&
               priority == other.priority &&
               Objects.equals(title, other.title) &&
               Objects.equals(description, other.description) &&
               Objects.equals(dueDate, other.dueDate) &&
               Objects.equals(status, other.status);
    }

    @Override
    public String toString() 
    {
        return "Task{" +
               "taskId=" + taskId +
               ", userId=" + userId +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", dueDate=" + dueDate +
               ", priority=" + priority +
               ", status='" + status + '\'' +
               '}';
    }
}