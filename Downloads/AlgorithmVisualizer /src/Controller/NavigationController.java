/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author rajpandit
 */

import View.Login_Page;
import View.Register_Page;
import View.User_dashboard;
import View.Admin_dashboard;
import javax.swing.JFrame;
public class NavigationController {
    
    // Close current window and open new one
    private static void switchView(JFrame current, JFrame next) {
        current.dispose();
        next.setVisible(true);
    }
    
    // Login to appropriate dashboard
    public static void loginAndRedirect(JFrame current, boolean isAdmin) {
        current.dispose();
        if (isAdmin) {
            Admin_dashboard adminDash = new Admin_dashboard();
            adminDash.setVisible(true);
        } else {
            User_dashboard userDash = new User_dashboard();
            userDash.setVisible(true);
        }
    }
    
    // Go to login
    public static void goToLogin(JFrame current) {
        switchView(current, new Login_Page());
    }
    
    // Go to register
    public static void goToRegister(JFrame current) {
        switchView(current, new Register_Page());
    }
    
    // Logout and go to login
    public static void logout(JFrame current) {
        AuthController authController = new AuthController();
        authController.logout();
        goToLogin(current);
    }
}