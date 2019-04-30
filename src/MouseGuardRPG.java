import javax.swing.JOptionPane;
import java.awt.EventQueue;
/**
* Clase MouseGuardRPG es la clase del main y también incluye aquellos métodos que tienen que interactuar directamente con el jugador.
* @version 2.0
* @author Ratones Coloraos
*/
public class MouseGuardRPG {
	
	/**
	* En pocas palabras, el main contiene el menu por el que navegará el usuario, pudiendo elegir entre estas opciones:
	* <br><br>1: Jugar (crea al personaje, muestra sus stats y luego entra en la arena)
	* <br>2: Tutorial (muestra el manual del juego)
	* <br>3: Creditos (muestra al autor)
	* <br>4: Lucha contra otro jugador (PVP)
	* <br>5: Libra un único combate
	* <br>6: Cargar 
	* <br>7: Visualizar el ranking
	* <br>8: Salir
	* <br>OTROS: Repite el bucle sin hacer nada
	* @param eleccion String que contiene la opcion elegida por el jugador (para el menu)
	* @param jugador contenedor del personaje que se ha creado el jugador
	* @param x contador que marca si el bucle (menu) se cierra o no 
	*/
	public static void main (String[] args){
		String eleccion = "";
		int x = 5;
		Heroe jugador;
		Heroe jugadorSegundo = null;
		Combate coliseo = null;
		Object[] cargado = null;
		coliseo = new Combate();
		Ranking clasificacion = new Ranking();
		
		do {
			eleccion = JOptionPane.showInputDialog("Bienvenido a MouseGuard. Introduce el numero para moverte por el menu.\n\n1. Jugar\n\n2. Instrucciones\n\n3. Quien soy?\n\n4. Multijugador\n\n5. Combate unico\n\n6. Cargar\n\n7. Ver el Ranking\n\n8.Salir");
		
			switch(eleccion){
				case "1": //Entrar en la arena
					jugador = crearPersonaje();
					JOptionPane.showMessageDialog(null, jugador.toString());
					//System.out.println(jugador.getClass());
					coliseo.entrarEnLaArena(jugador,clasificacion);
					break;
				
				case "2": //Tutorial
					manualAyuda();
					break;
				
				case "3": //Creditos
					JOptionPane.showMessageDialog(null, "Mouse Guard RPG, por Ratones Coloraos.\n\nVersion 2.0\n\nMuchas gracias por jugar!");
					break;
					
				case "4": //PVP	
					jugador = crearPersonaje();
					jugadorSegundo = crearPersonaje();
					coliseo.combatirPVP(jugador,jugadorSegundo);
					break;
					
				case "5": //Batalla individual
					jugador = crearPersonaje();
					coliseo.combateUnico(jugador);
					break;
					
				case "6": //Cargar
					cargado = GuardarCargar.cargar();
					jugador = (Heroe) cargado[0];
					coliseo = (Combate) cargado[1];
					JOptionPane.showMessageDialog(null, jugador.toString());
					coliseo.entrarEnLaArena(jugador,clasificacion);
					
				case "7": //Ranking
					JOptionPane.showMessageDialog(null,clasificacion.toString());
					break;
					
				case "8": //Salir
					x = 0;
					break;
					
				default: //Erroneo o nada
					break;
			}
		
		} while (x>0);
	}
	
	/**
	* Este metodo informa al jugador sobre las clases seleccionables para después pedirle que elija una. Mediante un bucle, impide que se seleccione otra que
	* no aparezca aquí o que se escriba mal. Luego preguntará el nombre deseado para el personaje y a partir de ahi creará el heroe con el que jugará el cliente.
	* @param x contador utilizado en el bucle para pedir datos. Controla que se pida datos continuamente hasta que se cumplan las especificaciones.
	* @param clase String que contiene la clase elegida por el jugador
	* @param nombre String que contiene el nombre elegido por el jugador
	* @param tidus contenedor que apuntará al futuro objeto con el personaje del jugador. 
	*/
	
	public static Heroe crearPersonaje() {
		int x = 2;
		int f = 0;
		String clase = "";
		Heroe tidus = null;
		LibroHeroes libro;
		do {
			clase = JOptionPane.showInputDialog("Elige tu clase\n\nBarbaro: Guerrero que ataca con la fuerza bruta. Bueno en ataque.\n\nBurlon: Sabandija repudiada por sus iguales, se adapta a la naturaleza y sabe camuflarse.\n\nCurandero: Druida que conoce los remedios mas secretos de la Ciudadela. No es muy buen guerrero, pero se cura el doble\n\nArcano: Místico cuya llegada fue vista por los oráculos de la ciudadela. Es equilibrado, pero destaca en Defensa\n\nLibro: Consulta detalladamente cada clase");

		
			if (clase.equals("Barbaro") || clase.equals("Burlon") || clase.equals("Curandero") || clase.equals("Arcano")){
				x = 100;
			} else if (clase.equals("Libro")) {
				libro = new LibroHeroes();
				libro.setVisible(true);
				
				while(libro.vista){
					System.out.print("");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "El dato es erroneo. Por favor, respeta las mayusculas y elige una de las opciones");
			}
		
		} while (x<4);
		
		String nombre = JOptionPane.showInputDialog("Ponle un nombre a tu personaje");
		
		/**
		* @see El switch preguntará el valor de clase y creará un objeto u otro en función a este. 
		*/
		
		switch (clase){
			case "Barbaro":
				tidus = new Barbaro();
				break;
			
			case "Burlon":
				tidus = new Burlon();
				break;
			
			case "Curandero":
				tidus = new Curandero();
				break;
			
			case "Arcano":
				tidus = new Arcano();
				break;
		}
		
		tidus.setNombre(nombre);
		return tidus;
	}
	
	/**
	* Método que saca por pantalla las instrucciones para jugar a MouseGuardRPG. No tiene mucho mas, ya que genera String que luego los pasa 
	* por parametro a un JOptionPane
	*/
	
	public static void manualAyuda() {
		String mensaje = "Hola, bienvenido al magico mundo de Mouse Guard!\n\n El juego consiste en salir airoso de diez combates contra os depredadores habituales de un raton (tu).";
		String mensaje2 = "Primero deberas elegir tu clase, pudiendo escoger entre el valiente Guerrero, el astuto Montaraz, el precavido Curandero o el inmortal Lliurex";
		String mensaje3 = "Tras esto, podras elegir combatir contra un monstruo que ya conoces o contra alguien escogido segun tu nivel";
		String mensaje4 = "Y despues empieza el combate!\n Tendras que elegir entre estas cuatro estrategias:\n Atacar: hiere al enemigo con el arma\n Defender: te proteges este turno y ademas recuperas vida\nEnganyar: Despista al enemigo para que se haga danyo a si mismo\nManiobrar: Impresiona al enemigo y le resta ataque o defensa al azar";
		String mensaje5 = "La mecanica del juego es sencilla, ya que funciona bajo la logica del piedra, papel, tijera, por lo que solo hay una posible solucion a cada combinacion de estrategias";
		String mensaje6 = "El juego termina cuando ganas 10 combates o cuando mueres, asi que ten cuidado!";
		JOptionPane.showMessageDialog(null, mensaje);
		JOptionPane.showMessageDialog(null, mensaje2);
		JOptionPane.showMessageDialog(null, mensaje3);
		JOptionPane.showMessageDialog(null, mensaje4);
		JOptionPane.showMessageDialog(null, mensaje5);
		JOptionPane.showMessageDialog(null, mensaje6);

	}
}