import javax.swing.JOptionPane;
import java.io.*;

/**
* La clase abstracta Heroe extiende a Luchador y es la que sienta las bases del personaje que jugará el
* cliente. Define métodos como subirNivel o finDelCombate.
* @version 2.0
* @author Ratones Coloraos
*/ 

public abstract class Heroe extends Luchador implements Serializable {
	/**
	* @param puntos almacena los puntos de experiencia que tiene hasta ahora el jugador
	*/
	private int pociones;
	private int expNec=100;
	private int puntos = 0;
	/**
	* Constructor por defecto de la clase Heroe que otorga el nivel y los puntos vitales iniciales para el jugador
	*/
	
	public Heroe () {
		setPvMaximo(5);
		setPv(getPvMaximo());
		setNivel(1);
		setPociones(2);
	}
	
	
	/**
	* metodo set de la variable pociones
	*/
	
	public void setPociones(int a){
		pociones = a;
	}
	
	/**
	* metodo get de la variable pociones
	*/
	
	public int getPociones(){
		return pociones;
	}
	/**
	* metodo get de la variable experiencia necesaria
	*/
	public int getExpNec() {
		return expNec;
	}
	/**
	* metodo set de la variable experiencia necesaria
	*/
	public void setExpNec(int expNec) {
		this.expNec = expNec;
	}
	
	public boolean tomarPocion()
	{
		if(getPociones() > 0)
		{
			pociones --;
			return true;
		}
		else
		{
			return false;
		}
		
	}
	/**
	* Este método elige al azar si subirá el stat de ataque o defensa. También aumentará la vida. 
	* Cada vez que se llega a 100, se sube de nivel y se pone el contador a cero de nuevo (se tiene en cuenta
	* los puntos de experiencia que sobran). 
	*/
	public void subirNivel(){
		setPvMaximo(getPvMaximo()+2); //Subo los PV
			
		//Subo ataque o defensa
		if(Moneda.caraOCruz()){ //Si es true, sube ataque
			setAtaqueMax(getAtaqueMax() + 1);
		} else { //Si no, sube la defensa
			setDefensaMax(getDefensaMax() + 1);
		}
		setNivel(getNivel()+1);
		setExpNec((int)(getExpNec()+(1.5*getExpNec())));
		JOptionPane.showMessageDialog(null, "Has subido de nivel");
		
	}

	/**
	 * Metodo para recibir la experiencia tras vecer al enemigo
	 * @param exp experiencia recibida
	 */
	public void recibirExp(int exp) {
		int total = getPuntos()+exp;
		setPuntos(total);
		if((getPuntos())>=getExpNec()) {
			subirNivel();
		}
	}
}