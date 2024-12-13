package batallanaval;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    private Jugador jugadorReal;
    private Jugador jugadorBot;
    private int tamanoTablero;

    public Juego(String nombreJugador, int tamanoTablero) {
        this.jugadorReal = new Jugador(nombreJugador, tamanoTablero);
        this.jugadorBot = new Jugador("Bot", tamanoTablero);
        this.tamanoTablero = tamanoTablero;
    }

    // Metodo para iniciar y configurar el juego
    public void iniciarJuego() {
        System.out.println("===============================================================================");
        System.out.println("||                   BIENVENIDO AL JUEGO DE BATALLA NAVAL                    ||");
        System.out.println("===============================================================================\n");
        mostrarInstrucciones();

        // Colocar barcos en los tableros
        jugadorReal.colocarBarcoHumano();
        colocarBarcoBot();

        // Mostrar los tableros iniciales con todas las casillas marcadas como ~
        System.out.println("\n\n-------------------------------- TABLERO INICIAL --------------------------------\n");
        System.out.println("Tu tablero:");
        jugadorReal.obtenerTablero().mostrarTablero();
        System.out.println("Tablero del bot:");
        jugadorBot.obtenerTablero().mostrarTablero();
    }

    // Metodo para mostrar las instrucciones del juego
    private void mostrarInstrucciones() {
        System.out.println("--------------------------- INSTRUCCIONES DEL JUEGO ---------------------------\n");
        System.out.println("1. Coloca tu barco en una de las casillas (ej: 1A, 2B, 3C).");
        System.out.println("2. Dispara a una casilla del tablero del oponente para intentar hundir su barco.");
        System.out.println("3. El primer jugador que hunda el barco del oponente gana.");
        System.out.println("4. Los simbolos del tablero son:");
        System.out.println("   ~ : Agua");
        System.out.println("   O : Fallo");
        System.out.println("   X : Acierto");
        System.out.println("5. Buena suerte!\n");
    }

    // Metodo para gestionar el turno de un jugador
    private void turnoJugador(Jugador jugador, Jugador oponente) {
        if (jugador == jugadorReal) {
            jugador.dispararHumano(oponente);
            mostrarTableros();
            if (verificarVictoria(oponente)) {
                System.out.println("\n\nFelicidades! Has ganado el juego.");
                System.exit(0);
            }
        } else {
            dispararBot();
            mostrarTableros();
            if (verificarVictoria(jugadorReal)) {
                System.out.println("\n\nEl bot ha ganado el juego. Mejor suerte la proxima vez.");
                System.exit(0);
            }
        }
    }

    // Metodo para el bot para disparar de forma aleatoria
    private void dispararBot() {
        Random random = new Random();
        boolean disparoValido = false;

        while (!disparoValido) {
            int fila = random.nextInt(tamanoTablero);
            int columna = random.nextInt(tamanoTablero);
            char casilla = jugadorReal.obtenerTablero().obtenerCasilla(fila, columna);

            if (casilla != 'X' && casilla != 'O') {
                boolean acierto = jugadorBot.realizarDisparo(fila, columna, jugadorReal);
                disparoValido = true;
                char letra = (char) ('A' + columna);
                System.out.println("El bot ataco la posicion " + (fila + 1) + letra);
                if (acierto) {
                    System.out.println("\nEl bot ha acertado.\n");
                } else {
                    System.out.println("\nEl bot ha fallado.\n");
                }
            }
        }
    }

    // Metodo para colocar el barco del bot en una posicion aleatoria
    private void colocarBarcoBot() {
        Random random = new Random();
        int fila = random.nextInt(tamanoTablero);
        int columna = random.nextInt(tamanoTablero);
        jugadorBot.colocarBarco(fila, columna);
    }

    // Metodo para verificar si un jugador ha ganado
    private boolean verificarVictoria(Jugador jugador) {
        Tablero tablero = jugador.obtenerTablero();
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                if (tablero.obtenerCasilla(i, j) == 'X') {
                    return true; // El jugador ha hundido un barco
                }
            }
        }
        return false; // Aun no ha hundido el barco
    }

    // Metodo para ejecutar el ciclo del juego
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Turno del jugador real
            System.out.println("\n\n==================================== TU TURNO ====================================");
            turnoJugador(jugadorReal, jugadorBot);

            // Pedir al usuario que presione Enter para continuar
            System.out.println("\nPresiona Enter para continuar con el turno del bot...");
            scanner.nextLine();

            // Turno del bot
            System.out.println("\n\n---------------------------------- TURNO DEL BOT ----------------------------------");
            turnoJugador(jugadorBot, jugadorReal);
        }
    }

    // Metodo para mostrar los tableros de ambos jugadores
    private void mostrarTableros() {
        System.out.println("Tu tablero:");
        jugadorReal.obtenerTablero().mostrarTablero();
        System.out.println("Tablero del bot:");
        jugadorBot.obtenerTablero().mostrarTablero();
    }
}


