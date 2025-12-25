/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Algorithm;
import Model.Database;
import java.util.List;

/**
 *
 * @author rajpandit
 */


public class AlgorithmViewController {
    private Database database;

    public AlgorithmViewController() {
        database = Database.getInstance();
    }

    public List<Algorithm> getAllAlgorithms() {
        return database.getAllAlgorithms();
    }

    public List<Algorithm> getAlgorithmsByType(String type) {
        return database.getAlgorithmsByType(type);
    }

    public List<Algorithm> getAlgorithmsByCategory(String category) {
        return database.getAlgorithmsByCategory(category);
    }

    public List<Algorithm> getAlgorithmsByTypeAndCategory(String type, String category) {
        return database.getAlgorithmsByTypeAndCategory(type, category);
    }

    public int getTotalAlgorithms() {
        return database.getTotalAlgorithms();
    }
}