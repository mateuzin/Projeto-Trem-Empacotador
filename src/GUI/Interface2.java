
package GUI;

import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface2 extends JFrame {
	public JFrame frame;
	public static String Dormindo = "/GUI/empacotadorDormindo.png";
	public static String Empacotando = "/GUI/empacotadorEmpacotando.png";
	public static String Terminou = "/GUI/empacotadorEmpacotado.png";
	public static String Inativo = "/GUI/empacotadorInativo.png";
	public static String Voltando = "/GUI/empacotadorSemCaixa(voltando).png";
	private JLabel[] empacotadores;

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
		JLabel imagem_trem = new JLabel("");
		imagem_trem.setIcon(new ImageIcon(Interface2.class.getResource("/GUI/trem.png")));
		imagem_trem.setBounds(-14, 580, 168, 56);
		this.frame.getContentPane().add(imagem_trem);
		this.empacotadores = new JLabel[10];

		JLabel label;
		for (int i = 0; i < 10; ++i) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(Interface2.class.getResource(Empacotando)));
			label.setBounds(69 + 144 * i, 37, 64, 89);
			this.frame.getContentPane().add(label);
			this.empacotadores[i] = label;
		}

		JLabel Cenario = new JLabel("");
		Cenario.setIcon(new ImageIcon(Interface2.class.getResource("/GUI/cenarioOK.jpg")));
		Cenario.setBounds(0, 0, 1500, 750);
		this.frame.getContentPane().add(Cenario);
		label = new JLabel("New label");
		label.setBounds(76, 278, 46, 14);
		this.frame.getContentPane().add(label);
	}

	public void changeImg(int empacotador, String img) {
		this.empacotadores[empacotador - 1].setIcon(new ImageIcon(Interface2.class.getResource(img)));
	}
}
