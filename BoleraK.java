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
    public static void casosEspeciales(int i, int[][] jugador[], int[] frame10[], int spare) {
        for (int t = 0; t < 10; t++) {
            for (int l = 0; l < 2; l++) {
                //casos especiales
                //frame10
                if (jugador[i][8][0] == 20) {
                    jugador[i][8][0] += frame10[i][0];
                }
                if (jugador[i][9][0] == 10 && frame10[i][0] == 10) {
                    jugador[i][9][0] = 30;

                } else if (jugador[i][9][0] + jugador[i][9][1] == 10) {
                    jugador[i][9][1] += frame10[i][0];
                }
                //strike
                if ((jugador[i][t][l] == 10) && (l == 0 && t + 1 < 10)) {
                    jugador[i][t][l] += jugador[i][t + 1][0];
                } else if (jugador[i][t][l] == 20 && (t + 2 <= 10)) {
                    jugador[i][t][l] += jugador[i][t + 2][0];
                }
                //spare
                if (jugador[i][t][0] + jugador[i][t][1] == 10 && (t + 1 < 10)) {
                    spare = jugador[i][t + 1][0];
                    jugador[i][t][1] += spare;
                }

            }
        }
    }

    public static void imagen() {
        adorno();
        System.out.println("Bowling Konrad 1.0");      
        adorno();

        System.out.println("                      `-`  ");
        System.out.println("               .`     ++:.`    `` ");
        System.out.println("   `    -.    :/-` `  +o/-``  `/:``   .`");
        System.out.println("  ./.` `o:.`` :+:.``  :o/:..  :+/-`` ./-`` -.");
        System.out.println("  .o:.` +/-.` .s+:-.  `yys+/  ++o/:- `+:.. ::.` ");
        System.out.println("  so+. +s+/   so/::   o+:.`  /oo/:-  +o/: .o/:  ");
        System.out.println("  o+:` /o/-   so:-.   ys+:-  :os+:.  /o:. `o:.");
        System.out.println("  .+:.``//.`  -+:.``  -/-`    :/:.`  `:-`` .:.`");
        System.out.println(" .//:..//:-``-/:-.   ./:.`   .::.`   --``  -.`  ");
        System.out.println(".+//::+/:::.-+/:--``.+:-.``  `:-.`   `.``  ````   ");
        System.out.println("/+///++/:::/+//::-..+/:-..``  `-.```  ````` ``` ``");
        System.out.println(";/+///o+/://++//::::/+/:--.```  ...``` `.`````.````");
        System.out.println(".o+/+++////++///:::++/:--..``` ....````...``.....`");
        System.out.println(" /o+++o+///+o////::++/:--...```.....``......:-... ");
        System.out.println(" `+so+/o++++++////:/+/:--...```-....`.:-..../::- ");
        System.out.println("   ``  /oo+/`oo+///:+/:---..``-:-....`//::. ");
        System.out.println("             .ssoo/.-+:---....`+/::-.  ");
        System.out.println("              `...`  //:-....`  ...`  ");
        System.out.println("                    `++/::-.   ");
        System.out.println("                       `..`   ") ;                   

    }

    public static void Tablero(int i, int[][] jugador[], int[] frame10[]) {
        System.out.println("Tablero Jugador " + (i + 1) + " :");
        adorno();
        System.out.println("-----------------------------------------------------------------------------------");
        for (int t = 0; t < 10; t++) {
            System.out.print("Turno:" + (t + 1) + "|");

        }
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print(" ");
        for (int t = 0; t < 10; t++) {

            for (int l = 0; l < 2; l++) {
                if (jugador[i][t][l] >= 10 && l == 0) {
                    System.out.print("x | ");
                } else if ((l != 0 && jugador[i][t][l - 1] < 10) && (jugador[i][t][l - 1] + jugador[i][t][l] >= 10)) {
                    System.out.print("/ | ");
                } else {
                    System.out.print(jugador[i][t][l] + " | ");
                }
            }
        }
        if (frame10[i][0] > 0) {

            System.out.println(" ::: " + frame10[i][0] + " ::: ");
        }
        System.out.println("");

    }

    public static int Sumatoria(int i, int[][] jugador[]) {
        int suma = 0;
        for (int[] j : jugador[i]) {
            for (int x : j) {
                suma += x;
                if (x == 10) {
                }
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
        int[][] frame10 = new int[2][1];
        int spare = 00;
        imagen();    
        
        int lanzamiento = 0;

        while (lanzamiento < 10) {
            for (int i = 0; i < 1; i++) {
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
                    if (turno1 + turno2 >= 10) {
                        jugador[i][lanzamiento][1] = 10 - turno1;
                    } else {
                        jugador[i][lanzamiento][1] = turno2;
                    }

                }

                
                //Para prueba Tablero(i, jugador, frame10);
                casosEspeciales(i, jugador, frame10, spare);
                System.out.println("Puntaje total: " + Sumatoria(i, jugador));

                adorno();
                if (jugador[i][9][0] + jugador[i][9][1] >= 10) {
                    System.out.println("Tienes una bola adicional!");
                    System.out.println("Ingrese puntos para bola adicional");
                    int bolaAdicional = sc.nextInt();
                    frame10[i][0] = bolaAdicional;

                    casosEspeciales(i, jugador, frame10, spare);
                }

                Tablero(i, jugador, frame10);
                System.out.println("Puntaje total: " + Sumatoria(i, jugador));
                limpiar(1);
            }
            lanzamiento++;
        }

    }

}
