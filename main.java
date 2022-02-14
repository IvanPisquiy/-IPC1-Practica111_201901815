package practica1;

import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        boolean salir = true;
        Scanner escaner = new Scanner(System.in);
        while (salir) {
//Menú principal
            System.out.println("PACMAN - IPC 1 - 2022");
            System.out.println("---------------------");
            System.out.println("1.      Iniciar juego");
            System.out.println("2.   TABLA POSICIONES");
            System.out.println("3.              SALIR");
            System.out.println("---------------------");
            System.out.println("INGRESE UNA OPCION...");
            int opcion = escaner.nextInt();
            System.out.println("Opción elegida:" + opcion);
            int[] puntaje;
            puntaje = new int[10];
//Pidiendo datos para el tablero
            switch (opcion) {
                case 1:
                    System.out.println("INGRESE SU NOMBRE:");
                    String nombre1 = escaner.nextLine();
                    String nombre = escaner.nextLine();
                    System.out.println("Ingrese el tamaño del tablero:");
                    String tamaño = escaner.nextLine();
                    String[] parts = tamaño.split(",");
                    int filas = Integer.parseInt(parts[0]);
                    int columnas = Integer.parseInt(parts[1]);
                    double comida1 = columnas * filas * 0.4;
                    int comida2 = (int) comida1;
                    boolean aceptado = true;
                    int comida = 0;
                    while (aceptado) {
                        System.out.println("Ingrese la cantidad de comida deseada" + "[0-" + comida2 + "]");
                        comida = escaner.nextInt();
                        if (comida > comida2) {
                            System.out.println("ERROR: Ingresar una cantidad que esté dentro del rango establecido.");
                        } else {
                            aceptado = false;
                        }
                    }
                    double paredes1 = columnas * filas * 0.2;
                    int paredes2 = (int) paredes1;
                    int paredes = 0;
                    aceptado = true;
                    while (aceptado) {
                        System.out.println("Ingrese la cantidad de paredes deseadas" + "[0-" + paredes2 + "]");
                        paredes = escaner.nextInt();
                        if (paredes > paredes2) {
                            System.out.println("ERROR: Ingresar una cantidad que esté dentro del rango establecido.");
                        } else {
                            aceptado = false;
                        }
                    }
                    double trampas1 = columnas * filas * 0.2;
                    int trampas2 = (int) trampas1;
                    int trampas = 0;
                    aceptado = true;
                    while (aceptado) {
                        System.out.println("Ingrese la cantidad de trampas deseadas [0-" + trampas2 + "]");
                        trampas = escaner.nextInt();
                        if (trampas > trampas2) {
                            System.out.println("ERROR: Ingresar una cantidad que esté dentro del rango establecido.");
                        } else {
                            aceptado = false;
                        }
                    }
                    int ícono = 0;
                    aceptado = true;
                    while (aceptado) {
                        System.out.println("Seleccione el ícono que desea utilizar. (C,P,T,<,D,>,Q,»,╚,«) (1,2,3,4,5,6,7,8,9,10)");
                        ícono = escaner.nextInt();
                        if (ícono > 10) {
                            System.out.println("ERROR: Ingresar una opción que esté dentro del rango establecido.");
                        } else {
                            aceptado = false;
                        }
                    }
                    char jugador = ' ';
                    if (ícono == 1) {
                        jugador = 'C';
                    }
                    if (ícono == 2) {
                        jugador = 'P';
                    }
                    if (ícono == 3) {
                        jugador = 'T';
                    }
                    if (ícono == 4) {
                        jugador = '<';
                    }
                    if (ícono == 5) {
                        jugador = 'D';
                    }
                    if (ícono == 6) {
                        jugador = '>';
                    }
                    if (ícono == 7) {
                        jugador = 'Q';
                    }
                    if (ícono == 8) {
                        jugador = '»';
                    }
                    if (ícono == 9) {
                        jugador = '╚';
                    }
                    if (ícono == 10) {
                        jugador = '«';
                    }
                    System.out.println("");
                    System.out.println("--------------------");
                    System.out.println("Jugador:" + nombre);
                    System.out.println("");
                    int filas2 = filas * 2;
                    int min = 0;
                    Random random = new Random();
                    for (int i = 0; i < filas2; i++) {
                        System.out.print("-");
                    }
//Definiendo los íconos para los distinot elementos del tablero
                    char iconoc = '@';
                    char iconop = '#';
                    char iconoT = 'X';
                    char prueba = ' ';
                    System.out.println("");
//creando tablero
                    char tablero[][] = new char[filas][columnas];
                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[0].length; j++) {
                            tablero[i][j] = prueba;
                        }
                    }

//Introduciendo las paredes en la matriz
                    for (int i = 0; i < paredes; i++) {

                        boolean ocupado = true;
                        while (ocupado) {
                            int posicion1 = random.nextInt(filas + min) + min;
                            int posicion2 = random.nextInt(columnas + min) + min;
                            if (tablero[posicion1][posicion2] == prueba) {
                                tablero[posicion1][posicion2] = iconop;
                                ocupado = false;
                            }
                        }
                    }
