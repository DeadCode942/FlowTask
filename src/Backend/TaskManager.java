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
    private DatabaseHandler databaseHandler;
    
    public TaskManager() 
    {
        databaseHandler = new DatabaseHandler();
    }

    public Task addTask(Task task) 
    {
        if (databaseHandler.addTask(task))
        {
            return databaseHandler.getTask(task.getTitle(), task.getEndDate());
        }
        return null;
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
