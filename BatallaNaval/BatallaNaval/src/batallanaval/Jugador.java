package batallanaval;

import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    private int[] posicionBarco; // Para almacenar la posicion del barco como una pareja de coordenadas [fila, columna]

    public Jugador(String nombre, int tamanoTablero) {
        this.nombre = nombre;
        this.tablero = new Tablero(tamanoTablero);
        this.posicionBarco = new int[2]; // Inicializar el arreglo para almacenar la posicion del barco
    }

    // Metodo para obtener el nombre del jugador
    public String obtenerNombre() {
        return nombre;
    }

    // Metodo para obtener el tablero del jugador
    public Tablero obtenerTablero() {
        return tablero;
    }

    // Metodo para colocar el barco en una casilla especifica
    public void colocarBarco(int fila, int columna) {
        posicionBarco[0] = fila; // Almacenar la fila del barco
        posicionBarco[1] = columna; // Almacenar la columna del barco
    }

    // Metodo para realizar un disparo en el tablero del oponente
    public boolean realizarDisparo(int fila, int columna, Jugador oponente) {
        if (oponente.obtenerTablero().esCasillaAtacada(fila, columna)) {
            return false; // No permitir disparos en casillas ya atacadas
        }

        if (fila == oponente.posicionBarco[0] && columna == oponente.posicionBarco[1]) { // Acierto
            oponente.obtenerTablero().actualizarCasilla(fila, columna, 'X'); // 'X' representa un acierto
            return true;
        } else { // Fallo
            oponente.obtenerTablero().actualizarCasilla(fila, columna, 'O'); // 'O' representa un fallo
            return false;
        }
    }

    // Metodo para colocar el barco en una casilla especifica (jugador humano)
    public void colocarBarcoHumano() {
        Scanner scanner = new Scanner(System.in);
        boolean barcoColocado = false;

        while (!barcoColocado) {
            System.out.println("------------------------------- COLOQUE SU BARCO -------------------------------");
            System.out.println("Ingrese la posicion para colocar su barco (ej: 1A, 2B, 3C)");
            String posicion = scanner.nextLine().trim().toUpperCase();

            if (posicion.matches("[1-" + tablero.getTamano() + "][A-" + (char) ('A' + tablero.getTamano() - 1) + "]")) {
                int fila = Character.getNumericValue(posicion.charAt(0)) - 1;
                int columna = posicion.charAt(1) - 'A';
                colocarBarco(fila, columna);
                barcoColocado = true;
            } else {
                System.out.println("Entrada invalida. Ingrese una posicion valida (ej: 1A, 2B, 3C).");
            }
        }
    }

    // Metodo para realizar un disparo (jugador humano)
    public void dispararHumano(Jugador oponente) {
        Scanner scanner = new Scanner(System.in);
        boolean disparoValido = false;

        while (!disparoValido) {
            System.out.println("Ingrese la posicion para disparar (ej: 1A, 2B, 3C): ");
            String posicion = scanner.nextLine().trim().toUpperCase();

            if (posicion.matches("[1-" + tablero.getTamano() + "][A-" + (char) ('A' + tablero.getTamano() - 1) + "]")) {
                int fila = Character.getNumericValue(posicion.charAt(0)) - 1;
                int columna = posicion.charAt(1) - 'A';
                if (oponente.obtenerTablero().esCasillaAtacada(fila, columna)) {
                    System.out.println("Ya has atacado esta posicion. Intenta de nuevo.");
                } else {
                    boolean acierto = realizarDisparo(fila, columna, oponente);
                    disparoValido = true;
                    if (acierto) {
                        System.out.println("\nAcertaste!\n");
                    } else {
                        System.out.println("\nFallaste.\n");
                    }
                }
            } else {
                System.out.println("Entrada invalida. Ingrese una posicion valida (ej: 1A, 2B, 3C).");
            }
        }
    }
}




