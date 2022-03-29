package trem_empacotadorN1;

import java.util.concurrent.Semaphore;

import GUI.Interface;

public class Trem extends Thread {
	public static double tv; // tv = tempo de viagem
	public Interface Progress;
	public Interface SentidoT;

	public Trem(double tv, Interface Progress, Interface SentidoT) {
		this.tv = tv * 1000;
		this.Progress = Progress;
		this.SentidoT = SentidoT;
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

			try {
				Semaforo.mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (armazem.Armazem_atual >= armazem.N) {// Se o número de caixas já empacotadas for maior do que N

				armazem.Armazem_atual = armazem.Armazem_atual - armazem.N; // Retira o número de caixas que o trem
				this.Progress.Progress(armazem.Armazem_atual);
				Semaforo.armazemLim.release(armazem.N); // acorda empacotador // precisa | PARTE CRITICA
				System.out.println("Trem pegou a carga e iniciou viagem");
				this.SentidoT.SentidoT("Direita",tv);
				System.out.println("Número de caixas atualmente: " + armazem.Armazem_atual);

			}

			Semaforo.mutex.release();
			
			
			long time = System.currentTimeMillis();
			while (System.currentTimeMillis() - time < tv / 2) {
			}
			
			System.out.println("Trem chegou em B");
			System.out.println("Trem está voltando para A");
			
			while (System.currentTimeMillis() - time < tv) {
			}
			this.SentidoT.SentidoT("Esquerda",tv);
			System.out.println("Trem chegou em A novamente");

		}

	}
}