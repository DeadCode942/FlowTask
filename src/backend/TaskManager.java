/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.List;

/**
 *
 * @author AHW STORE
 */
public class TaskManager 
{
    private Task task ;
    private DatabaseHandler databaseHandler;
    
    public TaskManager(Task task) 
    {
        databaseHandler = new DatabaseHandler();
        this.task = task;
    }

    public boolean addTask(Task task) 
    {
        return databaseHandler.addTask(task);
    }

    public boolean updateTask(Task task) 
    {
        return databaseHandler.updateTask(task);
    }

    public boolean deleteTask(Task task) 
    {
        return databaseHandler.deleteTask(task);
    }

    public List<Task> getTasksByUser(User user) 
    {
        return databaseHandler.getTasksByUser(user);
    }
}
