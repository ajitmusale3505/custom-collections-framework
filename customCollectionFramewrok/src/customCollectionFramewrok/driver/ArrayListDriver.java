package customCollectionFramewrok.driver;

import customCollectionFramewrok.list.ArrayList;

public class ArrayListDriver {
 
	public static void main(String[] args) {
		 
		  ArrayList<Integer> list = new ArrayList<>();

	        System.out.println("=== ADD ELEMENTS ===");
	        list.add(10);
	        list.add(20);
	        list.add(30);
	        System.out.println(list);

	        System.out.println("\n=== ADD FIRST ===");
	        list.addFirst(5);
	        System.out.println(list);

	        System.out.println("\n=== ADD LAST ===");
	        list.addLast(40);
	        System.out.println(list);

	        System.out.println("\n=== GET ELEMENT ===");
	        System.out.println("Element at index 2: " + list.get(2));

	        System.out.println("\n=== SET ELEMENT ===");
	        list.set(2, 99);
	        System.out.println(list);

	        System.out.println("\n=== REMOVE BY INDEX ===");
	        list.remove(2);
	        System.out.println(list);

	        System.out.println("\n=== REMOVE LAST ===");
	        list.removeLast();
	        System.out.println(list);

	        System.out.println("\n=== SIZE & CAPACITY ===");
	        System.out.println("Size: " + list.size());
	        System.out.println("Capacity: " + list.capacity());

	        System.out.println("\n=== CONTAINS ===");
	        System.out.println("Contains 20? " + list.contains(20));
	        System.out.println("Contains 100? " + list.contains(100));

	        System.out.println("\n=== INDEX OF ===");
	        list.add(20);
	        System.out.println(list);
	        System.out.println("First index of 20: " + list.indexOf(20));
	        System.out.println("Last index of 20: " + list.lastIndexOf(20));

	        System.out.println("\n=== GET FIRST & LAST ===");
	        System.out.println("First: " + list.getFirst());
	        System.out.println("Last: " + list.getLast());

	        System.out.println("\n=== TRIM TO SIZE ===");
	        list.trimToSize();
	        System.out.println("Capacity after trim: " + list.capacity());

	        System.out.println("\n=== CLEAR ===");
	        list.clear();
	        System.out.println("After clear: " + list);
	        System.out.println("Is empty? " + list.isEmpty());

	        System.out.println("\n=== EXCEPTION TESTS ===");

	        try {
	            list.get(0);
	        } catch (Exception e) {
	            System.out.println("Exception caught (get): " + e.getMessage());
	        }

	        try {
	            list.remove(0);
	        } catch (Exception e) {
	            System.out.println("Exception caught (remove): " + e.getMessage());
	        }

	        try {
	            list.getFirst();
	        } catch (Exception e) {
	            System.out.println("Exception caught (getFirst): " + e.getMessage());
	        }

	        try {
	            list.getLast();
	        } catch (Exception e) {
	            System.out.println("Exception caught (getLast): " + e.getMessage());
	        }

	        System.out.println("\n=== LARGE DATA TEST (RESIZING) ===");
	        ArrayList<Integer> bigList = new ArrayList<>(2);
	        for (int i = 1; i <= 20; i++) {
	            bigList.add(i);
	        }
	        System.out.println(bigList);
	        System.out.println("Size: " + bigList.size());
	        System.out.println("Capacity: " + bigList.capacity());

	        System.out.println("\n=== NULL HANDLING TEST ===");
	        ArrayList<String> strList = new ArrayList<>();
	        strList.add("A");
	        strList.add(null);
	        strList.add("B");
	        System.out.println(strList);
	        System.out.println("Contains null? " + strList.contains(null));
	        System.out.println("Index of null: " + strList.indexOf(null));

	        System.out.println("\n=== END OF TEST ===");
	        
	        
	        
	}
}
