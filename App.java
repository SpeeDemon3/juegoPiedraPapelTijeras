import java.util.Scanner;

/**
 * @author Antonio Ruiz Benito -> SpeedDemoN
 */
public class App {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		// Muestro las instrucciones
		Function.instructions();
		
		// Contadores de partida
		int countPlayer = 0; 
		int countMachine = 0;
		int roundsCounter = 0;
		
		
		// Variables para controlar el bucle
		boolean control = true;

		// Mientras control sea true el bucle seguira iterando
		while (control) {
			// Muestro el menu
			Function.menu();
			// Guardo el valor introducido y elimino cualquier posible espacio a la derecha o izquierda
			String user = sc.nextLine().trim();
			
			boolean charCorrect = Function.checkCharacter(user);
		
			// Compruebo si el usuario desea finalizar el programa
			if (user.equalsIgnoreCase("s")) {
				
				System.out.println("Gracias por jugar al juego.");
				// Cambio la variable para terminar la partida
				control = false;
			}	
			
			// Si la letra es correcta
			if (charCorrect == true) {
				

				// Sumamos 1 para ir contando las rondas jugadas
				roundsCounter++;
						
				System.out.println("Ronda numero: " + roundsCounter);
						
				String machine = Function.generateRandomPlay();
						
				System.out.println("Maquina: " + machine);
						
				// Compruebo quien a ganado la ronda
				int result = Function.checkPlay(user, machine);
				
				/* si retorna 1 gana el usuario, si retorna 0 gana la maquina, si retorna -1 sera un empate*/
				if (result == 0) {
					// Sumamos uno al contador
					countMachine++;
					
					System.out.println("Roda ganada por la máquina.\n");
					
				} else if (result == 1) {
					// Sumamos uno al contador
					countPlayer ++;
					
					System.out.println("Roda ganada por el usuario.\n");
					
				} else {
					System.out.println("Empate!!!!\n");
				}

				/* El primero que llegue a 5 victorias gana*/
				if (countMachine == 3) {
					
					System.out.println("El ganador a sido la máquina!!!");
					// Cambio la variable para terminar la app
					control = false;
									
					
				} else if (countPlayer == 3) {
					
					System.out.println("El ganador a sido: Usuario!!!");
					// Cambio la variable para terminar la app
					control = false;
				}
									
			} else {
				// Continuamos a la siguiente iteracion
				continue;
			}
				
		}

			
	}
		
}

