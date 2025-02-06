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
public class NewClass
{
    public static void main(String[] args)
    {
        User user= new User("Youssef", "01018120346", "yhassam5335.gmail.com", "Youssef");
        User user1 = null;
        UserManager userManager = new UserManager();
        if(!AuthService.registerUser(user))
        {
            System.out.println("error");
        }
        System.out.println("gg");
        if(((user1=AuthService.login(user.getEmail(),user.getPassword())) == null))
        {
            System.out.println("error1");
        }
        System.out.println(user1);
        user1.setName("deadcode");
        if(userManager.updateUser(user1))
        {
           user1=userManager.getUser();
        }
        System.out.println(user1);
        userManager.deleteUser( user1);
    }
}
 
