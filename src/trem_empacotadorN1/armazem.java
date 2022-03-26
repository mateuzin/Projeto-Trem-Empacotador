package trem_empacotadorN1;
import java.util.concurrent.Semaphore;
import GUI.Interface;

public class armazem {
	public static int N = GUI.Interface.CargaTrem; //Carga que o trem consegue transportar  
	public static int Armazem_atual; // numero de caixas que tem atualmente no armazem
	public static int M = GUI.Interface.MaxArmazem; // maximo que cabe no armazem 
}
