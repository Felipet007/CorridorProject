/**
* La clase abstracta Bestiario extiende a Luchador y establece el método clave de todas las clases que herederan de él,
*  decidir(), la cual enviará la estrategia elegida por la IA.
* @version 2.0
* @author Ratones Coloraos
*/

public class Bestiario extends Luchador{
	
	/**
	* @param puntosDar puntos de experiencia que se otorgaran al jugador si gana el combate
	*/
	/**
	* Constructor por defecto que otorga los puntos de experiencia que aportara al jugador en caso de salir victorioso del combate
	*/
	
	public Bestiario(String[] bestia) {
		System.out.println(bestia[0]+""+bestia[1]+""+bestia[2]+""+bestia[3]+""+bestia[4]+""+bestia[5]+"");
		setNombre(bestia[0]);
		setNivel(Integer.parseInt(bestia[1]));
		setAtaqueMax(Integer.parseInt(bestia[2])); 
		setDefensaMax(Integer.parseInt(bestia[3]));
		setPvMaximo(Integer.parseInt(bestia[4]));
		setPuntos(Integer.parseInt(bestia[5]));
		setPv(getPvMaximo());
		setAtaque(getAtaqueMax());
		setDefensa(getDefensaMax());
		
	}
	
	/**
	* El método decidir saca un numero al azar entre el 0 y el 1. A partir de su valor, decidirá una opción u otra.	
	* @see Math.random() es un método de la clase Math que devuelve un numero al azar
	* @return devuelve la estrategia con una cadena de caracteres
	* @param decision decimal de tipo double que almacena el numero aleatorio para realizar las condiciones más facilmente
	*/
	
	public String decidir(){
		double decision = Math.random();
		
		if (decision > 0.75){
			return "Atacar";
		} else if (decision > 0.5){
			return "Defender";
		} else if (decision > 0.25){
			return "Enganyar";
		} else {
			return "Maniobrar";
		}
	}
	
}