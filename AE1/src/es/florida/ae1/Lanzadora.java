package es.florida.ae1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Panel;
import javax.swing.ButtonGroup;

public class Lanzadora {

	private JFrame frmFabricadorCroquetil;
	private final ButtonGroup GrupoTipo = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadora window = new Lanzadora();
					window.frmFabricadorCroquetil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lanzadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFabricadorCroquetil = new JFrame();
		frmFabricadorCroquetil.setTitle("Fabricador Croquetil");
		frmFabricadorCroquetil.setBounds(100, 100, 627, 353);
		frmFabricadorCroquetil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFabricadorCroquetil.getContentPane().setLayout(null);
		
		JLabel lblCroquetas = new JLabel("Indique número de croquetas de Jamon");
		lblCroquetas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCroquetas.setBounds(10, 26, 370, 36);
		frmFabricadorCroquetil.getContentPane().add(lblCroquetas);
		
		JSpinner SpNumCroc = new JSpinner();
		SpNumCroc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SpNumCroc.setBounds(390, 24, 72, 41);
		frmFabricadorCroquetil.getContentPane().add(SpNumCroc);
	}
}
