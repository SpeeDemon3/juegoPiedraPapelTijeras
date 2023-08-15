import java.util.Scanner;

/**
 * @author Antonio Ruiz Benito -> SpeedDemoN
 */
public class Function {
	
	static Scanner sc = new Scanner(System.in);
	// Variables con las posibles valores
	private static final String STONE = "P";
	private static final String PAPER = "L";
	private static final String SCISSORS = "T";
	
	// Variables para repartir puntos
	private static final int USER = 1;
	private static final int MACHINE = 0;

	// Guardo los posibles valores
	private static final String[] plays = {STONE, PAPER, SCISSORS};
	

	/**
	 * Metodo con la instrucciones del juego
	 */
	public static void instructions() {
		
		System.out.println("Instrucciones Piedra, papel, tijeras:\n"
				+ "1. Ganara el primero que gane 3 partidas.\n"
				+ "2. Piedra gana a tijeras.\n"
				+ "3. Papel gana a piedra.\n"
				+ "4. Tijeras gana a papel.\n"
				+ "\n++++ QUE GANE EL MEJOR!!! ++++\n");
		
	}
	
	/**
	 * Metodo para mostrar el menu al usuario
	 */
	public static void menu() {
		
		System.out.println("### MENU ###\n"
				+ "Pulsa [P] o [p] para seleccionar 'PIEDRA'.\n"
				+ "Pulsa [L] o [l] para seleccionar 'PAPEL'.\n"
				+ "Pulsa [T] o [t] para seleccionar 'TIJERAS'.\n"
				+ "Pulsa [S] o [s] para salir de la app.\n");
			
	}
	
	
	/**
	 * Metodo para generar la opcion que
	 * seleccionara la maquina
	 * @return -> opcion escogida
	 */
	public static String generateRandomPlay() {

		// Genero un numero entre 0 y 2
		int numRandom = (int) (Math.random() * (2 - 0 + 1) + 0);
		// Retorno el numero aleatorio
		return plays[numRandom];
		
	}
	
	/**
	 * Metodo para comprobar si el caracter pasado
	 * por parametros esta dentro de los permitidos
	 * @param character -> Caracter que se desea comprobar
	 * @return -> True o false dependiendo del caso
	 */
	public static boolean checkCharacter(String character) {
			
		for (String c : plays) {
			// Compruebo si conincide con algun caracter
			if (character.equalsIgnoreCase(c)) {
				
				return true;
			}
							
		}
		
		return false;
		
	}
	
	/**
	 * Metodo para comprobar quien gana
	 * la ronda
	 * @param user -> Letra introducida por el usuario
	 * @param machine -> Letra introducida por la maquina
	 * @return -> El numero equivalente a la maquina, o a el usuario o un empate con -1
	 */
	public static int checkPlay(String user, String machine) {
		
		if (user.equalsIgnoreCase(PAPER) && machine.equalsIgnoreCase(STONE)) {	// Papel gana a piedra
			return USER;			
		} else if (user.equalsIgnoreCase(STONE) && machine.equalsIgnoreCase(SCISSORS)) {  // Piedra gana a tijeras
			return USER;
		} else if (user.equalsIgnoreCase(SCISSORS) && machine.equalsIgnoreCase(PAPER)) {  // Tijeras gana a papel
			return USER;
		} else if (machine.equalsIgnoreCase(PAPER) && user.equalsIgnoreCase(STONE)) {
			return MACHINE;
		} else if (machine.equalsIgnoreCase(STONE) && user.equalsIgnoreCase(SCISSORS)) {
			return MACHINE;
		} else if (machine.equalsIgnoreCase(SCISSORS) && user.equalsIgnoreCase(PAPER)) {
			return MACHINE;
		} else {
			return -1; // En caso de empate
		}
		
		
	}
	
	
}
