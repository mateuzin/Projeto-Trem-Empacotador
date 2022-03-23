package trem_empacotadorN1;
import java.util.concurrent.Semaphore;

class Trem extends Thread { 
	public double tv;
	
	public Trem (double tv) { 
		this.tv = tv*1000; //tv = tempo de empacotamento 
	} 
	
	public void run () { 
			while (true) { 
				
				if(armazem.Armazem_atual < armazem.CargaT) {
    				try {
    					System.out.println("Trem está esperando empacotamento");
    					Semaforo.armazemVazio.acquire();//bota a thread trem para dormir
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
				
				long time = System.currentTimeMillis();
				
    			System.out.println ("Trem pegou a carga e iniciou viagem");
    			
    			while(System.currentTimeMillis() - time < tv/2){}
    			
    			System.out.println ("Trem chegou em B");
    			System.out.println ("Trem está voltando para A");
    			
    			while(System.currentTimeMillis() - time < tv){}
    			
    			System.out.println ("Trem chegou em A novamente");
    			
    			if(armazem.Armazem_atual>=armazem.CargaT)
    			armazem.Armazem_atual = armazem.Armazem_atual - armazem.CargaT;
    			
    			System.out.println(armazem.Armazem_atual);
    			
    		}
		}
}


