package batallanaval;

public class Tablero {
    private char[][] casillas;
    private int tamano;

    public Tablero(int tamano) {
        this.tamano = tamano;
        casillas = new char[tamano][tamano];
        inicializarTablero();
    }

    // Metodo para inicializar el tablero con tildes (~) que representan agua
    public void inicializarTablero() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                casillas[i][j] = '~'; // Inicialmente todas las casillas son agua
            }
        }
    }

    // Metodo para mostrar el tablero en la consola con un formato especifico
    public void mostrarTablero() {
        System.out.print("  ");
        for (char letra = 'A'; letra < 'A' + tamano; letra++) {
            System.out.print(letra + " ");
        }
        System.out.println();

        for (int i = 0; i < tamano; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tamano; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Metodo para actualizar una casilla especifica en el tablero
    public void actualizarCasilla(int fila, int columna, char simbolo) {
        if (fila >= 0 && fila < tamano && columna >= 0 && columna < tamano) {
            casillas[fila][columna] = simbolo;
        } else {
            System.out.println("Indice fuera de rango.");
        }
    }

    // Metodo para obtener el simbolo de una casilla especifica
    public char obtenerCasilla(int fila, int columna) {
        if (fila >= 0 && fila < tamano && columna >= 0 && columna < tamano) {
            return casillas[fila][columna];
        } else {
            System.out.println("Indice fuera de rango.");
            return ' ';
        }
    }

    // Metodo para verificar si una casilla ya ha sido atacada
    public boolean esCasillaAtacada(int fila, int columna) {
        char casilla = obtenerCasilla(fila, columna);
        return casilla == 'O' || casilla == 'X';
    }

    // Metodo para obtener el tamano del tablero
    public int getTamano() {
        return tamano;
    }
}


/*
//Codigo para juego con Matriz variable

package batallanaval;

public class Tablero {
    private char[][] casillas;
    private int tamano;

    public Tablero(int tamano) {
        this.tamano = tamano;
        casillas = new char[tamano][tamano];
        inicializarTablero();
    }

    // Metodo para inicializar el tablero con tildes (~) que representan agua
    public void inicializarTablero() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                casillas[i][j] = '~'; // Inicialmente todas las casillas son agua
            }
        }
    }

    // Metodo para mostrar el tablero en la consola con un formato especifico
    public void mostrarTablero() {
        System.out.print("  ");
        for (char letra = 'A'; letra < 'A' + tamano; letra++) {
            System.out.print(letra + " ");
        }
        System.out.println();

        for (int i = 0; i < tamano; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tamano; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Metodo para actualizar una casilla especifica en el tablero
    public void actualizarCasilla(int fila, int columna, char simbolo) {
        if (fila >= 0 && fila < tamano && columna >= 0 && columna < tamano) {
            casillas[fila][columna] = simbolo;
        } else {
            System.out.println("Indice fuera de rango.");
        }
    }

    // Metodo para obtener el simbolo de una casilla especifica
    public char obtenerCasilla(int fila, int columna) {
        if (fila >= 0 && fila < tamano && columna >= 0 && columna < tamano) {
            return casillas[fila][columna];
        } else {
            System.out.println("Indice fuera de rango.");
            return ' ';
        }
    }

    // Metodo para verificar si una casilla ya ha sido atacada
    public boolean esCasillaAtacada(int fila, int columna) {
        char casilla = obtenerCasilla(fila, columna);
        return casilla == 'O' || casilla == 'X';
    }

    // Metodo para obtener el tamano del tablero
    public int getTamano() {
        return tamano;
    }
}
*/





/*
//Codigo para juego con arreglo fijo "5"

package batallanaval;

public class Tablero {
    private char[] casillas;

    public Tablero() {
        casillas = new char[5];
        inicializarTablero();
    }

    // Metodo para inicializar el tablero con tildes (~) que representan agua
    public void inicializarTablero() {
        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = '~'; // Inicialmente todas las casillas son agua
        }
    }

    // Metodo para mostrar el tablero en la consola con un formato especifico
    public void mostrarTablero() {
        System.out.println("A B C D E");
        for (char casilla : casillas) {
            System.out.print(casilla + " ");
        }
        System.out.println();
    }

    // Metodo para actualizar una casilla especifica en el tablero
    public void actualizarCasilla(int index, char simbolo) {
        if (index >= 0 && index < casillas.length) {
            casillas[index] = simbolo;
        } else {
            System.out.println("Indice fuera de rango.");
        }
    }

    // Metodo para obtener el simbolo de una casilla especifica
    public char obtenerCasilla(int index) {
        if (index >= 0 && index < casillas.length) {
            return casillas[index];
        } else {
            System.out.println("Indice fuera de rango.");
            return ' ';
        }
    }

    // Metodo para verificar si una casilla ya ha sido atacada
    public boolean esCasillaAtacada(int index) {
        char casilla = obtenerCasilla(index);
        return casilla == 'O' || casilla == 'X';
    }
}
*/