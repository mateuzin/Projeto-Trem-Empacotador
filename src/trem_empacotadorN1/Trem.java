package trem_empacotadorN1;

import java.util.concurrent.Semaphore;

class Trem extends Thread {
	public double tv; // tv = tempo de viagem

	public Trem(double tv) {
		this.tv = tv * 1000;
	}

	public void run() {
		while (true) {

			if (armazem.Armazem_atual < armazem.N) {
				try {
					System.out.println("Trem está esperando empacotamento");
					Semaforo.armazemSuficiente.acquire(); // bota a thread trem para dormir
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			long time = System.currentTimeMillis();

			System.out.println("Trem pegou a carga e iniciou viagem");

			try {
				Semaforo.mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (armazem.Armazem_atual >= armazem.N) {// Se o número de caixas já empacotadas for maior do que N

				armazem.Armazem_atual = armazem.Armazem_atual - armazem.N; // Retira o número de caixas que o trem
																			// precisa | PARTE CRITICA

			}

			Semaforo.mutex.release();
			
			System.out.println("Número de caixas no armazem atualmente: " + armazem.Armazem_atual);

			while (System.currentTimeMillis() - time < tv / 2) {
			}

			System.out.println("Trem chegou em B");
			System.out.println("Trem está voltando para A");

			while (System.currentTimeMillis() - time < tv) {
			}

			System.out.println("Trem chegou em A novamente");
			Semaforo.armazemLim.release(); // acorda empacotador
		}

	}
}