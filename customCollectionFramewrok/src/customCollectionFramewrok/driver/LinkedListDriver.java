package customCollectionFramewrok.driver;

import customCollectionFramewrok.list.LinkedList;

public class LinkedListDriver {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
//		list.add(0, 100);
//		list.add(2,300);
//		list.add(4,400);
//		list.addFirst(99);
//		list.addLast(101);
////		list.clear();
//		System.out.println(list.contains(99));
//		System.out.println(list.contains(999));
//		System.out.println(list.contains(101));
//		System.out.println(list.contains(400));
//		System.out.println(list);
//		
//		java.util.LinkedList<Integer> e = new java.util.LinkedList<>();
//		e.add(20);
//		e.add(30);
//		e.add(2, 39);
//		System.out.println(e.get(3));
//		list.add(9, 23);
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
		
		
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list);
	}
}
