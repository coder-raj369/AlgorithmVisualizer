/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
//import java.util.concurrent.TimeUnit;


public class week5 {

    private static void demonstrateHashSet() {
        HashSet<String> hashSet = new HashSet<>();

        // Adding elements
        hashSet.add("c");
        hashSet.add("a");
        hashSet.add("b");
        
        hashSet.add("Shoes");  // Duplicate - will be ignored
        hashSet.add(null);     // HashSet allows one null

        System.out.println("HashSet: " + hashSet);
        System.out.println("Size: " + hashSet.size());
        System.out.println("Contains 'boot'? " + hashSet.contains("boot"));
        System.out.println("Contains 'heels'? " + hashSet.contains("heels"));
        // Removing element
        hashSet.remove("Sandel");
        System.out.println("After removing Sandel: " + hashSet);

        // Iteration
        System.out.print("Iterating HashSet: ");
        for (String things : hashSet) {
            System.out.print(things + " ");
        }
        System.out.println();
    }

    private static void demonstrateLinkedHashSet() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Zebra");
        linkedHashSet.add("Yak");
        linkedHashSet.add("Xerox");
        linkedHashSet.add("Yak");  // Duplicate ignored
        linkedHashSet.add(null);   // Allows null

        System.out.println("LinkedHashSet (maintains insertion order): " + linkedHashSet);
        System.out.println("Contains 'Xerox'? " + linkedHashSet.contains("Xerox"));

        linkedHashSet.remove(null);
        System.out.println("After removing null: " + linkedHashSet);
    }

    private static void demonstrateTreeSet() {
        TreeSet<String> treeSet = new TreeSet<>();

        // Adding elements (automatically sorted)
        treeSet.add("Mango");
        treeSet.add("Apple");
        treeSet.add("Guava");
        treeSet.add("Banana");
        // treeSet.add(null);  // Throws NullPointerException!

        System.out.println("TreeSet (natural ordering): " + treeSet);
        System.out.println("First element: " + treeSet.first());
        System.out.println("Last element: " + treeSet.last());
        System.out.println("Elements less than 'Guava': " + treeSet.headSet("Guava"));
        System.out.println("Elements greater than or equal to 'Guava': " + treeSet.tailSet("Guava"));

        treeSet.remove("Apple");
        System.out.println("After removing 'Apple': " + treeSet);
    }

    public static void main(String[] args) {
        System.out.println(" HashSet Demo (Unordered, No duplicates)");
        demonstrateHashSet();

        System.out.println("\n__LinkedHashSet Demo (Insertion Order Preserved)__ ");
        demonstrateLinkedHashSet();

        System.out.println("\n__TreeSet Demo (Sorted Order, No duplicates)__");
        demonstrateTreeSet();
    }

}