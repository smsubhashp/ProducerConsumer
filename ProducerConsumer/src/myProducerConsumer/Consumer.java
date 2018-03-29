package myProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {

	private Queue<Integer> sharedQueue;
	

	public Consumer(Queue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}


	@Override
	public void run() {
		
		while(true){
			synchronized (sharedQueue) {
				while(sharedQueue.isEmpty()){
					try {
						System.out.println("Consumer is waiting for data to be produce");
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int data = sharedQueue.poll();
				System.out.println("Consumer: "+ data);
				/*try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				sharedQueue.notify();
			}
		}

	}

}
