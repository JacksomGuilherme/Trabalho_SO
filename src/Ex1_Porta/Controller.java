package Ex1_Porta;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
	private int pessoa;
	private Semaphore semaforo;
	private int Vet[] = new int[4];

	public Controller(int pessoa, Semaphore semaforo) {

		this.semaforo = semaforo;
		this.pessoa = pessoa; 

	}

	public void run() {

		passosPessoa();

	}

	public void passosPessoa() {

		int passos = (int) (4 + Math.random() * 3);
		while (Vet[pessoa] < 200) {
			Vet[pessoa] += passos;
			if (Vet[pessoa] > 199) {
				System.out.println("Pessoa #" + (pessoa + 1)
						+ " Chegou Na Porta\n");
				try {
					semaforo.acquire();
					passaPorta();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			}
		}

	}

	public void passaPorta() {
		int demora = (int) (1 + Math.random() * 2);
		try {
			Thread.sleep(demora);
			System.out.println("Pessoa #" + (pessoa + 1) + " Passou Na Porta\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
