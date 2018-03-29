package myProducerConsumer;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	
	private Queue<Integer> sharedQueue;
	private final int MAX_SIZE = 5;
	

	public Producer(Queue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}


	@Override
	public void run() {
		
		while(true){
			synchronized (sharedQueue) {
				while(sharedQueue.size() == 5){
					try {
						System.out.println("Producer is waiting to consume object by consumer");
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int data = random.nextInt(MAX_SIZE);
				sharedQueue.add(data);
				System.out.println("Produce: "+ data);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sharedQueue.notify();
			}
		}

	}

}
