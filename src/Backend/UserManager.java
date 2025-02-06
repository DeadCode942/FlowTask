/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author AHW STORE
 */
public class UserManager
{
    private User user = null;
    private final DatabaseHandler databaseHandler;

    public UserManager() 
    {
        databaseHandler = new DatabaseHandler();
    }
    
    public boolean updateUser(User user) 
    {
        boolean updated = databaseHandler.updateUser(user);
        if (updated)
        {
            this.user = user; 
        }
        return updated;
    }
    
    public boolean deleteUser(User user) 
    {
        return databaseHandler.deleteUser(user);
    }

    public User getUser() 
    {
        return user;
    }
}
