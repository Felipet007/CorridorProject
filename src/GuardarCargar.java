import java.io.*;

/**
* 
* @version 2.0
* @author Ratones Colores
*/

public class GuardarCargar {
	public static void guardar(Heroe a, Combate c) {
		try{
			FileOutputStream fichero = new FileOutputStream("Guardado.ych");
			ObjectOutputStream tunelSalida = new ObjectOutputStream(fichero);
		
			tunelSalida.writeObject(a);
			tunelSalida.writeObject(c);
		
			tunelSalida.close();
			fichero.close();
		} catch(Exception ex){
			System.out.println("No se ha guardado bien");
		}
	}
	
	public static Object[] cargar() {
		Object[] datos = new Object[2];
		
		try {
			FileInputStream ficheroEntra = new FileInputStream("Guardado.ych");
			ObjectInputStream tunelEntrada = new ObjectInputStream(ficheroEntra);
			
			datos[0] = tunelEntrada.readObject();
			datos[1] = tunelEntrada.readObject();
			
			tunelEntrada.close();
			ficheroEntra.close();
		
		} catch(Exception ex){
			System.out.println("No se ha recuperado bien");
		}
		
		return datos;
	}
}
