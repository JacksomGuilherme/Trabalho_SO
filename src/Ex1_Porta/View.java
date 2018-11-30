package Ex1_Porta;

import java.util.concurrent.Semaphore;

public class View {


	
	public static void main(String[] args) {
		
		Semaphore sPessoa = new Semaphore(1);
		
		for(int i = 0; i < 4;i++){
			Controller tPessoa = new Controller(i, sPessoa);
			tPessoa.start();
		}
		

	}

}