/*
//Codigo para juego con Matriz variable

package batallanaval;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    private Jugador jugadorReal;
    private Jugador jugadorBot;
    private int tamanoTablero;

    public Juego(String nombreJugador, int tamanoTablero) {
        this.jugadorReal = new Jugador(nombreJugador, tamanoTablero);
        this.jugadorBot = new Jugador("Bot", tamanoTablero);
        this.tamanoTablero = tamanoTablero;
    }

    // Metodo para iniciar y configurar el juego
    public void iniciarJuego() {
        System.out.println("===============================================================================");
        System.out.println("||                   BIENVENIDO AL JUEGO DE BATALLA NAVAL                    ||");
        System.out.println("===============================================================================\n");
        mostrarInstrucciones();

        // Colocar barcos en los tableros
        jugadorReal.colocarBarcoHumano();
        colocarBarcoBot();

        // Mostrar los tableros iniciales con todas las casillas marcadas como ~
        System.out.println("\n\n-------------------------------- TABLERO INICIAL --------------------------------\n");
        System.out.println("Tu tablero:");
        jugadorReal.obtenerTablero().mostrarTablero();
        System.out.println("Tablero del bot:");
        jugadorBot.obtenerTablero().mostrarTablero();
    }

    // Metodo para mostrar las instrucciones del juego
    private void mostrarInstrucciones() {
        System.out.println("--------------------------- INSTRUCCIONES DEL JUEGO ---------------------------\n");
        System.out.println("1. Coloca tu barco en una de las casillas (ej: 1A, 2B, 3C).");
        System.out.println("2. Dispara a una casilla del tablero del oponente para intentar hundir su barco.");
        System.out.println("3. El primer jugador que hunda el barco del oponente gana.");
        System.out.println("4. Los simbolos del tablero son:");
        System.out.println("   ~ : Agua");
        System.out.println("   O : Fallo");
        System.out.println("   X : Acierto");
        System.out.println("5. Buena suerte!\n");
    }

    // Metodo para gestionar el turno de un jugador
    private void turnoJugador(Jugador jugador, Jugador oponente) {
        if (jugador == jugadorReal) {
            jugador.dispararHumano(oponente);
            mostrarTableros();
            if (verificarVictoria(oponente)) {
                System.out.println("\n\nFelicidades! Has ganado el juego.");
                System.exit(0);
            }
        } else {
            dispararBot();
            mostrarTableros();
            if (verificarVictoria(jugadorReal)) {
                System.out.println("\n\nEl bot ha ganado el juego. Mejor suerte la proxima vez.");
                System.exit(0);
            }
        }
    }

    // Metodo para el bot para disparar de forma aleatoria
    private void dispararBot() {
        Random random = new Random();
        boolean disparoValido = false;

        while (!disparoValido) {
            int fila = random.nextInt(tamanoTablero);
            int columna = random.nextInt(tamanoTablero);
            char casilla = jugadorReal.obtenerTablero().obtenerCasilla(fila, columna);

            if (casilla != 'X' && casilla != 'O') {
                boolean acierto = jugadorBot.realizarDisparo(fila, columna, jugadorReal);
                disparoValido = true;
                char letra = (char) ('A' + columna);
                System.out.println("El bot ataco la posicion " + (fila + 1) + letra);
                if (acierto) {
                    System.out.println("\nEl bot ha acertado.\n");
                } else {
                    System.out.println("\nEl bot ha fallado.\n");
                }
            }
        }
    }

    // Metodo para colocar el barco del bot en una posicion aleatoria
    private void colocarBarcoBot() {
        Random random = new Random();
        int fila = random.nextInt(tamanoTablero);
        int columna = random.nextInt(tamanoTablero);
        jugadorBot.colocarBarco(fila, columna);
    }

    // Metodo para verificar si un jugador ha ganado
    private boolean verificarVictoria(Jugador jugador) {
        Tablero tablero = jugador.obtenerTablero();
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                if (tablero.obtenerCasilla(i, j) == 'X') {
                    return true; // El jugador ha hundido un barco
                }
            }
        }
        return false; // Aun no ha hundido el barco
    }

    // Metodo para ejecutar el ciclo del juego
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Turno del jugador real
            System.out.println("\n\n==================================== TU TURNO ====================================");
            turnoJugador(jugadorReal, jugadorBot);

            // Pedir al usuario que presione Enter para continuar
            System.out.println("\nPresiona Enter para continuar con el turno del bot...");
            scanner.nextLine();

            // Turno del bot
            System.out.println("\n\n---------------------------------- TURNO DEL BOT ----------------------------------");
            turnoJugador(jugadorBot, jugadorReal);
        }
    }

    // Metodo para mostrar los tableros de ambos jugadores
    private void mostrarTableros() {
        System.out.println("Tu tablero:");
        jugadorReal.obtenerTablero().mostrarTablero();
        System.out.println("Tablero del bot:");
        jugadorBot.obtenerTablero().mostrarTablero();
    }
}
*/










