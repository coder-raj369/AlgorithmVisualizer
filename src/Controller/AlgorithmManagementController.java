/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Algorithm;
import Model.Database;

/**
 *
 * @author rajpandit
 */


public class AlgorithmManagementController {
    private Database database;

    public AlgorithmManagementController() {
        database = Database.getInstance();
    }

    // Add new algorithm
    public boolean addAlgorithm(String name, String type, String category, String description) {
        Algorithm algorithm = new Algorithm(database.getAllAlgorithms().size() + 1, name, type, category, description);
        return database.addAlgorithm(algorithm);
    }

    // Update existing algorithm
    public boolean updateAlgorithm(int id, String name, String type, String category, String description) {
        Algorithm algorithm = database.getAlgorithmById(id);
        if (algorithm != null) {
            algorithm.setName(name);
            algorithm.setType(type);
            algorithm.setCategory(category);
            algorithm.setDescription(description);
            return database.updateAlgorithm(algorithm);
        }
        return false;
    }

    // Delete algorithm
    public boolean deleteAlgorithm(int id) {
        return database.deleteAlgorithm(id);
    }
}