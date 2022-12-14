package es.florida.ae1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


/**
 * @author Alvaro
 *
 */
public class Lanzadora {

	private JFrame frmFabricadorCroquetil;
	private JSpinner spinPollo;
	private JSpinner spinBacalao;
	private JSpinner spinQueso;
	private JSpinner spinJamon;
	JTextArea jtxState;
	JSpinner spinQCola;
	JSpinner spinBCola;
	JSpinner spinPCola;
	JSpinner spinJCola;
	private JScrollPane scrollPane;
	
	

	/**
	 * Launch the application.
	 */
	/**
	 * @param args
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
	 * Comprueba si la cantidad de todas la croqueta son exactas
	 * a las pedidas
	 * 
	 * @param j croqueta 
	 * @param p croqueta 
	 * @param b	croqueta
	 * @param q croqueta
	 * @return True/False
	 */
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
	 * Envia a la procesadora el numero y su lista de prioridad por multiproceso
	 * y el resultado lo guarda en un archivo.
	 * @param croqList lista de la cantidad de cada croqueta
	 * @param orden el orden de prioridad
	 */
	public void execute(ArrayList <Integer> croqList, ArrayList <String> orden) {
		
		String clase = "es.florida.ae1.Procesadora";

		File arch = new File("croquetasLog.txt");

		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(Integer.toString(croqList.get(0)));
			command.add(Integer.toString(croqList.get(1)));
			command.add(Integer.toString(croqList.get(2)));
			command.add(Integer.toString(croqList.get(3)));
			command.add(orden.get(0));
			command.add(orden.get(1));
			command.add(orden.get(2));
			command.add(orden.get(3));
			
			
			ProcessBuilder builder = new ProcessBuilder(command);
			
			builder.redirectOutput(arch).start();
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
		frmFabricadorCroquetil.setBounds(100, 100, 628, 438);
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
				ArrayList <Integer> croqList = new ArrayList <Integer>();
				ArrayList <String> posList = new ArrayList <String>();
				
				String line;
				
				boolean loop = true;
				try {
					File dir = new File("./croquetasLog.txt");
					if(!dir.isFile()) {
						try {
							dir.createNewFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					FileReader fr = new FileReader(dir);
					BufferedReader br = new BufferedReader(fr);
					
					//Ordena croquetas
					for(int i =1 ; i <= 4; i++) {
						
						if((Integer) spinJCola.getValue() == i) {
							croqList.add((Integer) spinJamon.getValue());
							posList.add("Jamon");
						}
						if((Integer) spinPCola.getValue() == i) {
							croqList.add((Integer) spinPollo.getValue());
							posList.add("Pollo");
						}
						if((Integer) spinBCola.getValue() == i) {
							croqList.add((Integer) spinBacalao.getValue());
							posList.add("Bacalao");
						}
						if((Integer) spinQCola.getValue() == i) {
							croqList.add((Integer) spinQueso.getValue());
							posList.add("Queso");
						}
						
						
						
					}
					
					
					
					if(compCroquetas(croqList.get(0),croqList.get(1),croqList.get(2),croqList.get(3))) {
						
					
						execute(croqList,posList );
						//Este entramado es para mostrar el log por interfaz
						try {
						
						while(loop) {
							Thread.sleep(1000);
							line = br.readLine();
							
							if(line != null) {
								if(line.equals("0")) {
									
									loop = false;
								}
								else {
								
									System.out.println(line);
									jtxState.setText(jtxState.getText() + line+ "\n");
								}
							}
							
							
							
						}
						JOptionPane.showMessageDialog(null,br.readLine() , "InfoBox: " + "Poceso Finalizado", JOptionPane.INFORMATION_MESSAGE);
							
						
						}catch(Exception exc) {
							exc.printStackTrace();
						}
					}
					
					try {
						br.close();
						fr.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		btnProcesar.setBounds(392, 278, 89, 23);
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 279, 370, 112);
		frmFabricadorCroquetil.getContentPane().add(scrollPane);
		
		jtxState = new JTextArea();
		scrollPane.setViewportView(jtxState);
		jtxState.setText("Procesadora preparada...");
		jtxState.setFont(new Font("Monospaced", Font.PLAIN, 15));
		
		spinJCola = new JSpinner();
		spinJCola.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinJCola.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinJCola.setBounds(491, 38, 46, 23);
		frmFabricadorCroquetil.getContentPane().add(spinJCola);
		
		spinPCola = new JSpinner();
		spinPCola.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinPCola.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinPCola.setBounds(491, 96, 46, 23);
		frmFabricadorCroquetil.getContentPane().add(spinPCola);
		
		spinBCola = new JSpinner();
		spinBCola.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinBCola.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinBCola.setBounds(491, 151, 46, 23);
		frmFabricadorCroquetil.getContentPane().add(spinBCola);
		
		spinQCola = new JSpinner();
		spinQCola.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinQCola.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinQCola.setBounds(491, 222, 46, 23);
		frmFabricadorCroquetil.getContentPane().add(spinQCola);
		
		JLabel lblCroqNum = new JLabel("Número de croquetas");
		lblCroqNum.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCroqNum.setBounds(377, 15, 122, 13);
		frmFabricadorCroquetil.getContentPane().add(lblCroqNum);
		
		JLabel lblNewLabel = new JLabel("Orden");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(491, 15, 34, 13);
		frmFabricadorCroquetil.getContentPane().add(lblNewLabel);
		
	}
	
	
}
