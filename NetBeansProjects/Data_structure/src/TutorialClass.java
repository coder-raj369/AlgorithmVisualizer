/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.LinkedList;
/**
 *
 * @author rajpandit
 */
public class TutorialClass {
    public static void main(String[] agrs){
        LinkedList<String> brands = new LinkedList();
        brands.add("Caliber");
        brands.add("GoldStar");
        brands.add("Faithworks");
        brands.add("Dulla");
        System.out.println("Brands" + brands);
        brands.set(0, "Caliber");
        System.out.println("First bran in LinkedList" + brands.get(0));
//        brands.remove(2);
        System.out.println("Brands: " + brands);
        System.out.println("Total Brands: " + brands.size());
        brands.addFirst("Abibas");
        System.out.println("Brands: " +brands);
        
    }
    
}
