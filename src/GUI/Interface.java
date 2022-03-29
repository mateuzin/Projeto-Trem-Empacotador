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
		this.frame = new JFrame();
		this.frame.getContentPane().setBackground(Color.WHITE);
		this.frame.setBounds(100, 100, 399, 231);
		this.frame.setDefaultCloseOperation(3);
		this.frame.getContentPane().setLayout((LayoutManager) null);
		this.frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Tempo de viagem");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 16));
		lblNewLabel.setBounds(10, 11, 152, 22);
		
		this.frame.getContentPane().add(lblNewLabel);
		this.TempoDeV_field = new JTextField();
		this.TempoDeV_field.setBounds(10, 37, 59, 20);
		this.frame.getContentPane().add(this.TempoDeV_field);
		this.TempoDeV_field.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Carga Trem");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 16));
		lblNewLabel_1.setBounds(10, 67, 91, 14);
		
		this.frame.getContentPane().add(lblNewLabel_1);
		this.CargaT_field = new JTextField();
		this.CargaT_field.setBounds(10, 88, 59, 20);
		this.frame.getContentPane().add(this.CargaT_field);
		this.CargaT_field.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Carga maxíma do Deposito");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 16));
		lblNewLabel_2.setBounds(10, 119, 176, 14);
		
		this.frame.getContentPane().add(lblNewLabel_2);
		this.MaxDeposito_field = new JTextField();
		this.MaxDeposito_field.setBounds(10, 144, 59, 20);
		this.frame.getContentPane().add(this.MaxDeposito_field);
		this.MaxDeposito_field.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Número de Empacotadores");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 16));
		lblNewLabel_3.setBounds(187, 15, 186, 14);
		
		this.frame.getContentPane().add(lblNewLabel_3);
		final JComboBox NumeroEmpacotadores = new JComboBox();
		
		NumeroEmpacotadores.setMaximumRowCount(6);
		NumeroEmpacotadores.setForeground(Color.BLACK);
		NumeroEmpacotadores.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		NumeroEmpacotadores.setBounds(187, 36, 59, 22);
		
		this.frame.getContentPane().add(NumeroEmpacotadores);
		JButton btnNewButton = new JButton("Prosseguir");
		
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

			}
		});
		btnNewButton.setBounds(257, 142, 116, 23);
		this.frame.getContentPane().add(btnNewButton);
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
}
