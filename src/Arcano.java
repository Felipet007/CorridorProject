import javax.swing.JOptionPane;

/**
* Clase Arcano define una de las clases seleccionables con el ataque y la defensa definitivas
* @version 2.0
* @author Ratones Coloraos
*/

public class Arcano extends Heroe{
	
	public Arcano() {
		setPvMaximo(8);
		setPv(getPvMaximo());
		setAtaqueMax(6);
		setDefensaMax(7);
		setAtaque(getAtaqueMax());
		setDefensa(getDefensaMax());
	}
}

/**
* Clase Barbaro define una de las clases seleccionables con el ataque y la defensa definitivas
* @version 2.0
* @author Ratones Coloraos
*/

class Barbaro extends Heroe{
	
	public Barbaro() {
		setPvMaximo(9);
		setPv(getPvMaximo());
		setAtaqueMax(7);
		setDefensaMax(5);
		setAtaque(getAtaqueMax());
		setDefensa(getDefensaMax());
	}
	
	public int tiradaAtaque(){
		int tirada = Moneda.hacerTiradas(getAtaque());
		boolean critico = Moneda.caraOCruz();
		
		if (Moneda.darCritico(getNivel()*2)){
			tirada = tirada * 2;
		}
		
		return tirada;
	}
	
	public int tiradaDefensa(){
		int tirada = Moneda.hacerTiradas(getDefensa());
		
		if (Moneda.darCritico(getNivel()*2)){
			tirada = tirada * 2;
		}
		
		return tirada;
	}
}

/**
* Clase Burlón define una de las clases seleccionables con el ataque y la defensa definitivas
* @version 2.0
* @author Ratones Coloraos
*/

class Burlon extends Heroe{
	
	public Burlon() {
		setPvMaximo(9);
		setPv(getPvMaximo());
		setAtaqueMax(7);
		setDefensaMax(6);
		setAtaque(getAtaqueMax());
		setDefensa(getDefensaMax());
	}
}

/**
* Clase Curandero define una de las clases seleccionables con el ataque y la defensa definitivas
* @version 2.0
* @author Ratones Coloraos
*/

class Curandero extends Heroe{
	
	public Curandero() {
		setPvMaximo(7);
		setPv(getPvMaximo());
		setAtaqueMax(6);
		setDefensaMax(8);
		setAtaque(getAtaqueMax());
		setDefensa(getDefensaMax());
	}
	
	/**
	* Sobreescribe el metodo curar para que el Curandero tenga la habilidad especial de curar el doble
	*/
	
	public void curar(int i){
		i = i*2;
		String mensaje = nombre + " ha recuperado " + i + " puntos de vida";
		setPv(getPv()+i);
		JOptionPane.showMessageDialog(null, mensaje);
	}
}