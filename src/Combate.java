

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
* Clase Combate es una clase estática cuyos metodos estan directamente relacionados con los combates en los que participara el jugador
* @version 2.0
* @author Ratones Coloraos
*/

public class Combate implements Serializable {
	private static ArrayList<String[]> bestiasArray = new ArrayList<String[]>();
	private static boolean cargado = false;
	private boolean [] desbloqueados = {false,false,false,false,false,false,false,false,false,false};
	private int nCombates = 1;
	
	public int getNCombates() {
		return nCombates;
	}
	
	public void setNCombates(int shiva) {
		nCombates = shiva;
	}
	
	/**
	* En caso que el jugador decida no buscar ningun monstruo en especifico, se ejecutará este método, el cual pide que se pase por parámetro
	* el objeto del jugador para analizar su nivel y crear una bestia acorde a sus atributos.
	* @param h objeto de tipo Heroe correspondiente al jugador
	* @param bestia contenedor que hace referencia al monstruo que está por crear
	* @return monstruo ya creado
	*/
	public Bestiario generarMonstruo(Heroe h){
		cargarMonstruos();
		Bestiario bestia = null;
		if(Math.random()>0.5)
		{
			desbloqueados[h.getNivel()]=true;
			bestia = new Bestiario (bestiasArray.get(h.getNivel()));
		}
		else {
			desbloqueados[h.getNivel()-1]=true;
			bestia = new Bestiario (bestiasArray.get(h.getNivel()-1));
		}
		String mensaje = "Vas a luchar contra " + bestia.getNombre();
		JOptionPane.showMessageDialog(null,mensaje);
		return bestia;
	}
	/**
	* El jugador tiene la opción de elegir un monstruo que ya conoce.
	* @param e String con el nombre del monstruo al que quiere retar. 
	* @param bestia contenedor que hace referencia al monstruo que está por crear
	* @return monstruo ya creado
	*/
	public Bestiario generarMonstruo(String e, Heroe h){
		cargarMonstruos();
		Bestiario bestia = null;
		switch (e){
			case "Leprecaun lascivo": 
				bestia = generar(e);
				desbloqueados[0] = true;
				break;
			
			case "Chaman Bizarro": 
				bestia = generar(e);
				desbloqueados[1] = true;
				break;
			
			case "Chuqui": 
				bestia = generar(e);
				desbloqueados[2] = true;
				break;
			
			case "Grey el fantoche": 
				bestia = generar(e);
				desbloqueados[3] = true;
				break;
			
			case "La Yoli zascandil":
				bestia = generar(e);
				desbloqueados[4] = true;
				break;
			
			case "Ogro de cieza": 
				bestia = generar(e);
				desbloqueados[5] = true;
				break;
					
			case "Windigo":
				bestia = generar(e);
				desbloqueados[6] = true;
				break;
					
			case "El comedor de detritos": 
				bestia = generar(e);
				desbloqueados[7] = true;
				break;
					
			case "Espantajo malogrado":
				bestia = generar(e);
				desbloqueados[8] = true;
				break;
					
			case "El mal":
				bestia = generar(e);
				desbloqueados[9] = true;
				break;
					
			default: 
				bestia = generarMonstruo(h);
				break;
		}
		
		String mensaje = "Vas a luchar contra " + bestia.getNombre();
		JOptionPane.showMessageDialog(null,mensaje);
		return bestia;
	}
	
