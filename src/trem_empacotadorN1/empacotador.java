package trem_empacotadorN1;


class empacotador extends Thread { 
	public double te;
	
	public empacotador (String id,double te) { 
		super (id); //identificador do empacotador
		this.te = te*1000; //te = tempo de empacotamento 
	} 
	
	public void run () { 
			while (true) {
				
				if(armazem.Armazem_atual >= armazem.Armazem_max) {
    				try {
    					System.out.println("Armazem lotado, " + "Empacotador " + getName() +" " + "  vai dormir ");
    					Semaforo.armazemLim.acquire();//bota empacotador para dormir 
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
				
				long time = System.currentTimeMillis();
				while(System.currentTimeMillis() - time < te){}
    			System.out.println ("Empacotador " + getName() +" " + "terminou uma caixa ");
    			armazem.Armazem_atual++;
    			
    			System.out.println(armazem.Armazem_atual);
    		}
		}
}
