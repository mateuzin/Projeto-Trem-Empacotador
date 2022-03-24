package trem_empacotadorN1;

class empacotador extends Thread {
	
	public double te;

	public empacotador(String id, double te) {
		
		super(id); // identificador do empacotador
		this.te = te * 1000; // tempo de empacotamento para segundos
		
	}

	public void run() {
		while (true) {

			long time = System.currentTimeMillis();

			while (System.currentTimeMillis() - time < te) {} //
			
			try {
				Semaforo.armazemLim.acquire();// bota empacotador para dormir ao chegar no Limite do armazem

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			/*if (armazem.Armazem_atual >= armazem.M) {
				
				System.out.println("Armazem lotado, " + "Empacotador " + getName() + " " + "  vai dormir ");
					
			}*/

			try {
				Semaforo.mutex.acquire();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
			armazem.Armazem_atual++; //PARTE CRITICA
			
			System.out.println("Empacotador " + getName() + " " + "embalou uma caixa ");
			System.out.println("Número de caixas no armazem atualmente: " + armazem.Armazem_atual);

			Semaforo.mutex.release();

			if (armazem.Armazem_atual >= armazem.N) {
				Semaforo.armazemSuficiente.release(); //acorda Trem
			}		
		}
	}
}
