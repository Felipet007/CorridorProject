/**
* Clase Moneda es una clase estática con la función de generar datos al azar
* para el combate, como ahora curar o penalizar.
* @version 2.0
* @author Ratones Coloraos
*/

public class Moneda{
	
	/**
	* Metodo base de la clase Moneda. Simula el lanzamiento de una moneda al pedir un numero aleatorio y redondearlo.
	* @return si el resultado es 1, devolvera true; pero si el resultado es 0, false. 
	*/
	public static boolean caraOCruz(){
		
		byte sorpresa = (byte) Math.round(Math.random());
		
		if (sorpresa == 1){
			return true;
		} else {
			return false;
		}
	}
	/**
	* Metodo que bebe del metodo caraOCruz. Tirara tantas monedas como valor tenga numero y sumara +1 a resultado si esta sale cara.
	* @param numero marca el numero de veces que se habra de tirar la moneda
	* @param resultado almacena el numero de caras que se han obtenido
	* @return se devuelve resultado e indicara el grado de exito que ha tenido 
	*/
	public static int hacerTiradas(int numero){
		int resultado = 0;
		
		for (int x=0; x<numero ; x++){
			if (caraOCruz() == true){
				resultado++;
			}
		}
		
		return resultado;
	}
	public static boolean darCritico(int nivel){
		double random = Math.round(Math.random()) * 100;
		boolean critico = false;
		
		if (random >= (100-nivel)){
			critico = true;
		}
		
		return critico;
		
	}
	
}