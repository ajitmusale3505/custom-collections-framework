package customCollectionFramewrok.driver;

import customCollectionFramewrok.list.ArrayList;

public class ArrayListDriver {
 
	public static void main(String[] args) {
		 
		 ArrayList<Integer> list = new ArrayList<>();

	        // 🔹 Test add()
	        System.out.println("---- Testing add() ----");
	        for (int i = 1; i <= 15; i++) {
	            list.add(i);
	        }
	        list.add(2);
	        System.out.println("List: " + list);
	        System.out.println("Size: " + list.size());
	        System.out.println("Capacity: " + list.capacity());

	        // 🔹 Test get()
	        System.out.println("\n---- Testing get() ----");
	        System.out.println("Element at index 5: " + list.get(5));

	        // 🔹 Test remove()
	        System.out.println("\n---- Testing remove() ----");
	        System.out.println("Removed element: " + list.remove(5));
	        System.out.println("List after removal: " + list);
	        System.out.println("Size: " + list.size());

	        // 🔹 Test ensureCapacity()
	        System.out.println("\n---- Testing ensureCapacity() ----");
	        list.ensureCapacity(50);
	        System.out.println("Capacity after ensureCapacity(50): " + list.capacity());

	        // 🔹 Test trimToSize()
	        System.out.println("\n---- Testing trimToSize() ----");
	        list.trimToSize();
	        System.out.println("Capacity after trimToSize(): " + list.capacity());

	        // 🔹 Test index out of bounds
	        System.out.println("\n---- Testing Index Check ----");
	        try {
	            list.get(100);
	        } catch (Exception e) {
	            System.out.println("Exception caught: " + e.getMessage());
	        }

	        // 🔹 Final State
	        System.out.println("\n---- Final List ----");
	        System.out.println(list);
	        
//	        System.out.println("\n---- Clear List ----");
//	        list.clear();
//	        System.out.println(list);
//	        System.out.println(list.capacity());
	        
	        System.out.println(list.contains(16));
	        
	        System.out.println("----------- indexOf() : ------------");
	        System.out.println(list.indexOf(16));
	        
	        System.out.println("----------- lastIndexOf() : ------------");
	        System.out.println(list.lastIndexOf(2));    
		
	        System.out.println("\n---- After Adding Elements ----");
	        System.out.println("List: " + list);
	        System.out.println("Size: " + list.size());

	        // 🔹 Test isEmpty()
	        System.out.println("\n---- Testing isEmpty() ----");
	        System.out.println("Is Empty: " + list.isEmpty());

	        // 🔹 Test contains()
	        System.out.println("\n---- Testing contains() ----");
	        System.out.println("Contains 20: " + list.contains(20));
	        System.out.println("Contains 99: " + list.contains(99));

	        // 🔹 Test indexOf()
	        System.out.println("\n---- Testing indexOf() ----");
	        System.out.println("First index of 1: " + list.indexOf(1));
	        System.out.println("Index of 2: " + list.indexOf(2));

	        // 🔹 Test lastIndexOf()
	        System.out.println("\n---- Testing lastIndexOf() ----");
	        System.out.println("Last index of 20: " + list.lastIndexOf(2));
	        System.out.println("Last index of 99: " + list.lastIndexOf(9));

	        // 🔹 Test getFirst() and getLast()
	        System.out.println("\n---- Testing getFirst() & getLast() ----");
	        System.out.println("First element: " + list.getFirst());
	        System.out.println("Last element: " + list.getLast());

	        // 🔹 Test set()
	        System.out.println("\n---- Testing set() ----");
	        System.out.println("Replacing index 2 with 99");
	        Integer oldValue = list.set(2, 99);
	        System.out.println("Old value: " + oldValue);
	        System.out.println("Updated List: " + list);

	        // 🔹 Edge Case: Empty List for getFirst/getLast
	        System.out.println("\n---- Testing Exception Case ----");
	        ArrayList<Integer> emptyList = new ArrayList<>();

	        try {
	            emptyList.getFirst();
	        } catch (Exception e) {
	            System.out.println("getFirst() Exception: " + e.getMessage());
	        }

	        try {
	            emptyList.getLast();
	        } catch (Exception e) {
	            System.out.println("getLast() Exception: " + e.getMessage());
	        }
	}
}
