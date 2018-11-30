package Ex3_IDThread;

public class Threads extends Thread {

	private int thread;

	public void run() {
		valorThread();
	}

	public void valorThread() {
		thread = (int) getId();
		System.out.println("Thread " + thread + " rodou");
	}

}
