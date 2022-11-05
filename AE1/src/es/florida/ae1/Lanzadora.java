package es.florida.ae1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class Lanzadora {

	private JFrame frmFabricadorCroquetil;
	private JSpinner spinPollo;
	private JSpinner spinBacalao;
	private JSpinner spinQueso;
	private JSpinner spinJamon;
	

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
	boolean compCroquetas(int j, int p,int b, int q){
		
		if(j % 6!= 0) {
			
			JOptionPane.showMessageDialog(null, "La cantidad de croquetas de jamón debe ser múltiplo de 6 ", "InfoBox: " + "Error! Número de croquetas", JOptionPane.INFORMATION_MESSAGE);
			return false;
			
		}
		
		if(p % 6!= 0) {
			
			JOptionPane.showMessageDialog(null, "La cantidad de croquetas de pollo debe ser múltiplo de 6 ", "InfoBox: " + "Error! Número de croquetas", JOptionPane.INFORMATION_MESSAGE);

			return false;
		}
		
		if(b % 6!= 0) {
			
			JOptionPane.showMessageDialog(null, "La cantidad de croquetas de bacalao debe ser múltiplo de 6 ", "InfoBox: " + "Error! Número de croquetas", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(q % 6!= 0) {
			
			JOptionPane.showMessageDialog(null, "La cantidad de croquetas de queso debe ser múltiplo de 6 ", "InfoBox: " + "Error! Número de croquetas", JOptionPane.INFORMATION_MESSAGE);

			return false;
		}
		
		if(j == 0 && p == 0 && b == 0 && q == 0) {
			
			JOptionPane.showMessageDialog(null, "Se debe indicar al menos 6 croquetas de un tipo ", "InfoBox: " + "Error! Número de croquetas", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		
		
		return true;
		
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
		
		JLabel lblCroquetas_J = new JLabel("Indique número de croquetas de Jamon");
		lblCroquetas_J.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCroquetas_J.setBounds(10, 26, 370, 36);
		frmFabricadorCroquetil.getContentPane().add(lblCroquetas_J);
		
		JLabel lblIndiqueNmeroDe = new JLabel("Indique número de croquetas de Pollo");
		lblIndiqueNmeroDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIndiqueNmeroDe.setBounds(10, 84, 370, 36);
		frmFabricadorCroquetil.getContentPane().add(lblIndiqueNmeroDe);
		
		JLabel lblCroquetas_B = new JLabel("Indique número de croquetas de Bacalao");
		lblCroquetas_B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCroquetas_B.setBounds(10, 151, 370, 36);
		frmFabricadorCroquetil.getContentPane().add(lblCroquetas_B);
		
		JLabel lblCroquetas_Q = new JLabel("Indique número de croquetas de Queso");
		lblCroquetas_Q.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCroquetas_Q.setBounds(10, 210, 370, 36);
		frmFabricadorCroquetil.getContentPane().add(lblCroquetas_Q);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [] croqList;
				//spinJamon.getValue()
	
				
					
				
					croqList= new int[] {
							(Integer) spinJamon.getValue(),
							(Integer) spinPollo.getValue(),
							(Integer) spinBacalao.getValue(),
							(Integer) spinQueso.getValue()
							
					}; 
					
					if(compCroquetas(croqList[0],croqList[1],croqList[2],croqList[3])) {
						
						System.out.println("cargar procesadora");
						
					}
					
					
					

				
			}
		});
		btnProcesar.setBounds(392, 280, 89, 23);
		frmFabricadorCroquetil.getContentPane().add(btnProcesar);
		
		spinPollo = new JSpinner();
		spinPollo.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinPollo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinPollo.setBounds(392, 96, 89, 23);
		frmFabricadorCroquetil.getContentPane().add(spinPollo);
		
		spinBacalao = new JSpinner();
		spinBacalao.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinBacalao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinBacalao.setBounds(392, 151, 89, 23);
		frmFabricadorCroquetil.getContentPane().add(spinBacalao);
		
		spinQueso = new JSpinner();
		spinQueso.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinQueso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinQueso.setBounds(392, 222, 89, 23);
		frmFabricadorCroquetil.getContentPane().add(spinQueso);
		
		spinJamon = new JSpinner();
		spinJamon.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinJamon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinJamon.setBounds(392, 38, 89, 23);
		frmFabricadorCroquetil.getContentPane().add(spinJamon);
	}
}
