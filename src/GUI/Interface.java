//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import trem_empacotadorN1.Trem;
import trem_empacotadorN1.empacotador;
import KentHipos.Kensoft;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;


public class Interface extends JFrame {
	public JFrame frame;
	public JTextField TempoDeV_field;
	public JTextField CargaT_field;
	public JTextField MaxDeposito_field;
	public static int TempoTrem;
	public static int CargaTrem;
	public static int MaxArmazem;
	public int aux;
	private Interface2 window;

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	}

	public Interface() {
		this.initialize();
	}

	public void initialize() {
		

		File file = new File("fortaleza.wav");
		
		this.frame = new JFrame();
		this.frame.getContentPane().setBackground(Color.WHITE);
		this.frame.setBounds(100, 100, 1021, 786);
		this.frame.setDefaultCloseOperation(3);
		this.frame.getContentPane().setLayout((LayoutManager) null);
		this.frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		this.TempoDeV_field = new JTextField();
		TempoDeV_field.setBackground(Color.LIGHT_GRAY);
		TempoDeV_field.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TempoDeV_field.setForeground(Color.BLACK);
		this.TempoDeV_field.setBounds(82, 185, 72, 43);
		this.frame.getContentPane().add(this.TempoDeV_field);
		this.TempoDeV_field.setColumns(10);
		
		this.CargaT_field = new JTextField();
		CargaT_field.setBackground(Color.LIGHT_GRAY);
		CargaT_field.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.CargaT_field.setBounds(82, 463, 72, 43);
		this.frame.getContentPane().add(this.CargaT_field);
		this.CargaT_field.setColumns(10);
		
		this.MaxDeposito_field = new JTextField();
		MaxDeposito_field.setBackground(Color.LIGHT_GRAY);
		MaxDeposito_field.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.MaxDeposito_field.setBounds(82, 328, 72, 43);
		this.frame.getContentPane().add(this.MaxDeposito_field);
		this.MaxDeposito_field.setColumns(10);
		
		final JComboBox NumeroEmpacotadores = new JComboBox();
		NumeroEmpacotadores.setBackground(Color.LIGHT_GRAY);
		NumeroEmpacotadores.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		NumeroEmpacotadores.setMaximumRowCount(4);
		NumeroEmpacotadores.setForeground(Color.BLACK);
		NumeroEmpacotadores.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		NumeroEmpacotadores.setBounds(869, 428, 107, 55);
		
		this.frame.getContentPane().add(NumeroEmpacotadores);
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Interface.class.getResource("/GUI/Play (1).jpg")));
		btnNewButton.setSelectedIcon(new ImageIcon(Interface.class.getResource("/GUI/trempequeno.png")));
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 16));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Interface.TempoTrem = Integer.parseInt(Interface.this.TempoDeV_field.getText());
					Interface.CargaTrem = Integer.parseInt(Interface.this.CargaT_field.getText());
					Interface.MaxArmazem = Integer.parseInt(Interface.this.MaxDeposito_field.getText());
				} catch (NumberFormatException var7) {
					JOptionPane.showMessageDialog((Component) null, "Por favor insira valores númericos inteiros");
					JOptionPane.showMessageDialog((Component) null, "Programa encerrando");
					System.exit(0);
				}

				if (Interface.CargaTrem > Interface.MaxArmazem) {
					JOptionPane.showMessageDialog((Component) null,
							"Carga máxima do deposito deve ser maior do que a Carga do Trem");
					JOptionPane.showMessageDialog((Component) null, "Programa encerrando");
					System.exit(0);
				}

				Trem piui = new Trem((double) Interface.TempoTrem,Interface.this,Interface.this);
				Interface.this.aux = NumeroEmpacotadores.getSelectedIndex() + 1;
				List<empacotador> lista = new ArrayList();

				for (int i = 1; i <= Interface.this.aux; ++i) {
					try {
						int emp = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de empacotamento do E" + i));
						lista.add(new empacotador(i, emp, Interface.this, Interface.this));
					} catch (NumberFormatException var6) {
						JOptionPane.showMessageDialog((Component) null, "Por favor insira valores númericos inteiros");
						JOptionPane.showMessageDialog((Component) null, "Programa encerrando");
						System.exit(0);
					}
				}

				piui.start();
				Iterator var9 = lista.iterator();

				while (var9.hasNext()) {
					empacotador empacotarTemp = (empacotador) var9.next();
					empacotarTemp.start();
				}

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Interface.this.window = new Interface2();
							Interface.this.window.frame.setVisible(true);
						} catch (Exception var2) {
							var2.printStackTrace();
						}

					}
					
				});
				
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
				}

			}
		});
		btnNewButton.setBounds(742, 649, 253, 53);
		this.frame.getContentPane().add(btnNewButton);
		
		JLabel Cenario = new JLabel("New label");
		Cenario.setBackground(Color.LIGHT_GRAY);
		Cenario.setIcon(new ImageIcon(Interface.class.getResource("/GUI/Interface1Imagem.jpg")));
		Cenario.setBounds(0, 0, 1008, 750);
		frame.getContentPane().add(Cenario);
	}

	public void changeImg(int empacotador, String img) {
		if (this.window != null) {
			this.window.changeImg(empacotador, img);
		}

	}
	
	public void Progress(int atual) {
		if (this.window != null) {
			this.window.progress(atual);
		}
	}
	
	public void SentidoT(String sentido,double tv) {
		if (this.window != null) {
			this.window.sentidoTrem(sentido,tv);
		}

	}
	
	public void SentidoE(int empacotador,String sentido,double te) {
		if (this.window != null) {
			this.window.sentidoEmpacotador(empacotador,sentido,te);
		}

	}
}