/*
//Codigo para juego con Matriz variable

package batallanaval;

import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    private int[] posicionBarco; // Para almacenar la posicion del barco como una pareja de coordenadas [fila, columna]

    public Jugador(String nombre, int tamanoTablero) {
        this.nombre = nombre;
        this.tablero = new Tablero(tamanoTablero);
        this.posicionBarco = new int[2]; // Inicializar el arreglo para almacenar la posicion del barco
    }

    // Metodo para obtener el nombre del jugador
    public String obtenerNombre() {
        return nombre;
    }

    // Metodo para obtener el tablero del jugador
    public Tablero obtenerTablero() {
        return tablero;
    }

    // Metodo para colocar el barco en una casilla especifica
    public void colocarBarco(int fila, int columna) {
        posicionBarco[0] = fila; // Almacenar la fila del barco
        posicionBarco[1] = columna; // Almacenar la columna del barco
    }

    // Metodo para realizar un disparo en el tablero del oponente
    public boolean realizarDisparo(int fila, int columna, Jugador oponente) {
        if (oponente.obtenerTablero().esCasillaAtacada(fila, columna)) {
            return false; // No permitir disparos en casillas ya atacadas
        }

        if (fila == oponente.posicionBarco[0] && columna == oponente.posicionBarco[1]) { // Acierto
            oponente.obtenerTablero().actualizarCasilla(fila, columna, 'X'); // 'X' representa un acierto
            return true;
        } else { // Fallo
            oponente.obtenerTablero().actualizarCasilla(fila, columna, 'O'); // 'O' representa un fallo
            return false;
        }
    }

    // Metodo para colocar el barco en una casilla especifica (jugador humano)
    public void colocarBarcoHumano() {
        Scanner scanner = new Scanner(System.in);
        boolean barcoColocado = false;

        while (!barcoColocado) {
            System.out.println("------------------------------- COLOQUE SU BARCO -------------------------------");
            System.out.println("Ingrese la posicion para colocar su barco (ej: 1A, 2B, 3C)");
            String posicion = scanner.nextLine().trim().toUpperCase();

            if (posicion.matches("[1-" + tablero.getTamano() + "][A-" + (char) ('A' + tablero.getTamano() - 1) + "]")) {
                int fila = Character.getNumericValue(posicion.charAt(0)) - 1;
                int columna = posicion.charAt(1) - 'A';
                colocarBarco(fila, columna);
                barcoColocado = true;
            } else {
                System.out.println("Entrada invalida. Ingrese una posicion valida (ej: 1A, 2B, 3C).");
            }
        }
    }

    // Metodo para realizar un disparo (jugador humano)
    public void dispararHumano(Jugador oponente) {
        Scanner scanner = new Scanner(System.in);
        boolean disparoValido = false;

        while (!disparoValido) {
            System.out.println("Ingrese la posicion para disparar (ej: 1A, 2B, 3C): ");
            String posicion = scanner.nextLine().trim().toUpperCase();

            if (posicion.matches("[1-" + tablero.getTamano() + "][A-" + (char) ('A' + tablero.getTamano() - 1) + "]")) {
                int fila = Character.getNumericValue(posicion.charAt(0)) - 1;
                int columna = posicion.charAt(1) - 'A';
                if (oponente.obtenerTablero().esCasillaAtacada(fila, columna)) {
                    System.out.println("Ya has atacado esta posicion. Intenta de nuevo.");
                } else {
                    boolean acierto = realizarDisparo(fila, columna, oponente);
                    disparoValido = true;
                    if (acierto) {
                        System.out.println("\nAcertaste!\n");
                    } else {
                        System.out.println("\nFallaste.\n");
                    }
                }
            } else {
                System.out.println("Entrada invalida. Ingrese una posicion valida (ej: 1A, 2B, 3C).");
            }
        }
    }
}
*/









/*
//Codigo para juego con arreglo fijo "5"

package batallanaval;

import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    private int posicionBarco; // Para almacenar la posicion del barco

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tablero = new Tablero();
    }

    // Metodo para obtener el nombre del jugador
    public String obtenerNombre() {
        return nombre;
    }

    // Metodo para obtener el tablero del jugador
    public Tablero obtenerTablero() {
        return tablero;
    }

    // Metodo para colocar el barco en una casilla especifica
    public void colocarBarco(int index) {
        posicionBarco = index; // Almacenar la posicion del barco
    }

    // Metodo para realizar un disparo en el tablero del oponente
    public boolean realizarDisparo(int index, Jugador oponente) {
        if (oponente.obtenerTablero().esCasillaAtacada(index)) {
            return false; // No permitir disparos en casillas ya atacadas
        }

        if (index == oponente.posicionBarco) { // Acierto
            oponente.obtenerTablero().actualizarCasilla(index, 'X'); // 'X' representa un acierto
            return true;
        } else { // Fallo
            oponente.obtenerTablero().actualizarCasilla(index, 'O'); // 'O' representa un fallo
            return false;
        }
    }

    // Metodo para colocar el barco en una casilla especifica (jugador humano)
    public void colocarBarcoHumano() {
        Scanner scanner = new Scanner(System.in);
        boolean barcoColocado = false;

        while (!barcoColocado) {
            System.out.println("------------------------------- COLOQUE SU BARCO -------------------------------");
            System.out.println("Ingrese la posicion para colocar su barco (ej: A, B, C, D, E)");
            String posicion = scanner.nextLine().trim().toUpperCase();

            if (posicion.matches("[A-E]")) {
                int index = posicion.charAt(0) - 'A';
                colocarBarco(index);
                barcoColocado = true;
            } else {
                System.out.println("Entrada invalida. Ingrese una posicion valida (A-E).");
            }
        }
    }

    // Metodo para realizar un disparo (jugador humano)
    public void dispararHumano(Jugador oponente) {
        Scanner scanner = new Scanner(System.in);
        boolean disparoValido = false;

        while (!disparoValido) {
            System.out.println("Ingrese la posicion para disparar (ej: A, B, C, D, E): ");
            String posicion = scanner.nextLine().trim().toUpperCase();

            if (posicion.matches("[A-E]")) {
                int index = posicion.charAt(0) - 'A';
                if (oponente.obtenerTablero().esCasillaAtacada(index)) {
                    System.out.println("Ya has atacado esta posicion. Intenta de nuevo.");
                } else {
                    boolean acierto = realizarDisparo(index, oponente);
                    disparoValido = true;
                    if (acierto) {
                        System.out.println("\nAcertaste!\n");
                    } else {
                        System.out.println("\nFallaste.\n");
                    }
                }
            } else {
                System.out.println("Entrada invalida. Ingrese una posicion valida (A-E).");
            }
        }
    }
}
*/