	/**
	* Metodo exclusivo para la resolucion de Estrategias. Esta compara las decisiones de ambas partes y tomara una accion u otra en consecuencia.
	* Lo hace mediante if/else if.
	* @param a objeto referente al jugador
	* @param b String con la decision del jugador
	* @param c objeto referente al rival
	* @param d String con la decision del rival
	*/
	public void resolucionRonda (Heroe a, String b, Bestiario c, String d){
		//a -> Heroe, b-> Decision del heroe || c -> Monstruo, d-> Decision del monstruo
		// Atacar, Defender, Enganyar, Maniobrar y Pocion
		// En caso de pocion el heroe tenga alguna poción se cura toda la vida, sino será vulnerable ese turno.
		
		if (b.equals("Atacar") && d.equals("Atacar")){
			a.danyar(c.tiradaAtaque());
			c.danyar(a.tiradaAtaque());
		} else if (b.equals("Atacar") && d.equals ("Defender")){
			c.curar(c.tiradaDefensa());
		} else if (b.equals("Atacar") && d.equals ("Enganyar")){
			c.danyar(a.tiradaAtaque());
		} else if (b.equals("Atacar") && d.equals ("Maniobrar")){
			c.danyar(a.tiradaAtaque());
		} else if (b.equals("Defender") && d.equals ("Atacar")){
			a.curar(a.tiradaDefensa());
		} else if (b.equals("Defender") && d.equals ("Defender")){
			a.curar(a.tiradaDefensa());
			c.curar(c.tiradaDefensa());
		} else if (b.equals("Defender") && d.equals ("Enganyar")){
			a.danyar(c.tiradaAtaque()*2);
		} else if (b.equals("Defender") && d.equals ("Maniobrar")){
			a.penalizar(c.tiradaDefensa());
		} else if (b.equals("Enganyar") && d.equals ("Atacar")){
			a.danyar(c.tiradaAtaque());
		} else if (b.equals("Enganyar") && d.equals ("Defender")){
			c.danyar(a.tiradaAtaque()*2);
		} else if (b.equals("Enganyar") && d.equals ("Enganyar")){
			c.danyar(a.tiradaAtaque());
			a.danyar(c.tiradaAtaque());
		} else if (b.equals("Enganyar") && d.equals ("Maniobrar")){
			a.penalizar(c.tiradaDefensa());
		} else if (b.equals("Maniobrar") && d.equals ("Atacar")){
			a.danyar(c.tiradaAtaque());
		} else if (b.equals("Maniobrar") && d.equals ("Defender")){
			c.penalizar(a.tiradaDefensa());
		} else if (b.equals("Maniobrar") && d.equals ("Enganyar")){
			c.penalizar(a.tiradaDefensa());
		} else if (b.equals("Maniobrar") && d.equals ("Maniobrar")){
			c.penalizar(a.tiradaDefensa());
			a.penalizar(a.tiradaDefensa());
		} else if (b.equals("Pocion")){
			if (a.tomarPocion()==true){
				a.setPv(a.getPvMaximo());
				JOptionPane.showMessageDialog(null,"Has usado una pocion.\nPociones: "+a.getPociones());
			}else{
				JOptionPane.showMessageDialog(null,"No te quedan pociones.\nEsta ronda eres vulnerable");
				if(d.equals("Atacar")){
					a.danyar(c.tiradaAtaque());
				}if(d.equals ("Defender")){
					c.curar(c.tiradaDefensa());
				}
			}
		}
		String mensaje = "Stats actuales\n\n" + a.toString() + "\n\n" + c.toString();
		
		JOptionPane.showMessageDialog(null, mensaje);
	}

	
	/**
	* Metodo que resume todos los metodos definidos en la clase Combate. La funcion de este metodo es encadenar un combate detras de otro hasta que se
	* derroten diez monstruos consecutivos o que el jugador fallezca. Para ello utiliza un bucle en que primero crea a la bestia, luego realiza el combate
	* y por último recupera los atributos (pv, ataque y defensa) del jugador.
	* @param a contenedor de tipo Heroe con el personaje creado por el jugador
	* @param monstruo String que contiene en su interior el nombre del monstruo al que se quiere enfrentar el jugador (si es que quiere)
	* @param bestia contenedor de tipo Bestiario que contiene el monstruo contra el que se va a luchar en este momento
	* @param numCombates variable que cuenta el numero de combates hasta ahora, es usada para sacar un mensaje informativo y para salir del bucle cuando se llega a 10
	* @param mensaje String para sacar por pantalla el numero de combate al que se enfrenta el jugador
	*/
	public void entrarEnLaArena (Heroe a, Ranking ran) {
		String monstruo;
		Bestiario bestia = null;
		String mensaje;
		String guardar;
		String verLibro;
		boolean vivo = true;
		LibroBestias libro;
		
		do {
			mensaje = "Combate " + nCombates;
			JOptionPane.showMessageDialog(null,mensaje);
			
			//LibroBestias
			verLibro = JOptionPane.showInputDialog("Quieres ver el libro de bestias? S/N");
			if (verLibro.equals("S")){
				libro = new LibroBestias(this.desbloqueados);
				libro.setVisible(true);
				
				while(libro.vista){
					System.out.print("");
				}
			}
			
			monstruo = JOptionPane.showInputDialog("Ingresa el nombre del monstruo contra el que quieras pelear (si no pones nada, se elige al azar)");
			if (monstruo.equals("")){
				bestia = generarMonstruo(a);
			} else {
				bestia = generarMonstruo(monstruo,a);
			}
		
			combatir(a,bestia);
			
			if (a.getPv()<=0) {
				nCombates = 15;
				JOptionPane.showMessageDialog(null, "Vaya, has muerto! Pero puedes volver a intentarlo");
				vivo = false;
			} else {
				a.renovar();
				guardar = JOptionPane.showInputDialog("Quieres guardar? S/N");
				nCombates++;
				if (guardar.equals("S")) {
					
					GuardarCargar.guardar(a, this);
					nCombates = 15;
					vivo = false;
				}
			}
		} while (nCombates<11);
		
		if (vivo){
			JOptionPane.showMessageDialog(null, "Enhorabuena! Has ganado el titulo a Rey de la Arena!");
			ran.grabar(a.getPuntos());
		}
	}
	
