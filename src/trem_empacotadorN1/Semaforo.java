package trem_empacotadorN1;
import java.util.concurrent.Semaphore;


public class Semaforo {
	
	public static Semaphore armazemLim = new Semaphore(armazem.Armazem_max);
	
	public static Semaphore armazemVazio = new Semaphore(0);
	
	public static Semaphore mutex = new Semaphore(1);
	
}