//Me quedé intentando verificar si la posición está vacía para poder agregar el ícono o moverlo a la siguiente posición
                    for (int i = 0; i < trampas; i++) {
                        boolean ocupado = true;
                        while (ocupado) {
                            int posicion1 = random.nextInt(filas + min) + min;
                            int posicion2 = random.nextInt(columnas + min) + min;
                            if (tablero[posicion1][posicion2] == prueba) {
                                tablero[posicion1][posicion2] = iconoT;
                                ocupado = false;
                            }
                        }
                    }
                    for (int i = 0; i < comida; i++) {
                        boolean ocupado = true;
                        while (ocupado) {
                            int posicion1 = random.nextInt(filas + min) + min;
                            int posicion2 = random.nextInt(columnas + min) + min;
                            if (tablero[posicion1][posicion2] == prueba) {
                                tablero[posicion1][posicion2] = iconoc;
                                ocupado = false;
                            }
                        }
                    }
                    imprimirMatriz(tablero, prueba, filas2);
                    boolean ocupado = true;
                    int posiciona = 0;
                    int posicionb = 0;
                    String lugar = "";
                    while (ocupado) {
                        System.out.println("Ingrese la posición inicial del jugador");
                        lugar = escaner.next();
                        String[] parte = lugar.split(",");
                        posiciona = Integer.parseInt(parte[0]);
                        posicionb = Integer.parseInt(parte[1]);
                        if (tablero[posiciona][posicionb] == prueba) {
                            tablero[posiciona][posicionb] = jugador;
                            ocupado = false;
                        } else {
                            System.out.println("Ingrese una posición que no esté ocupada");
                        }
                    }
                    int vidas = 3;
                    int punteo = 0;
                    boolean juego = true;
                    String movimiento1 = "";
                    char movimiento = ' ';
                    while (vidas > 0 && punteo != comida * 10 && juego) {
                        System.out.println("-------------------------");
                        System.out.println("Jugador:" + nombre + "\tPunteo:" + punteo + "\tVidas:" + vidas);
                        imprimirMatriz(tablero, prueba, filas2);
                        System.out.println("-------------------------");
                        movimiento1 = escaner.next();
                        movimiento = movimiento1.charAt(0);
                        if ((movimiento == 'd' || movimiento == 'D' || movimiento == '6') && (posicionb + 1) > (columnas - 1)) {
                            tablero[posiciona][posicionb] = prueba;
                            posicionb = 0;
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 'd' || movimiento == 'D' || movimiento == '6') && tablero[posiciona][posicionb + 1] == prueba && (posicionb + 1) <= (columnas - 1)) {
                            tablero[posiciona][posicionb] = prueba;
                            posicionb = posicionb + 1;
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 'd' || movimiento == 'D' || movimiento == '6') && tablero[posiciona][posicionb + 1] == iconoc && (posicionb + 1) <= (columnas - 1)) {
                            tablero[posiciona][posicionb] = prueba;
                            posicionb = posicionb + 1;
                            tablero[posiciona][posicionb] = jugador;
                            punteo = punteo + 10;
                        } else if ((movimiento == 'd' || movimiento == 'D' || movimiento == '6') && tablero[posiciona][posicionb + 1] == iconoT && (posicionb + 1) <= (columnas - 1)) {
                            tablero[posiciona][posicionb] = prueba;
                            posicionb = posicionb + 2;
                            if (tablero[posiciona][posicionb] == iconoc) {
                                punteo = punteo + 10;
                            }
                            tablero[posiciona][posicionb] = jugador;
                            vidas = vidas - 1;
                        } else if ((movimiento == 'd' || movimiento == 'D' || movimiento == '6') && tablero[posiciona][posicionb + 1] == iconop && (posicionb + 1) <= (columnas - 1)) {
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 'a' || movimiento == 'A' || movimiento == '4') && (posicionb - 1) < 0) {
                            tablero[posiciona][posicionb] = prueba;
                            posicionb = (columnas - 1);
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 'a' || movimiento == 'A' || movimiento == '4') && tablero[posiciona][posicionb - 1] == prueba && (posicionb - 1) >= 0) {
                            tablero[posiciona][posicionb] = prueba;
                            posicionb = posicionb - 1;
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 'a' || movimiento == 'A' || movimiento == '4') && tablero[posiciona][posicionb - 1] == iconoc && (posicionb - 1) >= 0) {
                            tablero[posiciona][posicionb] = prueba;
                            posicionb = posicionb - 1;
                            tablero[posiciona][posicionb] = jugador;
                            punteo = punteo + 10;
                        } else if ((movimiento == 'a' || movimiento == 'A' || movimiento == '4') && tablero[posiciona][posicionb - 1] == iconoT && (posicionb - 1) >= 0) {
                            tablero[posiciona][posicionb] = prueba;
                            posicionb = posicionb - 2;
                            if (tablero[posiciona][posicionb] == iconoc) {
                                punteo = punteo + 10;
                            }
                            tablero[posiciona][posicionb] = jugador;
                            vidas = vidas - 1;
                        } else if ((movimiento == 'a' || movimiento == 'A' || movimiento == '4') && tablero[posiciona][posicionb - 1] == iconop && (posicionb - 1) >= 0) {
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 'w' || movimiento == 'W' || movimiento == '8') && (posiciona - 1) == -1) {
                            tablero[posiciona][posicionb] = prueba;
                            posiciona = (filas - 1);
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 'w' || movimiento == 'W' || movimiento == '8') && tablero[posiciona - 1][posicionb] == prueba && (posiciona - 1) >= 0) {
                            tablero[posiciona][posicionb] = prueba;
                            posiciona = posiciona - 1;
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 'w' || movimiento == 'W' || movimiento == '8') && tablero[posiciona - 1][posicionb] == iconoc && (posiciona - 1) >= 0) {
                            tablero[posiciona][posicionb] = prueba;
                            posiciona = posiciona - 1;
                            tablero[posiciona][posicionb] = jugador;
                            punteo = punteo + 10;
                        } else if ((movimiento == 'w' || movimiento == 'W' || movimiento == '8') && tablero[posiciona - 1][posicionb] == iconoT && (posiciona - 1) >= 0) {
                            tablero[posiciona][posicionb] = prueba;
                            posiciona = posiciona - 2;
                            if (tablero[posiciona][posicionb] == iconoc) {
                                punteo = punteo + 10;
                            }
                            tablero[posiciona][posicionb] = jugador;
                            vidas = vidas - 1;
                        } else if ((movimiento == 'w' || movimiento == 'W' || movimiento == '8') && tablero[posiciona - 1][posicionb] == iconop && (posiciona - 1) >= 0) {
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 's' || movimiento == 'S' || movimiento == '5') && (posiciona + 1) > (filas - 1)) {
                            tablero[posiciona][posicionb] = prueba;
                            posiciona = 0;
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 's' || movimiento == 'S' || movimiento == '5') && tablero[posiciona + 1][posicionb] == prueba && (posiciona + 1) <= (filas - 1)) {
                            tablero[posiciona][posicionb] = prueba;
                            posiciona = posiciona + 1;
                            tablero[posiciona][posicionb] = jugador;
                        } else if ((movimiento == 's' || movimiento == 'S' || movimiento == '5') && tablero[posiciona + 1][posicionb] == iconoc && (posiciona + 1) <= (filas - 1)) {
                            tablero[posiciona][posicionb] = prueba;
                            posiciona = posiciona + 1;
                            tablero[posiciona][posicionb] = jugador;
                            punteo = punteo + 10;
                        } else if ((movimiento == 's' || movimiento == 'S' || movimiento == '5') && tablero[posiciona + 1][posicionb] == iconoT && (posiciona + 1) <= (filas - 1)) {
                            tablero[posiciona][posicionb] = prueba;
                            posiciona = posiciona + 2;
                            if (tablero[posiciona][posicionb] == iconoc) {
                                punteo = punteo + 10;
                            }
                            tablero[posiciona][posicionb] = jugador;
                            vidas = vidas - 1;
                        } else if ((movimiento == 's' || movimiento == 'S' || movimiento == '5') && tablero[posiciona + 1][posicionb] == iconop && (posiciona + 1) <= (filas - 1)) {
                            tablero[posiciona][posicionb] = jugador;
                        }
                        if (movimiento == 'e' || movimiento == 'E') {
                            juego = false;
                        }
                        if (movimiento == 'm' || movimiento == 'M') {
                            boolean pausa = true;
                            while (pausa) {
                                int opciones = escaner.nextInt();
                                System.out.println("Juego Pausado");
                                System.out.println("-----------------");
                                System.out.println("1.  CONTINUAR PARTIDA");
                                System.out.println("2.  TABLA DE POSICIONES");
                                System.out.println("3.  SALIR PARTIDA");
                                switch (opciones) {
                                    case 1:
                                        pausa = false;
                                    case 2:
                                        System.out.println("Lo siento mi aux, lo intenté :c");
                                    case 3:
                                        juego = false;
                                }
                            }
                        }
                    }
                    System.out.println("El juego ha finalizado con un puntaje de:" + punteo);
                case 2:
                    System.out.println("Lo siento, lo intente aux :c");
                case 3:
                    salir = false;

            }
        }

    }

    static void Tablaposiciones(int[] puntaje, int punteo, String nombre) {
        for (int i = 0; i < 10; i++) {

        }
    }

    static void imprimirMatriz(char tablero[][], char prueba, int filas2) {
        for (int i = 0; i < filas2; i++) {
            System.out.print("_");
        }
        System.out.println("");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("|");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
                if (j != tablero[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < filas2; i++) {
            System.out.print("_");
        }
        System.out.println("");
    }
}
