package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.sound.sampled.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import trem_empacotadorN1.Trem;
import trem_empacotadorN1.empacotador;
import javax.swing.DefaultComboBoxModel;


public class Interface extends JFrame{

	public JFrame frame;
	public JTextField TempoDeV_field;
	public JTextField CargaT_field;
	public JTextField MaxDeposito_field;
	public static int TempoTrem,CargaTrem,MaxArmazem;
	public int E1,E2,E3,E4,E5,E6,E7,E8,E9,E10;
	public int aux;
	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 399, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Tempo de viagem");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 152, 22);
		frame.getContentPane().add(lblNewLabel);
		
		TempoDeV_field = new JTextField();
		TempoDeV_field.setBounds(10, 37, 59, 20);
		frame.getContentPane().add(TempoDeV_field);
		TempoDeV_field.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Carga Trem");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 67, 91, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		CargaT_field = new JTextField();
		CargaT_field.setBounds(10, 88, 59, 20);
		frame.getContentPane().add(CargaT_field);
		CargaT_field.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Carga max\u00EDma do Deposito");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 119, 176, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		MaxDeposito_field = new JTextField();
		MaxDeposito_field.setBounds(10, 144, 59, 20);
		frame.getContentPane().add(MaxDeposito_field);
		MaxDeposito_field.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero de Empacotadores");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(187, 15, 186, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox NumeroEmpacotadores = new JComboBox();
		NumeroEmpacotadores.setMaximumRowCount(6);
		NumeroEmpacotadores.setForeground(Color.BLACK);
		NumeroEmpacotadores.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		NumeroEmpacotadores.setBounds(187, 36, 59, 22);
		frame.getContentPane().add(NumeroEmpacotadores);
		
		JButton btnNewButton = new JButton("Prosseguir");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{

					TempoTrem =Integer.parseInt(TempoDeV_field.getText());
					CargaTrem =Integer.parseInt(CargaT_field.getText());
					MaxArmazem =Integer.parseInt(MaxDeposito_field.getText());
					
				}catch(NumberFormatException ex) {
				   
					JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");
					JOptionPane.showMessageDialog(null,"Programa encerrando");
					System.exit(0);
					
				}
				Trem piui = new Trem (TempoTrem); // trem demora x tempo para ir de A para B
				
				aux = NumeroEmpacotadores.getSelectedIndex()+1;
				