	/**
	* Este metodo reune resolucionRonda y otros metodos de la clase Luchador para configurar un combate (SOLO UNO). Mediante un do while, va encadenando las rondas
	* hasta que uno de los dos rivales fallece. También utiliza un bucle a la hora de pedir la estrategia al usuario, teniendo en cuenta que puede elegir una que no
	* exista o que este mal escrita. 
	* @param decisionHeroica String que contendra la estrategia elegida por el jugador en cada ronda
	* @param x contador referente a la eleccion de estrategias
	* @param y contador referente al bucle del combate
	* @param ronda contador que almacena el numero de rondas hasta el momento
	* @param rondaMensaje variable String utilizada para sacar el numero de rondas por pantalla
	* @see en las rondas multiplo de cinco se llama a los metodos renovar de ambos rivales, como dicen las normas de Mouse Guard RPG
	*/
	public void combatir(Heroe a, Bestiario c){
		String decisionHeroica = "";
		int x = 0;
		int ronda = 1;
		String rondaMensaje = "";
		int y = 100;
		
		do {
			rondaMensaje = "Ronda " + ronda;
			JOptionPane.showMessageDialog(null, rondaMensaje);
			while (x <5 ){
				decisionHeroica = JOptionPane.showInputDialog("Elige la estrategia (respeta las mayusculas)\n\nAtacar\nDefender\nManiobrar\nEnganyar\nPocion");
			
					if (decisionHeroica.equals("Atacar") || decisionHeroica.equals("Defender") || decisionHeroica.equals("Maniobrar") || decisionHeroica.equals("Enganyar") || decisionHeroica.equals("Pocion")){
						x = 100;
					} else {
						JOptionPane.showMessageDialog(null, "Estrategia erronea");
					}
			}
			
			resolucionRonda(a,decisionHeroica,c, c.decidir());
			
			if (ronda%5==0){
				a.renovar();
				c.renovar();
			}
			
			ronda++;
			x = 0;
			
			if (c.getPv()<=0){
				y = 0;
				JOptionPane.showMessageDialog(null,"Has derrotado al monstruo");
				a.recibirExp(c.getPuntos());
				a.renovar();
			} else if (a.getPv()<=0) {
				y = 0;
			}
			
		} while (y > 50);
	}
	
