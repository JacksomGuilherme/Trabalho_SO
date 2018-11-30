package Ex3_IDThread;

public class Main {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {

			Threads threadId = new Threads();
			threadId.start();

		}
	}

}
