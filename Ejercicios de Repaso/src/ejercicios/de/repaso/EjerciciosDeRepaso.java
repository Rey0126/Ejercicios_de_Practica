/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.de.repaso;

import java.util.Scanner;

/**
 *
 * @author brhb2
 */
public class EjerciciosDeRepaso {

    static Scanner rd = new Scanner(System.in);
    static Scanner rd1 = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean menu = true;

        while (menu) {

            System.out.print("""
                           == MENU ==
                           1. Formar palabra
                           2. Números primero
                           3. Orden alfabético
                           4. Codificar cadenas
                           5. Jugar con arreglos
                           6. Salir                           
                           Ingrese una opción:  """);

            int opcion = rd.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("== FORMAR PALABRA ==");
                    System.out.print("Ingrese una cadena: ");
                    //Aplico toLoweCase() y replace(), para que la comparacion de las cadenas sea más fácil
                    String cad1 = rd1.nextLine().toLowerCase().replace(" ", "");

                    System.out.print("Ingrese una cadena: ");
                    String cad2 = rd1.nextLine().toLowerCase().replace(" ", "");

                    while (cad1.length() == cad2.length()) { // Verifico que las cadenas sean de distinto tamaño
                        System.out.println("Las cadenas deben tener tamaños distintos");
                        System.out.print("Ingrese una cadena: ");
                        cad1 = rd1.nextLine().toLowerCase().replace(" ", "");

                        System.out.print("Ingrese una cadena: ");
                        cad2 = rd1.nextLine().toLowerCase().replace(" ", "");
                    }

                    if (cad1.length() > cad2.length()) { // Caso en que la cad1 sea la más larga

                        if (formPalabra(cad1, cad2)) {
                            System.out.println("Se pude formar " + cad2);
                        } else {
                            System.out.println("No se puede formar " + cad2);
                        }

                    } else { // Caso en que cad2 sea la más larga

                        if (formPalabra(cad1, cad2)) {
                            System.out.println("Se puede formar " + cad1);
                        } else {
                            System.out.println("No se puede formar " + cad1);
                        }

                    }

                    break;

                case 2:

                    System.out.println("== NÚMEROS PRIMERO ==");

                    System.out.print("Ingrese una cadena alfanúmerica: ");
                    String cadena = rd1.nextLine();

                    System.out.print("La nueva cadena alfanúmerica es: " + firstNumbers(cadena) + "\n");

                    break;

                case 3:

                    System.out.print("Ingrese una cadena: ");
                    String cadena2 = rd1.nextLine().toLowerCase();

                    ordenAlfabet(cadena2);

                    break;

                case 4:

                    System.out.println("== CODIFICAR CADENAS ==");

                    System.out.print("Ingrese una cadena: ");
                    String cadena3 = rd1.nextLine().toLowerCase();

                    while (validarCadena(cadena3) == false) {// Valicar cadena
                        System.out.println("La cadena solo puede contener letras, numeros y espacios");
                        System.out.print("Ingrese una cadena: ");
                        cadena3 = rd1.nextLine().toLowerCase();
                    }

                    System.out.println(codificar(cadena3));

                    break;

                case 5:

                    System.out.println("== JUGANDO CON ARREGLOS ==");
                    int[] array = llenarArray(10);
                    printArray(array);

                    break;

                case 6:

                    menu = false;

                    break;

                default:
                    System.out.println("Opncón Invalida!!!");

            }
        }

    }

    public static boolean formPalabra(String cad1, String cad2) {

        boolean sepuede = true;

        if (cad1.length() > cad2.length()) { // If que verifica que la cadena 1 sea la más larga

            for (int i = 0; i < cad2.length(); i++) { // For para recorrer la cadena más pequeña

                char x = cad2.charAt(i);
                int pos = cad1.indexOf(x); //Verifico que el caracter exista en la cadena más larga

                if (pos == -1) { // Si pos es -1 significa que el caracter no está por lo tanto quebramos el ciclo
                    sepuede = false;
                    break;
                }

                //Extraigo el caracter usado 
                cad1 = cad1.substring(0, pos) + cad1.substring(pos + 1);

            }

        } else if (cad1.length() < cad2.length()) { //If que verifica que la cadena 2 sea la más larga

            for (int i = 0; i < cad1.length(); i++) { // For para recorrer la cadena más pequeña

                char x = cad1.charAt(i);
                int pos = cad2.indexOf(x);

                if (pos == -1) {
                    sepuede = false;
                    break;
                }

                //Extraigo el caracter usado 
                cad2 = cad2.substring(0, pos) + cad1.substring(pos + 1);
            }

        }
        return sepuede;
    }

    public static String firstNumbers(String cadena) {

        String temp = "";

        for (int i = 0; i < cadena.length(); i++) {//Recorro mi cadena

            char x = cadena.charAt(i);
            int j = (int) x;

            if (j > 47 && j < 58) {
                temp += x;
            }

        }

        for (int i = 0; i < cadena.length(); i++) {//Recorro mi cadena

            char x = cadena.charAt(i);
            int j = (int) x;

            if ((j > 96 && j < 122) || (j > 65 && j < 91)) {
                temp += x;
            }

        }

        return temp;
    }

    public static void ordenAlfabet(String cadena2) {

        String temp = "";
        int contNum = 0;

        for (int i = 97; i < 123; i++) {// Recorro el Abecedario en valor ASCII

            for (int j = 0; j < cadena2.length(); j++) {

                char x = cadena2.charAt(j);
                //Caracter en ASCII
                int y = (int) x;

                //Acumulo en orden alfabetico
                if (i == y) {
                    temp += x;
                }

            }

        }

        for (int j = 0; j < cadena2.length(); j++) {

            char x = cadena2.charAt(j);
            //Caracter en ASCII
            int y = (int) x;

            if (y > 47 && y < 58) {
                contNum++;
            }

        }

        System.out.println(temp);
        System.out.println("Valor entero retornado: " + contNum);

    }

    public static String codificar(String cadena3) {

        String temp = "";

        for (int i = 0; i < cadena3.length(); i++) {

            char x = cadena3.charAt(i);
            int y = (int) x;

            if (y > 96 && y < 123) {// Es letra

                temp += (y - 96) + "-";

            }

            switch (x) {// Es numero o espacio

                case '1':
                    temp += "A";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;

                case '2':
                    temp += "B";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;

                case '3':
                    temp += "C";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;

                case '4':
                    temp += "D";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;

                case '5':
                    temp += "E";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;

                case '6':
                    temp += "F";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;

                case '7':
                    temp += "G";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;

                case '8':
                    temp += "H";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;

                case '9':
                    temp += "I";
                    if (i > 1 && i < cadena3.length() - 1) {
                        temp += "-";
                    }
                    break;
                    
                case ' ':
                    temp += " ";
                    break;

            }

        }

        return temp;
    }

    public static boolean validarCadena(String cadena3) {

        boolean valida = false;

        for (int i = 0; i < cadena3.length(); i++) {

            char x = cadena3.charAt(i);
            int y = (int) x;

            if ((y > 47 && y < 58) || (y > 96 && y < 123) || (y == 32)) {// Solo letras, numeros y espacios
                valida = true;
            } else {
                valida = false;
                break;
            }

        }

        return valida;
    }

    public static int[] llenarArray(int size) {

        int temp[] = new int[size];

        for (int i = 0; i < temp.length; i++) {

            System.out.print("Ingrese un numero en la posicion " + (i + 1) + ":");
            temp[i] = rd.nextInt();

        }
        return temp;
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {

            System.out.print("[ " + array[i] + " ]");

        }
        System.out.println();
    }

}
