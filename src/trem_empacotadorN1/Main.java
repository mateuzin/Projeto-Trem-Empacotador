package trem_empacotadorN1;

import java.awt.EventQueue;
import java.util.concurrent.Semaphore;
import GUI.Interface;

import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;



class Main extends Thread { 
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{

		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
		
	}
}


