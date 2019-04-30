import javax.swing.JOptionPane;

import java.io.*;
/**
* Clase Luchador es el nexo comun entre Bestiario y Luchador. Define los atributos base, sus getters y sus setters y los metodos fundamentales
* para el combate, como ahora curar o penalizar.
* @version 2.0
* @author Ratones Coloraos
*/

public abstract class Luchador implements Serializable {
	
	/**
	* @param nombre nombre de la unidad
	* @param nivel nivel de la unidad, el jugador empezara por el 1, pero el de las bestias variará en función de la dificultad
	* @param pv vida que tiene actualmente la unidad
	* @param pvMaximo vida maxima que tiene la unidad. Fundamental para el metodo renovar
	* @param ataque_max ataque que tiene la unidad sin tener en cuenta las penalizaciones. Fundamental para renovar
	* @param defensa_max defensa que tiene la unidad sin tener en cuenta las penalizaciones. Fundamental para renovar
	* @param ataque ataque actual que tiene la unidad
	* @param defensa defensa actual que tiene la unidad
	*/
	
	protected String nombre;
	protected int nivel;
	protected int pv;
	protected int pvMaximo;
	protected int ataque_max = 0;
	protected int defensa_max = 0;
	protected int ataque = 0;
	protected int defensa = 0;
	private int puntos;
	
	/**
	* Metodo set de la variable Nombre
	*/
	
	public void setNombre(String a){
		nombre = a;
	}
	/**
	* Metodo get de la variable Nombre
	*/
	public String getNombre(){
		return nombre;
	}
	/**
	* Metodo get de la variable nivel
	*/
	public int getNivel(){
		return nivel;
	}
	/**
	* Metodo set de la variable nivel
	*/
	public void setNivel(int z){
		nivel = z;
	}
	/**
	* Metodo set de la variable pv
	*/
	public void setPv(int b){
		
		
		if((getPv()+b)<=getPvMaximo()){
			pv = b;
		} else {
			pv = getPvMaximo();
		}
		
		if(pv<0){
			pv = 0;
		}
	}
	/**
	* Metodo get de la variable pv
	*/
	public int getPv(){
		return pv;
	}
	/**
	* Metodo set de la variable pvMaximo
	*/
	public void setPvMaximo(int c){
		pvMaximo = c;
	}
	/**
	* Metodo get de la variable pvMaximo
	*/
	public int getPvMaximo(){
		return pvMaximo;
	}
	/**
	* Metodo set de la variable ataque_max
	*/
	public void setAtaqueMax(int d){
		ataque_max = d;
	}
	/**
	* Metodo get de la variable ataque_max
	*/
	public int getAtaqueMax(){
		return ataque_max;
	}
	/**
	* Metodo set de la variable defensa_max
	*/
	public void setDefensaMax(int e){
		defensa_max = e;
	}
	/**
	* Metodo get de la variable defensa_max
	*/
	public int getDefensaMax(){
		return defensa_max;
	}
	/**
	* Metodo set de la variable ataque
	*/
	public void setAtaque(int f){
		ataque = f;
	}
	/**
	* Metodo get de la variable ataque
	*/
	public int getAtaque(){
		return ataque;
	}
	/**
	* Metodo set de la variable defensa
	*/
	public void setDefensa(int g){
		defensa = g;
	}
	/**
	* Metodo get de la variable defensa
	*/
	public int getDefensa(){
		return defensa;
	}
	/**
	* metodo set de la variable puntos
	*/
	
	public void setPuntos(int a){
		puntos = a;
	}
	
	/**
	* metodo get de la variable puntos
	*/
	
	public int getPuntos(){
		return puntos;
	}
	/**
	* Metodo que llama a la clase Moneda y le pasa por valor el ataque actual de la unidad
	* @return devuelve el grado de exito de la accion elegida por la unidad
	*/
	
	public int tiradaAtaque(){
		int tirada = Moneda.hacerTiradas(getAtaque());
		
		if (Moneda.darCritico(getNivel())){
			tirada = tirada * 2;
		}
		
		return tirada;
	}
	
	/**
	* Metodo que llama a la clase Moneda y le pasa por valor la defensa actual de la unidad
	* @return devuelve el grado de exito de la accion elegida por la unidad
	*/
	
	public int tiradaDefensa(){
		int tirada = Moneda.hacerTiradas(getDefensa());
		
		if (Moneda.darCritico(getNivel())){
			tirada = tirada * 2;
		}
		
		return tirada;
	}
	
	/**
	* Metodo que recibirá el grado de exito de una tirada de Ataque y lo restará a la vitalidad actual de la unidad.
	* @param mensaje tambien se generara un mensaje que se emitira por JOptionPane en el que informara los puntos de vida perdidos
	*/
	
	public void danyar(int h){
		String mensaje = nombre + " ha perdido " + h + " puntos de vida";
		setPv(getPv()-h);
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	/**
	* Metodo que recibirá el grado de exito de una tirada de Defensa y lo sumará a la vitalidad actual de la unidad (sin superar nunca el pv maximo).
	* @param mensaje tambien se generara un mensaje que se emitira por JOptionPane en el que informara los puntos de vida recuperados
	*/
	
	public void curar(int i){
		String mensaje = nombre + " ha recuperado " + i + " puntos de vida";
		setPv(getPv()+i);
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	/**
	* Metodo que devuelve a las variables ataque y defensa sus valores predeterminados (que son los mismos que el ataque_max y la defensa_max)
	*/
	
	public void renovar(){
		setAtaque(getAtaqueMax());
		setDefensa(getDefensaMax());
	}
	
	/**
	* Método que recibirá el grado de exito de una tirada de Ataque y lo restará a uno de los dos atributos base de la unidad (ataque y defensa), para elegir cual de los dos, tirara una moneda y si sale cara ira a por el ataque. Si sale false, a por la defensa.
	* @see lanza una moneda desde la clase Moneda. 
	* @param mensaje tambien se genera un mensaje que informa de los puntos perdidos y cuál es el atributo afectado
	*/
	
	public void penalizar(int j){
		String mensaje;
		if (Moneda.caraOCruz() == true){ //Si sale cara, penalizara al ataque
			mensaje = nombre + " ha perdido " + j + " puntos de ataque";
			setAtaque(getAtaque() - j);
		} else { //Si no, penalizara la defensa
			mensaje = nombre + " ha perdido " + j + " puntos de defensa";
			setDefensa(getDefensa() - j);
		}
		
		JOptionPane.showMessageDialog(null, mensaje);

		
		if (getAtaque() < 0){
			setAtaque(0);
		}
		
		if (getDefensa() < 0){
			setDefensa(0);
		}
	}
	
	/**
	* Método sobreescrito de la clase Object. 
	* @return devuelve un String con el valor de los atributos de la unidad
	*/
	
	public String toString(){
		
		return nombre +"\nNivel: " + getNivel() + "\nPV Actuales: " + getPv() +"\nAtaque actual: " + getAtaque() +"\nDefensa actual: " + getDefensa() + "\nExperiencia Actual:"+getPuntos();
	}
	
}