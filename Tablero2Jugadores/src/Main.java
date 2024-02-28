import java.util.Random;
import java.util.Scanner;

public class Main {

    // Declaramos las variables
    static char[][] tableroJugador1 = new char[10][10];
    static char[][] tableroJugador2 = new char[10][10];
    static int filas = 10, columnas = 10;
    static int filaBartJugador1, columnaBartJugador1;
    static int filaBartJugador2, columnaBartJugador2;
    static int vidasJugador1 = 5;
    static int vidasJugador2 = 5;

    // Declaramos los caracteres del juego
    static char casillaFinal = 'F';
    static char Bart = 'B';
    static char Libre = 'L';
    static char Homer = 'H';
    static char Muros = 'M';
    static char Pocimas = 'P';

    // Añadimos el random y el scanner
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    //Añadimos la función para rellenar el tablero de L.
    public static void rellenarTableroL(char[][] tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = Libre;
            }
            tablero[9][9] = casillaFinal;
        }
    }

    //Añadimos la función para generar a Bart en ambos tableros con 2 if, creando los 2 jugadores.
    public static void insertarBart(char[][] tablero, int jugador) {
        int filaBart = random.nextInt(10);
        int columnaBart = random.nextInt(10);
        tablero[filaBart][columnaBart] = Bart;

        if (jugador == 1) {
            filaBartJugador1 = filaBart;
            columnaBartJugador1 = columnaBart;
        } else if (jugador == 2) {
            filaBartJugador2 = filaBart;
            columnaBartJugador2 = columnaBart;
        }
    }

    // Añadimos la función para añadir los 10 Homers.
    public static void rellenarTableroH(char[][] tablero) {
        for (int h = 0; h < 10; h++) {
            int filaH;
            int columnaH;
            do {
                filaH = random.nextInt(10);
                columnaH = random.nextInt(10);
            } while (tablero[filaH][columnaH] != Libre);
            tablero[filaH][columnaH] = Homer;
        }
    }

    // Añadimos la función para añadir los 10 Muros.
    public static void rellenarTableroM(char[][] tablero) {
        for (int m = 0; m < 10; m++) {
            int filaM;
            int columnaM;
            do {
                filaM = random.nextInt(10);
                columnaM = random.nextInt(10);
            } while (tablero[filaM][columnaM] != Libre);
            tablero[filaM][columnaM] = Muros;
        }
    }

    // Añadimos la función para añadir las 10 Pocimas.
    public static void rellenarTableroP(char[][] tablero) {
        for (int p = 0; p < 10; p++) {
            int filaP;
            int columnaP;
            do {
                filaP = random.nextInt(10);
                columnaP = random.nextInt(10);
            } while (tablero[filaP][columnaP] != Libre);
            tablero[filaP][columnaP] = Pocimas;
        }
    }

    // Añadimos la función para imprimir el tablero.
    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }

    //Añadimos la función para mover a Bart (B).
    public static void movimientoBart(char direccion, char[][] tablero, int jugador) {
        int filaBart;
        int columnaBart;

        if (jugador == 1) {
            filaBart = filaBartJugador1;
            columnaBart = columnaBartJugador1;
        } else {
            filaBart = filaBartJugador2;
            columnaBart = columnaBartJugador2;
        }

        // Limpia la posicion de Bart par ano dejar un rastro de 'B'.
        tablero[filaBart][columnaBart] = Libre; //

        int nuevaFila = filaBart;
        int nuevaColumna = columnaBart;

        // Creamos un switch para el movimiento.
        switch (direccion) {
            case 'W', 'w':
                nuevaFila = filaBart - 1;
                break;
            case 'A', 'a':
                nuevaColumna = columnaBart - 1;
                break;
            case 'S', 's':
                nuevaFila = filaBart + 1;
                break;
            case 'D', 'd':
                nuevaColumna = columnaBart + 1;
                break;
            case 'Q', 'q':
                nuevaFila = filaBart - 1;
                nuevaColumna = columnaBart - 1;
                break;
            case 'E', 'e':
                nuevaFila = filaBart - 1;
                nuevaColumna = columnaBart + 1;
                break;
            case 'Z', 'z':
                nuevaFila = filaBart + 1;
                nuevaColumna = columnaBart - 1;
                break;
            case 'C', 'c':
                nuevaFila = filaBart + 1;
                nuevaColumna = columnaBart + 1;
                break;
        }

        if (nuevaFila >= 0 && nuevaFila < 10 && nuevaColumna >= 0 && nuevaColumna < 10) {
            char nuevaPosicion = tablero[nuevaFila][nuevaColumna];
            if (nuevaPosicion == Libre) {
                if (jugador == 1) {
                    filaBartJugador1 = nuevaFila;
                    columnaBartJugador1 = nuevaColumna;
                } else {
                    filaBartJugador2 = nuevaFila;
                    columnaBartJugador2 = nuevaColumna;
                }
            } else if (nuevaPosicion == Muros) {
                System.out.println("Hay un muro, no puedes pasar.");
            } else if (nuevaPosicion == Homer) {
                System.out.println("Pierdes una vida.");
                if (jugador == 1) {
                    vidasJugador1--;
                    if (vidasJugador1 == 0) {
                        System.out.println("Jugador 1 ha perdido, bien jugado.");
                        System.exit(0);
                    }
                    System.out.println("Vidas restantes Jugador 1: " + vidasJugador1);
                } else {
                    vidasJugador2--;
                    if (vidasJugador2 == 0) {
                        System.out.println("Jugador 2 ha perdido, bien jugado.");
                        System.exit(0);
                    }
                    System.out.println("Vidas restantes Jugador 2: " + vidasJugador2);
                }
            } else if (nuevaPosicion == Pocimas) {
                System.out.println("Recuperas un punto de vida.");
                if (jugador == 1 && vidasJugador1 < 5) {
                    vidasJugador1++;
                    System.out.println("Vidas actuales Jugador 1:" + vidasJugador1);
                } else if (jugador == 2 && vidasJugador2 < 5) {
                    vidasJugador2++;
                    System.out.println("Vidas actuales Jugador 2:" + vidasJugador2);
                }
            } else if (nuevaPosicion == casillaFinal) {
                System.out.println("Jugador " + jugador + " ha ganado el juego.");
                System.exit(0);
            }
        } else {
            System.out.println("No hay más mapa.");
        }

        if (jugador == 1) {
            tablero[filaBartJugador1][columnaBartJugador1] = Bart;
        } else {
            tablero[filaBartJugador2][columnaBartJugador2] = Bart;
        }
    }

    public static void main(String[] args) {
        // Llamamos a las funciones para rellenar los 2 tableros
        rellenarTableroL(tableroJugador1);
        rellenarTableroL(tableroJugador2);
        insertarBart(tableroJugador1, 1);
        insertarBart(tableroJugador2, 2);
        rellenarTableroH(tableroJugador1);
        rellenarTableroH(tableroJugador2);
        rellenarTableroM(tableroJugador1);
        rellenarTableroM(tableroJugador2);
        rellenarTableroP(tableroJugador1);
        rellenarTableroP(tableroJugador2);

        // Creamos el scanner para el movimiento del usuario.
        Scanner movimientoJugador1 = new Scanner(System.in);
        Scanner movimientoJugador2 = new Scanner(System.in);

        //  Bucle principal del juego
        while (true) {

            // Imprimimos el tablero del jugador 1.
            System.out.println("Jugador 1:");
            imprimirTablero(tableroJugador1);

            // Pedimos el movimiento deseado.
            System.out.println("Ingresa un movimiento (W/A/S/D/Q/E/Z/C), L para cerrar el programa.");

            // Guardamos el movimiento en una variable.
            char direccionJugador1 = movimientoJugador1.next().charAt(0);

            // Si el jugador 1 quiere salir del programa.
            if (direccionJugador1 == 'L' || direccionJugador1 == 'l') {
                System.out.println("Gracias por jugar.");
                System.exit(0);

                // Si elige una opcion, llamamos a la funcion para mover al personaje e imprimimos el tablero con la nueva posicion.
            } else {
                movimientoBart(direccionJugador1, tableroJugador1, 1);
            }
            // Imprimimos el tablero del jugador 1.
            System.out.println("Jugador 2:");
            imprimirTablero(tableroJugador2);

            // Pedimos el movimiento deseado.
            System.out.println("Ingresa un movimiento (W/A/S/D/Q/E/Z/C), L para cerrar el programa.");

            // Guardamos el movimiento en una variable.
            char direccionJugador2 = movimientoJugador2.next().charAt(0);

            // Si el jugador 2 quiere salir del programa.
            if (direccionJugador2 == 'L' || direccionJugador2 == 'l') {
                System.out.println("Gracias por jugar.");
                System.exit(0);

                // Si elige una opcion, llamamos a la funcion para mover al personaje e imprimimos el tablero con la nueva posicion.
            } else {
                movimientoBart(direccionJugador2, tableroJugador2, 2);
            }
        }
    }
}