/*
//Codigo para juego con arreglo fijo "5"

package batallanaval;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    private Jugador jugadorReal;
    private Jugador jugadorBot;

    public Juego(String nombreJugador) {
        this.jugadorReal = new Jugador(nombreJugador);
        this.jugadorBot = new Jugador("Bot");
    }

    // Metodo para iniciar y configurar el juego
    public void iniciarJuego() {
        System.out.println("===============================================================================");
        System.out.println("||                   BIENVENIDO AL JUEGO DE BATALLA NAVAL                    ||");
        System.out.println("===============================================================================\n");
        mostrarInstrucciones();

        // Colocar barcos en los tableros
        jugadorReal.colocarBarcoHumano();
        colocarBarcoBot();

        // Mostrar los tableros iniciales con todas las casillas marcadas como ~
        System.out.println("\n\n-------------------------------- TABLERO INICIAL --------------------------------\n");
        System.out.println("Tu tablero:");
        jugadorReal.obtenerTablero().mostrarTablero();
        System.out.println("Tablero del bot:");
        jugadorBot.obtenerTablero().mostrarTablero();
    }

    // Metodo para mostrar las instrucciones del juego
    private void mostrarInstrucciones() {
        System.out.println("--------------------------- INSTRUCCIONES DEL JUEGO ---------------------------\n");
        System.out.println("1. Coloca tu barco en una de las casillas (A, B, C, D, E).");
        System.out.println("2. Dispara a una casilla del tablero del oponente para intentar hundir su barco.");
        System.out.println("3. El primer jugador que hunda el barco del oponente gana.");
        System.out.println("4. Los simbolos del tablero son:");
        System.out.println("   ~ : Agua");
        System.out.println("   O : Fallo");
        System.out.println("   X : Acierto");
        System.out.println("5. Buena suerte!\n");
    }

    // Metodo para gestionar el turno de un jugador
    private void turnoJugador(Jugador jugador, Jugador oponente) {
        if (jugador == jugadorReal) {
            jugador.dispararHumano(oponente);
            mostrarTableros();
            if (verificarVictoria(oponente)) {
                System.out.println("\n\nFelicidades! Has ganado el juego.");
                System.exit(0);
            }
        } else {
            dispararBot();
            mostrarTableros();
            if (verificarVictoria(jugadorReal)) {
                System.out.println("\n\nEl bot ha ganado el juego. Mejor suerte la proxima vez.");
                System.exit(0);
            }
        }
    }

    // Metodo para el bot para disparar de forma aleatoria
    private void dispararBot() {
        Random random = new Random();
        boolean disparoValido = false;

        while (!disparoValido) {
            int index = random.nextInt(5);
            char casilla = jugadorReal.obtenerTablero().obtenerCasilla(index);

            if (casilla != 'X' && casilla != 'O') {
                boolean acierto = jugadorBot.realizarDisparo(index, jugadorReal);
                disparoValido = true;
                char letra = (char) ('A' + index);
                System.out.println("El bot ataco la posicion " + letra);
                if (acierto) {
                    System.out.println("\nEl bot ha acertado.\n");
                } else {
                    System.out.println("\nEl bot ha fallado.\n");
                }
            }
        }
    }

    // Metodo para colocar el barco del bot en una posicion aleatoria
    private void colocarBarcoBot() {
        Random random = new Random();
        int index = random.nextInt(5);
        jugadorBot.colocarBarco(index);
    }

    // Metodo para verificar si un jugador ha ganado
    private boolean verificarVictoria(Jugador jugador) {
        Tablero tablero = jugador.obtenerTablero();
        for (int i = 0; i < 5; i++) {
            if (tablero.obtenerCasilla(i) == 'X') {
                return true; // El jugador ha hundido un barco
            }
        }
        return false; // Aun no ha hundido el barco
    }

    // Metodo para ejecutar el ciclo del juego
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Turno del jugador real
            System.out.println("\n\n==================================== TU TURNO ====================================");
            turnoJugador(jugadorReal, jugadorBot);

            // Pedir al usuario que presione Enter para continuar
            System.out.println("\nPresiona Enter para continuar con el turno del bot...");
            scanner.nextLine();

            // Turno del bot
            System.out.println("\n\n---------------------------------- TURNO DEL BOT ----------------------------------");
            turnoJugador(jugadorBot, jugadorReal);

            // Mostrar los tableros actualizados despues de cada turno
            //System.out.println("\n\n");
        }
    }

    // Metodo para mostrar los tableros de ambos jugadores
    private void mostrarTableros() {
        System.out.println("Tu tablero:");
        jugadorReal.obtenerTablero().mostrarTablero();
        System.out.println("Tablero del bot:");
        jugadorBot.obtenerTablero().mostrarTablero();
    }
}
*/

