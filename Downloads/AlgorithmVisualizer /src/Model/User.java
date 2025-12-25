/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
/**
 *
 * @author rajpandit
 */

public class User {
    private int id;
    private String fullName;
    private String username;
    private String password;
    private String role;
    private Date registrationDate;
    
    public User(int id, String fullName, String username, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.registrationDate = new Date();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFullName() { return fullName; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public Date getRegistrationDate() { return registrationDate; }
}