	/**
	* Este metodo es una version de entrarEnLaArena() para añadir la nueva opción de combate unico al videojuego. 
	* @param monstruo String que contendra el nombre del monstruo elegido para combatir contra él 
	* @param bestia referencia de tipo Bestiario que contendrá el monstruo al que se va a enfrentar
	* @see al contrario de entrarEnLaArena(), aqui no hay un bucle, por lo que solo se realizará un combate
	*/
	
	public void combateUnico(Heroe d){
		String monstruo;
		Bestiario bestia = null;

		JOptionPane.showMessageDialog(null,"Solo libraras un combate");
		monstruo = JOptionPane.showInputDialog("Ingresa el nombre del monstruo contra el que quieras pelear (si no pones nada, se elige al azar)");
		if (monstruo.equals("")){
			bestia = generarMonstruo(d);
		} else {
			bestia = generarMonstruo(monstruo,d);
		}
		
		combatir(d,bestia);
		
		if (d.getPv()<=0) {
			JOptionPane.showMessageDialog(null, "Vaya, has muerto! Pero puedes volver a intentarlo");
		} else {
			d.renovar();
			JOptionPane.showMessageDialog(null, "Enhorabuena! Has vencido");				
		}
	}
	
	/**
	* Versión de resolucion adaptado a los combates Player vs. Player 
	* @param a referencia al jugador 1
	* @param b estrategia adoptada por el jugador 1
	* @param c referencia al jugador 2
	* @param d estrategia adoptada por el jugador 2
	* @see es idéntico al metodo resolucionRonda(), solo que cambiando el parámetro de Bestiario por Heroe
	*/
	
