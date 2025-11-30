/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rajpandit
 */


import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;



public class week5_Map {

    private static void demonstrateHashMap() {
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Putting key-value pairs
        hashMap.put(101, "John");
        hashMap.put(102, "Alice");
        hashMap.put(103, "Bob");
        hashMap.put(102, "Eve");   // Overwrites previous value for key 102
        hashMap.put(null, "NullKey");   // Allows null key
        hashMap.put(104, null);         // Allows null value

        System.out.println("HashMap: " + hashMap);
        System.out.println("Size: " + hashMap.size());
        System.out.println("Value for key 102: " + hashMap.get(102));
        System.out.println("Value for key 999: " + hashMap.get(999)); // returns null
        System.out.println("Contains key 103? " + hashMap.containsKey(103));
        System.out.println("Contains value 'Bob'? " + hashMap.containsValue("Bob"));

        // Remove entry
        hashMap.remove(101);
        System.out.println("After removing key 101: " + hashMap);

        // Iterate over entries
        System.out.println("Iterating using entrySet():");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // Iterate over keys
        System.out.print("Keys: ");
        for (Integer key : hashMap.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();

        // Iterate over values
        System.out.println("Values: " + hashMap.values());
    }

    private static void demonstrateLinkedHashMap() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(5, "Five");
        linkedHashMap.put(1, "One");
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(1, "Uno");  // Overwrites "One"

        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);

        // Access-order mode example (optional - not default)
        LinkedHashMap<Integer, String> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put(1, "A");
        accessOrderMap.put(2, "B");
        accessOrderMap.put(3, "C");
        accessOrderMap.get(2);  // Moves 2 to end (most recently accessed)
        accessOrderMap.get(1);
        System.out.println("LinkedHashMap with access-order: " + accessOrderMap);
    }

    private static void demonstrateTreeMap() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(300, "Charlie");
        treeMap.put(100, "Alice");
        treeMap.put(200, "Bob");
        treeMap.put(150, "David");

        // treeMap.put(null, "NullKey");  // Throws NullPointerException!
        System.out.println("TreeMap (sorted by keys): " + treeMap);
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println("Entry with smallest key >= 175: " + treeMap.ceilingEntry(175));
        System.out.println("Entries with key < 200: " + treeMap.headMap(200));
        System.out.println("Entries with key >= 150: " + treeMap.tailMap(150));

        treeMap.remove(100);
        System.out.println("After removing key 100: " + treeMap);
    }

    public static void main(String[] args) {
        System.out.println("=== HashMap Demo (Unordered) ===");
        demonstrateHashMap();

        System.out.println("\n=== LinkedHashMap Demo (Insertion Order) ===");
        demonstrateLinkedHashMap();

        System.out.println("\n=== TreeMap Demo (Sorted by Keys) ===");
        demonstrateTreeMap();
    }

}
