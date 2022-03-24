package trem_empacotadorN1;
import java.util.concurrent.Semaphore;


public class Semaforo {
	
	public static Semaphore armazemLim = new Semaphore(armazem.M); //Armazem no maximo
	
	public static Semaphore armazemSuficiente = new Semaphore(0); // Armazem com caixas o bastante para o trem
	
	public static Semaphore mutex = new Semaphore(1);
	
}
