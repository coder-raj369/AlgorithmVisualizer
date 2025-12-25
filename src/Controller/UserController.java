/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import Model.User;
import java.util.List;

/**
 *
 * @author rajpandit
 */


public class UserController {
    private Database database;
    
    public UserController() {
        database = Database.getInstance();
    }
    
    // Get all users (for admin)
    public List<User> getAllUsers() {
        return database.getAllUsers();
    }
    
    // Get user by username
    public User getUserByUsername(String username) {
        return database.findUserByUsername(username);
    }
    
    // Get total user count
    public int getTotalUsers() {
        return database.getAllUsers().size();
    }
    
    // Update user profile
    public boolean updateUser(int userId, String fullName, String username, String password) {
        // Implementation for user profile update
        return true;
    }
}