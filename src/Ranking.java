import java.io.*;
import javax.swing.JOptionPane;

/**
* 
* @version 2.0
* @author Ratones Colores
*/

public class Ranking{
    public final int MAX_PUNTUACIONES = 10;
    private int grabados = 0;
    private String[] puntuacion = new String[MAX_PUNTUACIONES];

    public Ranking(){
        File ranking = new File(".ranking.txt");
        String linea;
        try {
            if(ranking.exists()){
                FileReader fileReader = new FileReader(ranking);
                BufferedReader reader = new BufferedReader(fileReader);
                while((linea = reader.readLine())!=null){
                    //System.out.println(linea);
                    puntuacion[grabados] = linea;
                    grabados++;
                }
                JOptionPane.showMessageDialog(null, "Ranking cargado");
                reader.close();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado un ranking previo, creando uno.");
                FileWriter fileWriter = new FileWriter(ranking);
                fileWriter.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de E/S");
        }
    }
    public void grabar(int puntuacionGrabar){
        String cadena;
        if(grabados == MAX_PUNTUACIONES){
        	if(puntuacionGrabar > Integer.parseInt(puntuacion[MAX_PUNTUACIONES-1].substring(4))) {
        		puntuacion[MAX_PUNTUACIONES-1] = "";
        		grabados--;
        	} else {
                return;
            }
        }
        do{
            cadena = JOptionPane.showInputDialog("Introduce tus iniciales (Tres letras)");
        } while (cadena.length() != 3);
        cadena += ";"+puntuacionGrabar;
        puntuacion[grabados] = cadena;
        grabados++; 
        actualizar();
    }

    private void actualizar(){
        String aux;
        int puntActual, puntSiguiente;
        //System.out.println("Hay " + grabados + " grabados");
        //ordenar array
        for(int i=0; i<(grabados-1); i++){
            for(int j=0; j<(grabados-1); j++){
                puntActual = Integer.parseInt(puntuacion[j].substring(4));
                puntSiguiente = Integer.parseInt(puntuacion[j+1].substring(4));
                if( puntActual <  puntSiguiente ){
                    aux = puntuacion[j+1];
                    puntuacion[j+1] = puntuacion[j];
                    puntuacion[j] = aux;
                }
            }
        }
        //actualizar fichero acorde a lo que hay en el array
        try {
            File ranking = new File (".ranking.txt");
            FileWriter fw = new FileWriter(ranking);
            BufferedWriter br = new BufferedWriter(fw);
            br.write("");
            //cambiar línea del fichero por línea a partir del string de puntuaciones
            for(int i = 0; i<grabados; i++) {
                //ystem.out.println(puntuacion[i] + "actualizar");
                br.append(puntuacion[i] + "\n");
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de E/S");
        }
    }

    private String convertir(String puntuacion){
        String[] arrayCadena = puntuacion.split(";");
        String cadena = "   " + arrayCadena[0] + "\t" + arrayCadena[1] + "\n";
        return cadena;
    }
    public String toString(){
        String cadena = "Jugador           Puntuación\n";
        for(int i = 0; i<grabados; i++) {
            cadena += convertir(puntuacion[i]);
        }
        return cadena;
    }
}