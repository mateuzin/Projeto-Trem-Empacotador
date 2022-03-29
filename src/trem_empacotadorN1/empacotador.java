package trem_empacotadorN1;

import GUI.Interface;
import GUI.Interface2;

public class empacotador extends Thread {
	private int id;
	public int te;
	public Interface mainInterface;
	public Interface Progress;

	public empacotador(int id, int te, Interface mainInterface, Interface Progress) {
		this.id = id;
		this.te = te * 1000;
		this.mainInterface = mainInterface;
		this.Progress = Progress;
	}

	public void run() {
		while (true) {
			
			
			long time = System.currentTimeMillis();

			while (System.currentTimeMillis() - time < (long) this.te/2) {
				this.mainInterface.changeImg(this.id, Interface2.Empacotando);
			}
			while (System.currentTimeMillis() - time < (long) this.te) {
				this.mainInterface.changeImg(this.id, Interface2.Terminou);
			}
			

			try {
				if (Semaforo.armazemLim.availablePermits() == 0) {
					System.out.println("Armazem lotado, Empacotador " + id + " " + "  vai dormir ");
					this.mainInterface.changeImg(this.id, Interface2.Dormindo);
				}

				Semaforo.armazemLim.acquire(); //Dorme o empacotador 
			} catch (InterruptedException var5) {
				var5.printStackTrace();
			}
			
			
			try {
				Semaforo.mutex.acquire();
			} catch (InterruptedException var4) {
				var4.printStackTrace();
			}

			++armazem.Armazem_atual;

			System.out.println("Empacotador " + this.getName() + " " + "embalou uma caixa ");
			System.out.println("Número de caixas no armazem atualmente: " + armazem.Armazem_atual);
			this.Progress.Progress(armazem.Armazem_atual);
			Semaforo.mutex.release();
			if (armazem.Armazem_atual >= armazem.N) {
				Semaforo.armazemSuficiente.release();//Acorda o trem
			}
		}
	}
}