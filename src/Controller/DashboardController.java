/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;

/**
 *
 * @author rajpandit
 */


public class DashboardController {
    private Database database;
    
    public DashboardController() {
        database = Database.getInstance();
    }
    
    // Get dashboard statistics for admin
    public DashboardStats getAdminDashboardStats() {
        DashboardStats stats = new DashboardStats();
        stats.totalAlgorithms = database.getTotalAlgorithms();
        stats.totalUsers = database.getAllUsers().size();
        // You can add more stats here
        return stats;
    }
    
    // Get dashboard statistics for user
    public UserDashboardStats getUserDashboardStats(int userId) {
        UserDashboardStats stats = new UserDashboardStats();
        // Calculate user-specific stats
        return stats;
    }
    
    // Inner class for stats
    public class DashboardStats {
        public int totalAlgorithms;
        public int totalUsers;
        public int todayActivity; // You can implement this
        
        @Override
        public String toString() {
            return "Total Algorithms: " + totalAlgorithms + 
                   ", Total Users: " + totalUsers;
        }
    }
    
    public class UserDashboardStats {
        public int completedAlgorithms;
        public int inProgressAlgorithms;
        public int totalAvailableAlgorithms;
        
        @Override
        public String toString() {
            return "Completed: " + completedAlgorithms + 
                   ", In Progress: " + inProgressAlgorithms;
        }
    }
}