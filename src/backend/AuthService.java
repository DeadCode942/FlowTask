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
public abstract class AuthService 
{
    private static final DatabaseHandler db = new DatabaseHandler();

    private AuthService(){}
    
    public static boolean registerUser(User user)
    {
        
        return db.addUser(user);
        
    }
    public static User login(String email, String password)
    {
        return db.getUserById(email, password);
    }
    public abstract boolean logout(User user);
}