				switch (aux) 
				{
					case 1: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						
						empacotador a1 = new empacotador (E1);
						piui.start();
						a1.start (); 
						break;
					case 2: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						
						empacotador b1 = new empacotador (E1);
						empacotador b2 = new empacotador (E2); 
						
						piui.start();
						b1.start (); 
						b2.start ();
						break;
					case 3: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							E3 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E3"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						
						empacotador c1 = new empacotador (E1);
						empacotador c2 = new empacotador (E2); 
						empacotador c3 = new empacotador (E3);
						
						piui.start();
						c1.start (); 
						c2.start ();
						c3.start();	
						break;
					case 4: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							E3 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E3"));
							E4 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E4"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						
						empacotador d1 = new empacotador (E1);
						empacotador d2 = new empacotador (E2); 
						empacotador d3 = new empacotador (E3);
						empacotador d4 = new empacotador (E4); 
						
						piui.start();
						d1.start (); 
						d2.start ();
						d3.start();	
						d4.start (); 
						break;
					case 5: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							E3 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E3"));
							E4 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E4"));
							E5 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E5"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						empacotador e1 = new empacotador (E1);
						empacotador e2 = new empacotador (E2); 
						empacotador e3 = new empacotador (E3);
						empacotador e4 = new empacotador (E4); 
						empacotador e5 = new empacotador (E5); 
						
						piui.start();
						e1.start (); 
						e2.start ();
						e3.start();	
						e4.start (); 
						e5.start ();
						break;
					case 6: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							E3 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E3"));
							E4 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E4"));
							E5 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E5"));
							E6 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E6"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						
						empacotador f1 = new empacotador (E1);
						empacotador f2 = new empacotador (E2); 
						empacotador f3 = new empacotador (E3);
						empacotador f4 = new empacotador (E4); 
						empacotador f5 = new empacotador (E5); 
						empacotador f6 = new empacotador (E6);
						
						piui.start();
						f1.start (); 
						f2.start ();
						f3.start();	
						f4.start (); 
						f5.start ();
						f6.start();	
						break;
					case 7: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							E3 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E3"));
							E4 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E4"));
							E5 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E5"));
							E6 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E6"));
							E7 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E7"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						
						empacotador g1 = new empacotador (E1);
						empacotador g2 = new empacotador (E2); 
						empacotador g3 = new empacotador (E3);
						empacotador g4 = new empacotador (E4); 
						empacotador g5 = new empacotador (E5); 
						empacotador g6 = new empacotador (E6);
						empacotador g7 = new empacotador (E7); 
						
						piui.start();
						g1.start (); 
						g2.start ();
						g3.start();	
						g4.start (); 
						g5.start ();
						g6.start();	
						g7.start ();
						break;
					case 8: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							E3 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E3"));
							E4 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E4"));
							E5 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E5"));
							E6 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E6"));
							E7 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E7"));
							E8 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E8"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						
						empacotador h1 = new empacotador (E1);
						empacotador h2 = new empacotador (E2); 
						empacotador h3 = new empacotador (E3);
						empacotador h4 = new empacotador (E4); 
						empacotador h5 = new empacotador (E5); 
						empacotador h6 = new empacotador (E6);
						empacotador h7 = new empacotador (E7); 
						empacotador h8 = new empacotador (E8); 
						
						piui.start();
						h1.start (); 
						h2.start ();
						h3.start();	
						h4.start (); 
						h5.start ();
						h6.start();	
						h7.start (); 
						h8.start ();
						break;
					case 9: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							E3 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E3"));
							E4 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E4"));
							E5 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E5"));
							E6 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E6"));
							E7 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E7"));
							E8 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E8"));
							E9 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E9"));
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						
						empacotador i1 = new empacotador (E1);
						empacotador i2 = new empacotador (E2); 
						empacotador i3 = new empacotador (E3);
						empacotador i4 = new empacotador (E4); 
						empacotador i5 = new empacotador (E5); 
						empacotador i6 = new empacotador (E6);
						empacotador i7 = new empacotador (E7); 
						empacotador i8 = new empacotador (E8); 
						empacotador i9 = new empacotador (E9);
						
						piui.start();
						i1.start (); 
						i2.start ();
						i3.start();	
						i4.start (); 
						i5.start ();
						i6.start();	
						i7.start (); 
						i8.start ();
						i9.start();	
						break;
					case 10: 
						try{
							E1 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E1"));
							E2 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E2"));
							E3 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E3"));
							E4 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E4"));
							E5 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E5"));
							E6 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E6"));
							E7 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E7"));
							E8 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E8"));
							E9 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E9"));
							E10 =Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E10"));
							
							//BOTAR 
						}catch(NumberFormatException ex) {
						   
							JOptionPane.showMessageDialog(null,"Por favor insira valores númericos inteiros");		
							JOptionPane.showMessageDialog(null,"Programa encerrando");
							System.exit(0);
						}
						empacotador j1 = new empacotador (E1);
						empacotador j2 = new empacotador (E2); 
						empacotador j3 = new empacotador (E3);
						empacotador j4 = new empacotador (E4); 
						empacotador j5 = new empacotador (E5); 
						empacotador j6 = new empacotador (E6);
						empacotador j7 = new empacotador (E7); 
						empacotador j8 = new empacotador (E8); 
						empacotador j9 = new empacotador (E9);
						empacotador j10 = new empacotador (E10);
						piui.start();
						j1.start (); 
						j2.start ();
						j3.start();	
						j4.start (); 
						j5.start ();
						j6.start();	
						j7.start (); 
						j8.start ();
						j9.start();	
						j10.start();
						break;
				}
				
			} //botão de prosseguir
		});
		
		btnNewButton.setBounds(257, 142, 116, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
}

/*File file = new File("fortaleza.wav");
AudioInputStream audioStream;
try {
	audioStream = AudioSystem.getAudioInputStream(file);
	Clip clip = AudioSystem.getClip();
	clip.open(audioStream);
	clip.start();
} catch (UnsupportedAudioFileException | IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (LineUnavailableException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}*/
