import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
* 
* @version 2.0
* @author Ratones Colores
*/

public class LibroBestias extends JFrame implements ActionListener{

	private JPanel contentPane;

	private ImageIcon imagen[];
	private String arrayTexto[];
	private int contador = 0;

	private JLabel labelImagenes;
	private JLabel labelTitulo;
	private JLabel labelFuego;
	private JLabel labelGifDer;
	private JLabel labelGifIzq;
	private JLabel labelFondo;
	
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	
	private JButton btnSiguiente;
	private JButton btnAnterior;
	private JButton btnSalir;
	
	private boolean[] desbloqueados; //Monstruos desbloqueados
	private ImageIcon imaDesconocido;
	private String texDesconocido;
	private int[] numMonstre;
	
	public boolean vista;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		//hasta nueve
		//PRUEBAS PARA EL LIBRO DE BESTIAS. AHORA NECESITA UN ARRAY DE BOOLEANOS PARA FUNCIONAR
		boolean[] pruebas = new boolean[10];
		
		for (int x=0;x<pruebas.length;x++){
				pruebas[x] = true;
		}		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibroBestias frame = new LibroBestias(pruebas);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void setDesbloqueados(boolean[] db){
		desbloqueados = db;
	}
	
	public boolean[] getDesbloqueados(){
		return desbloqueados;
	}

