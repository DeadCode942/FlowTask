/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.Objects;

/**
 *
 * @author AHW STORE
 */
public class User {
    private int Id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String name, String phoneNumber, String email, String password) 
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public User(int Id, String name, String phoneNumber, String email, String password) 
    {
        this.Id = Id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public int getUserId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User other = (User) obj;
        return Id == other.Id &&
            Objects.equals(name, other.name) &&
            Objects.equals(phoneNumber, other.phoneNumber) &&
            Objects.equals(email, other.email) &&
            Objects.equals(password, other.password);
    }
    
    @Override
    public int hashCode() 
    {
        return Objects.hash(Id, name, phoneNumber, email);
    }

    
    @Override
    public String toString()
    {
        return "User{" +
                "userId=" + Id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='[PROTECTED]'" +
                '}';
    }

}