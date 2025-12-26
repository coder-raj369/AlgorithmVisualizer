/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rajpandit
 */



import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance;
    private List<User> users;
    private List<Algorithm> algorithms;
    private int userIdCounter = 1;
    private int algorithmIdCounter = 1;

    private Database() {
        users = new ArrayList<>();
        algorithms = new ArrayList<>();

        // Default admin user and a test user
        users.add(new User(userIdCounter++, "Admin User", "admin123", "password", "admin"));
        users.add(new User(userIdCounter++, "Test User", "testuser", "testpass", "user"));

        // Sample algorithms
        // Easy + Searching
        algorithms.add(new Algorithm(algorithmIdCounter++, "Linear Search", "Searching", "Easy", 
            "Linear search is a simple search algorithm that checks each element in the list sequentially until the desired element is found or the list ends."));

        // Easy + Sorting
        algorithms.add(new Algorithm(algorithmIdCounter++, "Bubble Sort", "Sorting", "Easy", 
            "Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order."));

        // Easy + Sorting
        algorithms.add(new Algorithm(algorithmIdCounter++, "Insertion Sort", "Sorting", "Easy", 
            "Insertion sort builds the final sorted array one item at a time by repeatedly inserting a new element into the sorted portion."));

        // Easy + Graph
        algorithms.add(new Algorithm(algorithmIdCounter++, "Basic Graph Representation", "Graph", "Easy", 
            "Graphs can be represented using adjacency lists or adjacency matrices. This covers basic concepts of nodes and edges."));

        // Medium + Searching
        algorithms.add(new Algorithm(algorithmIdCounter++, "Binary Search", "Searching", "Medium", 
            "Binary search is an efficient algorithm that finds the position of a target value within a sorted array by repeatedly dividing the search interval in half."));

        // Medium + Sorting
        algorithms.add(new Algorithm(algorithmIdCounter++, "Quick Sort", "Sorting", "Medium", 
            "Quick sort is a highly efficient sorting algorithm that uses divide-and-conquer by selecting a pivot and partitioning the array around it."));

        // Medium + Sorting
        algorithms.add(new Algorithm(algorithmIdCounter++, "Merge Sort", "Sorting", "Medium", 
            "Merge sort is a stable divide-and-conquer sorting algorithm that divides the array into halves, sorts them, and then merges them back."));

        // Medium + Graph
        algorithms.add(new Algorithm(algorithmIdCounter++, "Breadth-First Search (BFS)", "Graph", "Medium", 
            "BFS is a graph traversal algorithm that explores all vertices level by level using a queue, starting from the source node."));

        // Medium + Graph
        algorithms.add(new Algorithm(algorithmIdCounter++, "Depth-First Search (DFS)", "Graph", "Medium", 
            "DFS is a graph traversal algorithm that explores as far as possible along each branch before backtracking, using recursion or a stack."));

        // Hard + Sorting
        algorithms.add(new Algorithm(algorithmIdCounter++, "Heap Sort", "Sorting", "Hard", 
            "Heap sort uses a binary heap data structure to sort an array by first building a max-heap and repeatedly extracting the maximum element."));

        // Hard + Searching
        algorithms.add(new Algorithm(algorithmIdCounter++, "Ternary Search", "Searching", "Hard", 
            "Ternary search divides the array into three parts and recursively searches in the appropriate third for the target value."));

        // Hard + Graph
        algorithms.add(new Algorithm(algorithmIdCounter++, "Dijkstra's Algorithm", "Graph", "Hard", 
            "Dijkstra's algorithm finds the shortest path from a source node to all other nodes in a weighted graph with non-negative edge weights."));

        // Hard + Graph
        algorithms.add(new Algorithm(algorithmIdCounter++, "Bellman-Ford Algorithm", "Graph", "Hard", 
            "Bellman-Ford computes shortest paths from a single source vertex to all others in a weighted graph, and can handle negative weights."));

        // Bonus: A few more for variety
        algorithms.add(new Algorithm(algorithmIdCounter++, "Selection Sort", "Sorting", "Easy", 
            "Selection sort divides the list into sorted and unsorted regions, repeatedly selecting the smallest element from the unsorted region."));

        algorithms.add(new Algorithm(algorithmIdCounter++, "Jump Search", "Searching", "Medium", 
            "Jump search works on sorted arrays by jumping ahead by fixed steps and then performing linear search in the block."));
    }
        

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        user.setId(userIdCounter++);
        users.add(user);
        return true;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public Algorithm getAlgorithmById(int id) {
        for (Algorithm algorithm : algorithms) {
            if (algorithm.getId() == id) {
                return algorithm;
            }
        }
        return null;
    }

    public boolean addAlgorithm(Algorithm algorithm) {
        algorithm.setId(algorithmIdCounter++);
        algorithms.add(algorithm);
        return true;
    }

    public boolean updateAlgorithm(Algorithm updatedAlgorithm) {
        for (int i = 0; i < algorithms.size(); i++) {
            if (algorithms.get(i).getId() == updatedAlgorithm.getId()) {
                algorithms.set(i, updatedAlgorithm);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAlgorithm(int id) {
        return algorithms.removeIf(algorithm -> algorithm.getId() == id);
    }

    public List<Algorithm> getAllAlgorithms() {
        return new ArrayList<>(algorithms);
    }

    public List<Algorithm> getAlgorithmsByType(String type) {
        List<Algorithm> result = new ArrayList<>();
        for (Algorithm algorithm : algorithms) {
            if (type.isEmpty() || algorithm.getType().equalsIgnoreCase(type)) {
                result.add(algorithm);
            }
        }
        return result;
    }

    public List<Algorithm> getAlgorithmsByCategory(String category) {
        List<Algorithm> result = new ArrayList<>();
        for (Algorithm algorithm : algorithms) {
            if (algorithm.getCategory().equalsIgnoreCase(category)) {
                result.add(algorithm);
            }
        }
        return result;
    }

    public List<Algorithm> getAlgorithmsByTypeAndCategory(String type, String category) {
        List<Algorithm> result = new ArrayList<>();
        for (Algorithm algorithm : algorithms) {
            if ((type.isEmpty() || algorithm.getType().equalsIgnoreCase(type)) && algorithm.getCategory().equalsIgnoreCase(category)) {
                result.add(algorithm);
            }
        }
        return result;
    }
    public List<Algorithm> getAlgorithmsForUser(User currentUser) {
        List<Algorithm> userAlgorithms = new ArrayList<>();

        // If admin, return all algorithms
        if ("admin".equals(currentUser.getRole())) {
            return new ArrayList<>(algorithms); // Return copy
        }

        
        return userAlgorithms;
    }

    public int getTotalAlgorithms() {
        return algorithms.size();
    }
}