	public void resolucionRondaPVP (Heroe a, String b, Heroe c, String d){
		//a -> Jugador 1, b-> Decision del Jugador 1 || c -> Jugador 2, d-> Decision del Jugador 2
		// Atacar, Defender, Enganyar y Maniobrar
		
		if (b.equals("Atacar") && d.equals("Atacar")){
			a.danyar(c.tiradaAtaque());
			c.danyar(a.tiradaAtaque());
		} else if (b.equals("Atacar") && d.equals ("Defender")){
			c.curar(c.tiradaDefensa());
		} else if (b.equals("Atacar") && d.equals ("Enganyar")){
			c.danyar(a.tiradaAtaque());
		} else if (b.equals("Atacar") && d.equals ("Maniobrar")){
			c.danyar(a.tiradaAtaque());
		} else if (b.equals("Defender") && d.equals ("Atacar")){
			a.curar(a.tiradaDefensa());
		} else if (b.equals("Defender") && d.equals ("Defender")){
			a.curar(a.tiradaDefensa());
			c.curar(c.tiradaDefensa());
		} else if (b.equals("Defender") && d.equals ("Enganyar")){
			a.danyar(c.tiradaAtaque()*2);
		} else if (b.equals("Defender") && d.equals ("Maniobrar")){
			a.penalizar(c.tiradaDefensa());
		} else if (b.equals("Enganyar") && d.equals ("Atacar")){
			a.danyar(c.tiradaAtaque());
		} else if (b.equals("Enganyar") && d.equals ("Defender")){
			c.danyar(a.tiradaAtaque()*2);
		} else if (b.equals("Enganyar") && d.equals ("Enganyar")){
			c.danyar(a.tiradaAtaque());
			a.danyar(c.tiradaAtaque());
		} else if (b.equals("Enganyar") && d.equals ("Maniobrar")){
			a.penalizar(c.tiradaDefensa());
		} else if (b.equals("Maniobrar") && d.equals ("Atacar")){
			a.danyar(c.tiradaAtaque());
		} else if (b.equals("Maniobrar") && d.equals ("Defender")){
			c.penalizar(a.tiradaDefensa());
		} else if (b.equals("Maniobrar") && d.equals ("Enganyar")){
			c.penalizar(a.tiradaDefensa());
		} else if (b.equals("Maniobrar") && d.equals ("Maniobrar")){
			c.penalizar(a.tiradaDefensa());
			a.penalizar(a.tiradaDefensa());
		}
		String mensaje = "Stats actuales\n\n" + a.toString() + "\n\n" + c.toString();
		
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	/**
	* Este metodo reune resolucionRonda y otros metodos de la clase Luchador para configurar un combate (SOLO UNO) contra un jugador. 
	* Al igual que el metodo combatir(), el metodo soluciona el combate mediante un bucle que irá pidiendo las estrategias que quieren
	* adoptar los jugadores. 
	* @param decisionHeroica String que contendra la estrategia elegida por el jugador en cada ronda
	* @param decisionHeroica2 String que contendra la estrategia elegida por el segundo jugador en cada ronda
	* @param x contador referente a la eleccion de estrategias
	* @param y contador referente al bucle del combate
	* @param ronda contador que almacena el numero de rondas hasta el momento
	* @param rondaMensaje variable String utilizada para sacar el numero de rondas por pantalla
	* @see este metodo llama a resolucionRondaPVP(), y en vez de realizar un bucle para pedir estrategia, realiza dos 
	*/
	
	public void combatirPVP(Heroe a, Heroe c){
		String decisionHeroica = "";
		String decisionHeroica2 = "";
		int x = 0;
		int ronda = 1;
		String rondaMensaje = "";
		int y = 100;
		
		do {
			rondaMensaje = "Ronda " + ronda;
			JOptionPane.showMessageDialog(null, rondaMensaje);
			while (x <5 ){
				decisionHeroica = JOptionPane.showInputDialog(a.getNombre()+", elige la estrategia (respeta las mayusculas)\n\nAtacar\nDefender\nManiobrar\nEnganyar");
			
					if (decisionHeroica.equals("Atacar") || decisionHeroica.equals("Defender") || decisionHeroica.equals("Maniobrar") || decisionHeroica.equals("Enganyar")){
						x = 100;
					} else {
						JOptionPane.showMessageDialog(null, "Estrategia erronea");
					}
			}
			
			x = 0;
			
			while (x <5 ){
				decisionHeroica2 = JOptionPane.showInputDialog(c.getNombre()+", elige la estrategia (respeta las mayusculas)\n\nAtacar\nDefender\nManiobrar\nEnganyar");
			
					if (decisionHeroica2.equals("Atacar") || decisionHeroica2.equals("Defender") || decisionHeroica2.equals("Maniobrar") || decisionHeroica2.equals("Enganyar")){
						x = 100;
					} else {
						JOptionPane.showMessageDialog(null, "Estrategia erronea");
					}
			}
			
			x = 0;
			
			resolucionRondaPVP(a,decisionHeroica,c, decisionHeroica2);
			
			if (ronda%5==0){
				a.renovar();
				c.renovar();
			}
			
			ronda++;
			
			
			if (c.getPv()<=0){
				y = 0;
				JOptionPane.showMessageDialog(null,"Ha ganado "+a.getNombre()+ ". Enhorabuena!");
			} else if (a.getPv()<=0) {
				y = 0;
				JOptionPane.showMessageDialog(null,"Ha ganado "+c.getNombre()+ ". Enhorabuena!");
			}
			
		} while (y > 50);
	}
	public Bestiario generar (String e)
	{
		String [] auxiliar;
		Bestiario bestia = null;
		for(int i = 0; i<bestiasArray.size();i++)
		{
			auxiliar = bestiasArray.get(i);
			if(e.equals(auxiliar[0]))
			{
				desbloqueados[i]=true;
				bestia = new Bestiario (bestiasArray.get(i));
			}
		}
		return bestia;
	}
	public static void cargarMonstruos()
	{
		if(cargado == false) {
			try {
				File myFile = new File("granja.txt");
				FileReader fileReader = new FileReader(myFile);
				BufferedReader reader = new BufferedReader (fileReader);
				String linea = null;
				while((linea = reader.readLine())!=null) {
					String[] partes = linea.split("/");
					String monstruo [] = {partes[0],partes[1], partes[2],partes[3],partes[4],partes[5]};
					bestiasArray.add(monstruo);
				}
				reader.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		cargado = true;
	}
	public void setDesbloqueados(boolean[] des) {
		desbloqueados = des;
	}
	public boolean[] getDesbloqueados() {
		return desbloqueados;
	}
}