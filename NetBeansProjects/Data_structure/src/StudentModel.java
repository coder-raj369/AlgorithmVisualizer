/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rajpandit
 */
public class StudentModel {
    private  String LmuID;
    private String fullName;
    private String Program;
    private String contact;
    private int age;
    
    //constructor
    public StudentModel(String LmuID, String fullName, String Program, String contact, int age){
        this.LmuID = LmuID;
        this.fullName = fullName;
        this.Program = Program;
        this.contact = contact;
        this.age= age;
    }
    //getter
    
    public String getLmuID(){
        return LmuID;
    }
    
    public String getfullName(){
        return fullName;
    }
    
    public String getProgram(){
        return Program;
    }
    
    public String getcontact(){
        return contact;
    }
    
    public int getage(){
        return age;
    }
    //setter
    public void setLmuID(String LmuID){
        this.LmuID = LmuID;
    }
    
    public void setfullNameD(String fullName){
        this.fullName = fullName;
    }
    
    public void setProgram(String Program){
        this.Program = Program;
    }
    
    public void setcontact(String contact){
        this.contact = contact;
    }
    
    public void setage(int age){
        this.age = age;
    }
}
