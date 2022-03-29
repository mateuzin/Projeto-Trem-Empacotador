
package GUI;

import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import KentHipos.Kensoft;

import java.awt.Color;

public class Interface2 extends JFrame {
	public JFrame frame;
	public static String Dormindo = "/GUI/empacotadorDormindo.png";
	public static String Empacotando = "/GUI/empacotadorEmpacotando.png";
	public static String Terminou = "/GUI/empacotadorEmpacotado.png";
	public static String Inativo = "/GUI/empacotadorvazio.png";
	public static String Voltando = "/GUI/empacotadorSemCaixa(voltando).png";
	private JLabel[] empacotadores;
	private JProgressBar progressBar;
	private JLabel imagem_trem;

	public static void main(String[] args) {
	}

	public Interface2() {
		this.initialize();
	}

	public void initialize() {
		
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 1516, 789);
		this.frame.setDefaultCloseOperation(3);
		this.frame.setResizable(false);
		this.frame.getContentPane().setLayout((LayoutManager) null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		imagem_trem = new JLabel("");
		imagem_trem.setIcon(new ImageIcon(Interface2.class.getResource("/GUI/trem.png")));
		imagem_trem.setBounds(-14, 580, 168, 56);
		this.frame.getContentPane().add(imagem_trem);
		this.empacotadores = new JLabel[10];
		
		

		JLabel label;
		for (int i = 0; i < 10; ++i) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(Interface2.class.getResource(Inativo)));
			label.setBounds(69 + 144 * i, 33, 64, 89);
			this.frame.getContentPane().add(label);
			this.empacotadores[i] = label;
		}
		
		UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		progressBar.setBounds(27, 389, 1446, 40);
		progressBar.setMaximum(Interface.MaxArmazem);
		progressBar.setString("Aguardando valores");
		frame.getContentPane().add(progressBar);

		JLabel Cenario = new JLabel("");
		Cenario.setIcon(new ImageIcon(Interface2.class.getResource("/GUI/cenarioOK.jpg")));
		Cenario.setBounds(0, 0, 1500, 750);
		this.frame.getContentPane().add(Cenario);
		
		
		
		
	}

	public void changeImg(int empacotador, String img) {
		this.empacotadores[empacotador - 1].setIcon(new ImageIcon(Interface2.class.getResource(img)));
	}
	
	public void progress(int atual) {
		if(atual == Interface.MaxArmazem) {
			this.progressBar.setString("ARMAZEM LOTADO");
		}
		else {
			this.progressBar.setString("Número de caixas no deposito = " + String.valueOf(atual));
		}
		
		this.progressBar.setValue(atual);
		
	}
	
	public void sentidoTrem(String receba,double tv) {
		Kensoft animate = new Kensoft();
		if(receba == "Direita") {
			animate.jLabelXRight(-14, 1332, 1, 1, imagem_trem);
		}
		
		if(receba == "Esquerda") {
			animate.jLabelXLeft(1332, -14, 1, 1, imagem_trem);
		}
	}
	
	
}
