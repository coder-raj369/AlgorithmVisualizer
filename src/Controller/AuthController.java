/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import Model.User;
import Model.UserSession;

/**
 *
 * @author rajpandit
 */


public class AuthController {
    private Database database;

    public AuthController() {
        database = Database.getInstance();
    }

    public boolean login(String username, String password) {
        User user = database.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            UserSession.getInstance().setCurrentUser(user);
            return true;
        }
        return false;
    }

    public boolean register(String fullName, String username, String password) {
        if (database.findUserByUsername(username) != null) {
            return false; // User already exists
        }

        User newUser = new User(database.getAllUsers().size() + 1, fullName, username, password, "user");
        return database.addUser(newUser);
    }

    public void logout() {
        UserSession.getInstance().clearSession();
    }

    public boolean isAdmin() {
        return UserSession.getInstance().getCurrentUser().getRole().equals("admin");
    }
}