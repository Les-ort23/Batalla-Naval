package batallanaval;

import java.util.Scanner;

public class BatallaNaval {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamano del tablero (ej: 4 para 4x4, 5 para 5x5): ");
        int tamanoTablero = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva linea

        // Crear una instancia del juego y pasar el nombre del jugador real y el tamano del tablero
        Juego juego = new Juego("JugadorReal", tamanoTablero);

        // Iniciar el juego y configurar los tableros
        juego.iniciarJuego();

        // Ejecutar el ciclo del juego hasta que haya un ganador
        juego.jugar();
    }
}


/*
//Codigo para juego con Matriz variable

package batallanaval;

import java.util.Scanner;

public class BatallaNaval {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamano del tablero (ej: 4 para 4x4, 5 para 5x5): ");
        int tamanoTablero = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva linea

        // Crear una instancia del juego y pasar el nombre del jugador real y el tamano del tablero
        Juego juego = new Juego("JugadorReal", tamanoTablero);

        // Iniciar el juego y configurar los tableros
        juego.iniciarJuego();

        // Ejecutar el ciclo del juego hasta que haya un ganador
        juego.jugar();
    }
}
*/








/*
//Codigo para juego con arreglo fijo "5"

package batallanaval;

public class BatallaNaval {

    public static void main(String[] args) {
        // Crear una instancia del juego y pasar el nombre del jugador real
        Juego juego = new Juego("JugadorReal");

        // Iniciar el juego y configurar los tableros
        juego.iniciarJuego();

        // Ejecutar el ciclo del juego hasta que haya un ganador
        juego.jugar();
    }
}
*/