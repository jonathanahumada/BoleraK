/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolerak;

import java.util.Scanner;

public class BoleraK {

    /**
     * @param args the command line arguments
     */
    public static void Tablero(int i, int[][] jugador[]) {
        System.out.println("Tablero Jugador " + (i + 1) + " :");
        adorno();
        for (int[] j : jugador[i]) {

            for (int x : j) {
                if (x >= 10) {
                    System.out.print("x |");
                } else {
                    System.out.print(x + " | ");
                }
            }

        }
        System.out.println("");
    }

    public static int Sumatoria(int i, int[][] jugador[]) {
        int suma = 0;
        for (int[] j : jugador[i]) {
            for (int x : j) {
                suma += x;
            }
        }
        return suma;
    }

    public static void limpiar(int lineas) {
        for (int i = 0; i < lineas; i++) {
            System.out.println("");
        }
    }

    public static void adorno() {
        System.out.println("********************");
    }

    public static void turno(int i) {
        System.out.print("      ");
        adorno();
        System.out.println("            TURNO: " + (i + 1));
        System.out.print("      ");
        adorno();
    }

    public static void main(String[] args) {
        int[][][] jugador = new int[2][10][2];
        Scanner sc = new Scanner(System.in);

        int lanzamiento = 0;

        while (lanzamiento < 5) {
            for (int i = 0; i <= 0; i++) {
                turno(lanzamiento);
                System.out.println("Jugador:  ||" + (i + 1) + "|| es tu turno!");
                adorno();
                limpiar(1);
                System.out.println("Ingrese puntos para primer lanzamiento:");
                int turno1 = sc.nextInt();
                if (turno1 >= 10) {
                    jugador[i][lanzamiento][0] = 10;
                } else {
                    jugador[i][lanzamiento][0] = turno1;
                    System.out.println("Ingrese puntos para segundo lanzamiento:");
                    int turno2 = sc.nextInt();
                    if (turno2 >= 10) {
                        jugador[i][lanzamiento][1] = 10;
                    } else {
                        jugador[i][lanzamiento][1] = turno2;
                    }
                    
                }

                Tablero(i, jugador);
                adorno();
                //Aquí hay que rastrear el valor de la moñona
                
                System.out.println("Puntaje total: " + Sumatoria(i, jugador));
                limpiar(1);
            }
            lanzamiento++;
        }

    }

}
