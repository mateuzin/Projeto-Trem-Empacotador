package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import trem_empacotadorN1.empacotador;

public class Interface2 extends JFrame{

	
	public JFrame frame;
	public static String Dormindo = "/GUI/empacotadorDormindo.png";
	public static String Empacotando = "/GUI/empacotadorEmpacotando.png";
	public static String Terminou = "/GUI/empacotadorEmpacotado.png";
	public static String Inativo = "/GUI/empacotadorInativo.png";
	public static String Voltando = "/GUI/empacotadorSemCaixa(voltando).png";
	
	public static String dormindo = trem_empacotadorN1.empacotador.resposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 */
	public Interface2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1516, 789);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false) ;
		frame.getContentPane().setLayout(null);
		
		JLabel imagem_trem = new JLabel("");
		imagem_trem.setIcon(new ImageIcon(Interface2.class.getResource("/GUI/trem.png")));
		imagem_trem.setBounds(-14, 580, 168, 56);
		frame.getContentPane().add(imagem_trem);
		
		JLabel EmpacotadorT1 = new JLabel("");
		EmpacotadorT1.setIcon(new ImageIcon(Interface2.class.getResource(dormindo)));
		EmpacotadorT1.setBounds(69, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT1);
		
		JLabel EmpacotadorT2 = new JLabel("");
		EmpacotadorT2.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT2.setBounds(212, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT2);
		
		JLabel EmpacotadorT3 = new JLabel("");
		EmpacotadorT3.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT3.setBounds(360, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT3);
		
		JLabel EmpacotadorT4 = new JLabel("");
		EmpacotadorT4.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT4.setBounds(502, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT4);
		
		JLabel EmpacotadorT5 = new JLabel("");
		EmpacotadorT5.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT5.setBounds(646, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT5);
		
		JLabel EmpacotadorT6 = new JLabel("");
		EmpacotadorT6.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT6.setBounds(786, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT6);
		
		JLabel EmpacotadorT7 = new JLabel("");
		EmpacotadorT7.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT7.setBounds(935, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT7);
		
		JLabel EmpacotadorT8 = new JLabel("");
		EmpacotadorT8.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT8.setBounds(1075, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT8);
		
		JLabel EmpacotadorT9 = new JLabel("");
		EmpacotadorT9.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT9.setBounds(1227, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT9);
		
		JLabel EmpacotadorT10 = new JLabel("");
		EmpacotadorT10.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
		EmpacotadorT10.setBounds(1368, 37, 64, 89);
		frame.getContentPane().add(EmpacotadorT10);
		
		JLabel Cenario = new JLabel("");
		Cenario.setIcon(new ImageIcon(Interface2.class.getResource("/GUI/cenarioOK.jpg")));
		Cenario.setBounds(0, 0, 1500, 750);
		frame.getContentPane().add(Cenario);
		
		JLabel label = new JLabel("New label");
		label.setBounds(76, 278, 46, 14);
		frame.getContentPane().add(label);
		
		
		
		
		
	}
}
