package trem_empacotadorN1;
import java.util.concurrent.Semaphore;


class Main extends Thread { 
	
	public static void main(String[] args) {
		
		Trem piui = new Trem (8); // trem demora x tempo para ir de A para B
		
		empacotador t1 = new empacotador ("e1",3); 
		empacotador t2 = new empacotador ("e2",4); 
		empacotador t3 = new empacotador ("e3",7);
		
		piui.start();
		
		t1.start (); 
		t2.start ();
		t3.start();
		
	}
}