	/**
	 * Create the frame.
	 */
	public LibroBestias(boolean[] desblo) {
		imagen = new ImageIcon[10];
		arrayTexto = new String[10];
		setDesbloqueados(desblo);
		
		numMonstre = new int[10];
		
		for (int x=0 ; x<numMonstre.length ; x++) {
			numMonstre[x] = x+1;
		}
		
		/*Leprechaun Lascivo ataque 3, defensa 5, vida 5
		 * Chaman Bizarro ataque 4, defensa 5, vida 5
		
		 * Chuqui "El Crapuloso" ataque 5, defensa 5, vida 6
		
		 * Grey "El Fantoche" ataque 6, defensa 7, vida 7
		 
		 * La Yoli Zascandil ataque 7, defensa 7, vida 8
		
		 * Ogro de Cieza ataque 8, defensa 8, vida 9
		
		 * El comedor de detritos ataque 10, defensa 10, vida 11
		 
		 * Mutante RickYMorti ataque 11, defensa 11, vida 15
		
		 * Espantajo Malogrado ataque 12, defensa 12, vida 17
		 */
		 
		 
		 
		texDesconocido = ".:. ??? .:. \n\n"
				+ "Todavía no has luchado contra\neste monstruo\n\n"
				+ "Estadísticas:\n"
				+ "Ataque: ??\nDefensa:??\nVitalidad:??";
		
		
		 arrayTexto[0] = ".:.Leprechaun Lascivo.:.\n"
				+ "\nSe trata de un duende maligno.\n"
				+ "\nSuele habitar cerca de\n"
				+ "ciudades y poblados.\n"
				+ "\nPosee gran astucia y ciertas\n"
				+ "capacidades mágicas.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 3\n"
				+ "Defensa: 5\n"
				+ "Vitalidad: 5";
				
		 arrayTexto[1] = ".:.Chaman Bizarro.:.\n"
				+ "\nEs un demonio de bajo nivel.\n"
				+ "Suele habitar los bosques\n"
				+ "oscuros del Este.\n"
				+ "\nColecciona cráneos de\n"
				+ "sus victimas con las que crea\n"
				+ "pontentes hechizos.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 4\n"
				+ "Defensa: 5\n"
				+ "Vitalidad: 5";
							
		 arrayTexto[2] = ".:.Chuqui \"El Crapuloso\".:.\n"
				+ "\nEs un bestia horrible con\n"
				+ "aspecto de rata.\n"
				+ "\nLe encanta combatir y devorar\n"
				+ "a sus victimas.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 5\n"
				+ "Defensa: 5\n"
				+ "Vitalidad: 6";
		
		 arrayTexto[3] = ".:.Grey \"El Fantoche\".:.\n"
				+ "\nSe trata de un antiguo guerrero\n"
				+ "convertido en hombre lobo.\n"
				+ "\nSe vuelve muy feroz y agresivo\n"
				+ "con la luna llena.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 6\n"
				+ "Defensa: 7\n"
				+ "Vitalidad: 7";
			
		 arrayTexto[4] = ".:.La Yoli Zascandil.:.\n"
				+ "\nEs una bruja convertida en una\n"
				+ "terrible criatura.\n"
				+ "\nHabita en pantanos putrefactos\n"
				+ "y se suele alimentar de niños.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 7\n"
				+ "Defensa: 7\n"
				+ "Vitalidad: 8";
		
		 arrayTexto[5] = ".:.Ogro de Cieza.:.\n"
				+ "\nEs un antiguo caudillo orco\n"
				+ "al que le encanta la lucha\n"
				+ "encarnizada.\n"
				+ "\nSuele alimentarse de humanos\n"
				+ "para fabricar con sus pieles.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 8\n"
				+ "Defensa: 8\n"
				+ "Vitalidad: 9";
		
		 arrayTexto[6] = ".:.El comedor de detritos.:.\n"
				+ "\nSe trata de un engendro creado\n"
				+ "gracias a la magia oscura.\n"
				+ "\nSuele habitar cienagas y \nantiguos"
				+ "campos de batalla.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 10\n"
				+ "Defensa: 10\n"
				+ "Vitalidad: 11";
		
		 arrayTexto[7] = ".:.Windingo.:.\n"
				+ "\nEs una criatura ancestral,\ntambién"
				+ "conocida como espiritu \nde los bosques.\n"
				+ "\nSuele habitar bosques viejos,\n"
				+ "donde protege animales\n y árboles de los\n"
				+ "posibles instrusos.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 11\n"
				+ "Defensa: 11\n"
				+ "Vitalidad: 15";
		
		 arrayTexto[8] = ".:.Espantajo Malogrado.:.\n"
				+ "\nDescomunal criatura con\n"
				+ "aspecto deforme.\n"
				+ "\nHabita en una cueva gigante\n"
				+ "del paso montañoso Kahz-Dum.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 11\n"
				+ "Defensa: 11\n"
				+ "Vitalidad: 16";
		
		 arrayTexto[9] = ".:.El Mal.:.\n"
				+ "\nSe trata de un antiguo demonio\n"
				+ "muy poderoso.\n"
				+ "\nSe alimenta de almas de seres\n"
				+ "vivos que le otorgan un gran \npoder.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 12\n"
				+ "Defensa: 12\n"
				+ "Vitalidad: 17";
		
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelTitulo = new JLabel("Bestias Legendarias");
		labelTitulo.setForeground(new Color(255, 255, 0));
		labelTitulo.setFont(new Font("Century Gothic", Font.BOLD, 20));
		labelTitulo.setBackground(Color.BLACK);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(143, 27, 214, 25);
		contentPane.add(labelTitulo);
		
		labelFuego = new JLabel("new label");
		labelFuego.setIcon(new ImageIcon("..\\media\\miscelanea\\llamas.gif"));
		labelFuego.setBounds(51, 27, 412, 25);
		contentPane.add(labelFuego);
		
		labelGifDer = new JLabel("New label");
		labelGifDer.setIcon(new ImageIcon("..\\media\\miscelanea\\deco01.gif"));
		labelGifDer.setBounds(475, 0, 39, 52);
		contentPane.add(labelGifDer);
		
		labelGifIzq = new JLabel("New label");
		labelGifIzq.setIcon(new ImageIcon("..\\media\\miscelanea\\deco01.gif"));
		labelGifIzq.setBounds(0, 0, 39, 52);
		contentPane.add(labelGifIzq);
		
		txtArea = new JTextArea();
		txtArea.setBackground(new Color(0, 0, 0));
		txtArea.setForeground(new Color(255, 255, 255));
		txtArea.setFont(new Font("Century Gothic", Font.BOLD, 15));
		txtArea.setBounds(272, 86, 230, 379);
		contentPane.add(txtArea);
		txtArea.setEnabled(false);
		
		scrollPane = new JScrollPane(txtArea);
		scrollPane.setBounds(272, 86, 230, 379);
		contentPane.add(scrollPane);
		
		imaDesconocido = new ImageIcon("..\\media\\fotosBestias\\desconocido.jpg");
		imagen[0] = new ImageIcon("..\\media\\fotosBestias\\foto0.jpg");
		labelImagenes = new JLabel();
		if(desblo[0] == true) {
			
			labelImagenes.setIcon(imagen[0]);
			txtArea.setText(numMonstre[0]+" "+arrayTexto[0]);
		} else {
			labelImagenes.setIcon(imaDesconocido);
			txtArea.setText(numMonstre[0]+" "+texDesconocido);
		}
		labelImagenes.setBounds(12, 86, 234, 379);
		contentPane.add(labelImagenes);
		//labelImagenes.addActionListener(this);
		
		
		
		/*scrollPane = new JScrollPane(txtArea);
		scrollPane.setBounds(500, 13, -12, 399);
		contentPane.add(scrollPane);*/
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBorder(new LineBorder(new Color(255, 215, 0), 3, true));
		btnSiguiente.setForeground(new Color(255, 215, 0));
		btnSiguiente.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSiguiente.setBackground(Color.BLACK);
		btnSiguiente.setBounds(405, 478, 97, 25);
		contentPane.add(btnSiguiente);
		btnSiguiente.addActionListener(this);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 215, 0));
		btnSalir.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSalir.setBorder(new LineBorder(new Color(255, 215, 0), 3, true));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(225, 478, 67, 25);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setForeground(new Color(255, 215, 0));
		btnAnterior.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnAnterior.setBorder(new LineBorder(new Color(255, 215, 0), 3, true));
		btnAnterior.setBackground(Color.BLACK);
		btnAnterior.setBounds(12, 478, 97, 25);
		contentPane.add(btnAnterior);
		btnAnterior.addActionListener(this);
		
		labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon("..\\media\\miscelanea\\fondo02.jpg"));
		labelFondo.setBounds(0, 0, 514, 515);
		contentPane.add(labelFondo);
	
		for(int i = 1; i < 10; i++)
		{
			imagen[i] = new ImageIcon("..\\media\\fotosBestias\\foto"+i+".jpg");
		}
	
		
	}
	
	@Override
	public void setVisible(boolean b){
		super.setVisible(b);
		vista = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(btnSiguiente == e.getSource())
		{
			if(contador == 9)
			{
				contador = 0;
				
			} else {
				contador++;
			}
			
			if (getDesbloqueados()[contador]){
				labelImagenes.setIcon(imagen[contador]);
				txtArea.setText(numMonstre[contador]+" "+arrayTexto[contador]);
			} else {
				labelImagenes.setIcon(imaDesconocido);
				txtArea.setText(numMonstre[contador]+" "+texDesconocido);
			}
		}
	
		if(btnAnterior == e.getSource())
		{
			if(contador == 0)
			{
				contador = 9;
				
			} else {
				contador--;
			}
			
			if (getDesbloqueados()[contador]){
				labelImagenes.setIcon(imagen[contador]);
				txtArea.setText(numMonstre[contador]+" "+arrayTexto[contador]);
			} else {
				labelImagenes.setIcon(imaDesconocido);
				txtArea.setText(numMonstre[contador]+" "+texDesconocido);
			}
			
		}
	
		if(btnSalir == e.getSource())
		{
			vista = false;
			dispose();
		}
	
	}

}
