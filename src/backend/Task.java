/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.Date;

/**
 *
 * @author AHW STORE
 */
public class Task
{
    
    private int taskId;
    private int userId;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private boolean status;

    public Task(int userId, String title, String description, String startDate, String endDate, boolean status) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Task(int taskId, int userId, String title, String description, String startDate, String endDate, boolean status) {
        this.taskId = taskId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
    

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" + "taskId=" + taskId + ", userId=" + userId + ", title=" + title + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + '}';
    }
    
    
    
}
