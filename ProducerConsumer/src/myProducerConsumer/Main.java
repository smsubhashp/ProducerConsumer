package myProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> sharedQueue = new LinkedList<Integer>();
		Consumer consumer = new Consumer(sharedQueue);
		Producer producer = new Producer(sharedQueue);
		
		Thread thread = new Thread(producer);
		Thread thread2 = new Thread(consumer);
		thread.start();
		thread2.start();

	}

}
