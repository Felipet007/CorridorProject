
public class pruebas {
	private static Combate c = new Combate();
	private static Heroe h = new Barbaro();
	private static MouseGuardRPG raton = new MouseGuardRPG();
	private static Moneda coin = new Moneda();
	private static Curandero cura = new Curandero();
	
	public static void main(String[] args) {
		//pGenerarMonstruoAleatorio();
		//pGenerarMonstruo();
		//pCrearPersonaje();
		//pGetSet();
		//pHacerTirada();
		//pCurar_Curandero();
		
	}
	public static void pCrearPersonaje()
	{
		//Solo funciona en caso del barbaro
		Heroe esperado1 = new Barbaro();
		Heroe tidus = raton.crearPersonaje();
		if(tidus.getClass().equals(esperado1.getClass()))
		{
			System.out.println("si funciona");
		}
		else {
			System.out.println("no funciona");
		}
	}
	
	
	public static void pGenerarMonstruoAleatorio() {
		Bestiario b = c.generarMonstruo(h);
		String [] bestia1 = {"Leprecaun lascivo","1","2","2","1","1","2","3","2"};
		Bestiario esperado1 = new Bestiario(bestia1);
		String[] bestia2 = {"Chaman bizarro","1","2","2","1","1","2","3","2"};
		Bestiario esperado2 = new Bestiario(bestia2);
		if(b.getNombre().equals(esperado1.getNombre()) || b.getNombre().equals(esperado2.getNombre()))
		{
			System.out.println("El método funciona correctamente");
		}
		else {
			System.out.println("El método ha fallado");
		}
	}
	
	public static void pGenerarMonstruo() {
		
		String nombre = "Leprecaun lascivo";
		Bestiario b2 = c.generarMonstruo(nombre, h);
		if(b2.getNombre().equals(nombre))
		{
			System.out.println("el metodo funciona");
		}
		
		else {
			System.out.println("No funciona");
		}
	}
	public static void pGetSet() {
		String nombre ="nombre_prueba";
		int nivel = 5;
		int pv = 8;
		int pvMaximo = 10;
		int ataque_max = 10;
		int ataque = 8;
		int defensa_max = 10;
		int defensa = 8;
		int puntos = 1000;
		int pociones = 2;
		h.setNombre(nombre);
		h.setNivel(nivel);
		h.setPv(pv);
		h.setPvMaximo(pvMaximo);
		h.setAtaqueMax(ataque_max);
		h.setAtaque(ataque);
		h.setDefensaMax(defensa_max);
		h.setDefensa(defensa);
		h.setPuntos(puntos);
		h.setPociones(pociones);
		if(nombre.equals(h.getNombre())) {
			System.out.println("El nombre es el esperado");
		}
		else {
			System.out.println("El nombre no es el esperado");
		}
		if(nivel == h.getNivel()) {
			System.out.println("El nivel es el esperado");
		}
		else {
			System.out.println("El nivel no es el esperado");
		}
		if(pv == h.getPv()) {
			System.out.println("El pv es el esperado");
		}
		else {
			System.out.println("El pv no es el esperado");
		}
		if(pvMaximo == h.getPvMaximo()) {
			System.out.println("El pvMaximo es el esperado");
		}
		else {
			System.out.println("El pvMaximo no es el esperado");
		}
		if(ataque_max == h.getAtaqueMax()) {
			System.out.println("El Ataque Maximo es el esperado");
		}
		else {
			System.out.println("El Ataque Maximo no es el esperado");
		}
		if(ataque == h.getAtaque()) {
			System.out.println("El Ataque es el esperado");
		}
		else {
			System.out.println("El Ataque no es el esperado");
		}
		if(defensa_max == h.getDefensaMax()) {
			System.out.println("El Defensa Maximo es el esperado");
		}
		else {
			System.out.println("El Defensa Maximo no es el esperado");
		}
		if(defensa == h.getDefensa()) {
			System.out.println("La Defensa Máxima es la esperado");
		}
		else {
			System.out.println("La Defensa Máxima no es la esperado");
		}
		if(puntos == h.getPuntos()) {
			System.out.println("Los puntos son los esperados");
		}
		else {
			System.out.println("Los puntos no son los esperados");
		}
		if(pociones == h.getPociones()) {
			System.out.println("Las pociones son las esperadas");
		}
		else {
			System.out.println("Las pociones no son las esperadas");
		}
	}
	
	public static void pHacerTirada() {
		int tiradas = 5;
		boolean fallo = false;
		for (int i = 0; i<2500; i++)
		{
			if(coin.hacerTiradas(tiradas) > tiradas)
			{
				fallo = true;
			}
		}
		if(fallo == false)
		{
			System.out.println("Las tiradas son superiores que los resultados, por lo que es correcto");
		}
		else {
			System.out.println("Los resultados son mayores que las tiradas, hay un error");
		}
	}

	public static void pCurar_Curandero()
	{
		int vida = 2;
		int vidaMax = 10;
		int esperado = 6;
		cura.setPv(vida);
		cura.setPvMaximo(vidaMax);
		cura.curar(2);
	
		if(cura.getPv() == esperado)
		{
			System.out.println("se cura adecuadamente");
		}
	
		else {
			System.out.println("error,el metodo curar es distinto del valor esperado");
		}
		
	}
}
