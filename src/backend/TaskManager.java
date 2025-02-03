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
import java.util.List;

public class TaskManager 
{
    private DatabaseHandler databaseHandler;

    public TaskManager() 
    {
        databaseHandler = new DatabaseHandler();
    }

    public void addTask(Task task) 
    {
        databaseHandler.addTask(task);
    }

    public void updateTask(Task task) 
    {
        databaseHandler.updateTask(task);
    }

    public void deleteTask(int taskId) 
    {
        databaseHandler.deleteTask(taskId);
    }

    public List<Task> getTasksByUser(User user) 
    {
        return databaseHandler.getTasksByUser(user.getUserId());
    }
}