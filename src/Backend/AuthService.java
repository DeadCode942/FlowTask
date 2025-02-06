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
public abstract class AuthService 
{
    private static final DatabaseHandler db = new DatabaseHandler();

    private AuthService(){}
    
    public static boolean registerUser(User user) 
    {
        if (db.getUser(user.getEmail(), user.getPassword()) != null) 
        {
            System.out.println("المستخدم موجود بالفعل!");
            return false;
        }
        return db.addUser(user);
    }
    public static User login(String email, String password)
    {
        return db.getUser(email, password);
    }
    public abstract boolean logout(User user);
}
