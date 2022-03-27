package trem_empacotadorN1;

import GUI.Interface2;

public class empacotador extends Thread {
	
	public int te;
	public static String resposta = "/GUI/empacotadorEmpacotando.png";

	public empacotador(int te) {
		
		this.te = te * 1000; // tempo de empacotamento para segundos
		
	}

	public void run() {
		while (true) {

			long time = System.currentTimeMillis();

			while (System.currentTimeMillis() - time < te) {} //
			
			try {
				if(Semaforo.armazemLim.availablePermits()==0) {
					
					System.out.println("Armazem lotado, " + "Empacotador " + getName() + " " + "  vai dormir ");
					resposta = "/GUI/empacotadorDormindo.png";
					
				}
				resposta = "/GUI/empacotadorDormindo.png";
				Semaforo.armazemLim.acquire();// bota empacotador para dormir ao chegar no Limite do armazem

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				Semaforo.mutex.acquire();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
			armazem.Armazem_atual++; //PARTE CRITICA
			
			resposta = "/GUI/empacotadorDormindo.png";
			System.out.println("Empacotador " + getName() + " " + "embalou uma caixa ");
			System.out.println("Número de caixas no armazem atualmente: " + armazem.Armazem_atual);

			Semaforo.mutex.release();

			if (armazem.Armazem_atual >= armazem.N) {
				Semaforo.armazemSuficiente.release(); //acorda Trem
			}		
		}
	}
}
