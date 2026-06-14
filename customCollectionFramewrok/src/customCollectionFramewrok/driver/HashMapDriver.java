package customCollectionFramewrok.driver;

import customCollectionFramewrok.list.HashMap;

public class HashMapDriver {
	public static void main(String[] args) {
		
		HashMap<Integer, String> hm = new HashMap<>();
		
		hm.put(101, "SUMIT");
		hm.put(102, "AMIT");
		hm.put(103, "love");
		hm.put(104, "kush");
		
		System.out.println("101 : "+ hm.get(101));
		System.out.println("102 : "+ hm.get(102));
		System.out.println("103 : "+ hm.get(103));
		System.out.println("104 : "+ hm.get(104));
	}
}
