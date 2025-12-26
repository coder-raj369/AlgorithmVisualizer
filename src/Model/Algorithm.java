/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rajpandit
 */


public class Algorithm {
    private int id;
    private String name;
    private String type;
    private String category;
    private String description;
   

    public Algorithm(int id, String name, String type, String category, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.description = description;
        
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    
    public void setId(int id) {this.id = id;}
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
}