import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;

/**
* 
* @version 2.0
* @author Ratones Colores
*/

public class LibroHeroes extends JFrame implements ActionListener{

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
	
	public boolean vista;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibroHeroes frame = new LibroHeroes();
					
					
					
					public void run() {
		try {
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	
	/**
	 * Create the frame.
	 */
	public LibroHeroes() {
		
		imagen = new ImageIcon[4];
		arrayTexto = new String[4];
		
		arrayTexto[0] = ".:.Bárbaras.:.\n"
				+ "\nSon guerreras del frío norte.\n"
				+ "\nSu valor en la batalla es \ncomparable al de un semidios\n"
				+ "y son diestras con las armas\n"
				+ "cuerpo a cuerpo.\n"
				+ "\nSu habilidad reside en doblar\n"
				+ "la probabilidad de daño crítico.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 8\n"
				+ "Defensa: 5\n"
				+ "Vitalidad: 10";
				
		arrayTexto[1] = ".:.Hechiceras.:.\n"
				+ "\nSon magas muy poderosas\n"
				+ "de las lejanas tierras de Kovir.\n"
				+ "\nDominan la magia oscura y\n"
				+ "adoran crear nuevos hechizos.\n"
				+ "\nSu habilidad reside en el buen\n"
				+ "equilibrio de ataque y defensa\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 6\n"
				+ "Defensa: 7\n"
				+ "Vitalidad: 8";
							
		arrayTexto[2] = ".:.Curanderos.:.\n"
				+ "\nSon druidas de los bosques\n"
				+ "perdidos de Tudons.\n"
				+ "\nEstán versados en el don de la\nnaturaleza. Hablan con animales\n"
				+ "y adoran ver pasar el tiempo.\n"
				+ "\nSon capaces de sanar el doble\n"
				+ "y tienen el doble de pociones.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 5\n"
				+ "Defensa: 8\n"
				+ "Vitalidad: 7";
		
		arrayTexto[3] = ".:.Burlones.:.\n"
				+ "\nSon astutos y escurridizos.\n"
				+ "En el combate, utilizan\nartimañas para ganar y\nreírse de sus oponentes"
				+ "\n\nSu habilidad reside en su gran\n"
				+ "destreza  y agilidad.\n"
				+ "\nPoseen un buen equilibrio \nentre "
				+ "ataque y defensa.\n"
				+ "\nEstadísticas:\n"
				+ "Ataque: 7\n"
				+ "Defensa: 6\n"
				+ "Vitalidad: 9";
				
		
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelTitulo = new JLabel("Heroes Legendarios");
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

		imagen[0] = new ImageIcon("..\\media\\miscelanea\\foto0.jpg");		
		labelImagenes = new JLabel(imagen[0]);
		labelImagenes.setBounds(12, 86, 234, 379);
		contentPane.add(labelImagenes);
		//labelImagenes.addActionListener(this);
		
		txtArea = new JTextArea(arrayTexto[0]);
		txtArea.setBackground(new Color(0, 0, 0));
		txtArea.setForeground(new Color(255, 255, 255));
		txtArea.setFont(new Font("Century Gothic", Font.BOLD, 14));
		txtArea.setBounds(272, 86, 230, 379);
		contentPane.add(txtArea);
		txtArea.setEnabled(false);
		
		scrollPane = new JScrollPane(txtArea);
		scrollPane.setBounds(272, 86, 230, 379);
		contentPane.add(scrollPane);
		
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
	
		for(int i = 1; i < 4; i++)
		{
			imagen[i] = new ImageIcon("..\\media\\miscelanea\\foto"+i+".jpg");
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
			if(contador == 3)
			{
				contador = 0;
			} else {
				contador++;
			}
			labelImagenes.setIcon(imagen[contador]);
			txtArea.setText(arrayTexto[contador]);
		}
	
		if(btnAnterior == e.getSource())
		{
			if(contador == 0)
			{
				contador = 3;
			} else {
				contador--;
			}
			labelImagenes.setIcon(imagen[contador]);
			txtArea.setText(arrayTexto[contador]);
		}
	
		if(btnSalir == e.getSource())
		{
			vista = false;
			dispose();
		}
	
	}
}
