package customCollectionFramewrok.driver;

import customCollectionFramewrok.queue.PriorityQueue;

public class PriorityQueueDriver{

	public static void main(String[] args) {
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		System.out.println(q);
		q.add(10);
		System.out.println(q);
		q.add(30);
		q.add(100);
		q.add(130);
		q.add(50);
		System.out.println(q);
		
	}
	
	
	
	 
}
