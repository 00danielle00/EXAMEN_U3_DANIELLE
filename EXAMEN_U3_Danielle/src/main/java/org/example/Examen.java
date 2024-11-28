package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen {

    public void Ejercicio1 (){

        //a) bolas del sorteo
        Random aleatorio = new Random();
        Scanner teclado = new Scanner(System.in);

        int bolas = aleatorio.nextInt(40)+10; // realizo un aleatorio de numero de bolas ente 10 y 40

        int vector_bolas [] = new int[bolas]; //las introduzco en un vector

        for (int i = 0; i < vector_bolas.length; i++) {
            vector_bolas[i]=aleatorio.nextInt(90)+1;//dentro del vector realizo los números aleatorios entre 1-90
        }

        System.out.println("*******Bienvenido al bingo del casino cantabrico*******");
        System.out.println(bolas+" bolas extraidas hasta ahora: "+ Arrays.toString(vector_bolas));

        //b)Buscar repetidos y recalcular

        Arrays.sort(vector_bolas);//ordeno array
        boolean aux=true;
        while (aux){//bucle para que no se repitan las bolas
            aux=false;
            for (int i = 0; i < vector_bolas.length; i++) {
                if (i!=vector_bolas.length - 1 && vector_bolas[i]==vector_bolas[i+1]){
                    vector_bolas[i]=aleatorio.nextInt(49)+1;
                    aux=true;
                }
                Arrays.sort(vector_bolas);
            }
        }

        //c) Introducir datos del carton
        String formato = "\\d{1,2}-\\d{1,2}-\\d{1,2}";

        System.out.println("***** Introduce  los datos de tu cartón ******");
        int matriz [][]=new int[3][3];

        for (int i = 0; i < matriz.length; i++) {
                System.out.println("Fila "+(i+1)+":");
                String fila []= teclado.nextLine().split("-");
            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j]=Integer.parseInt(fila[j]);
            }
        }


        //d)
        System.out.println("Datos del cartón introducido:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.print("\n");
        }

        //c) busco si los numeros almacenados de la matriz coinciden con los de los vectores

        System.out.println("PREMIOS:");

        boolean numeros = Arrays.asList(vector_bolas).contains(matriz);

        if (!numeros){
            System.out.println("No hay bingo");
            return;
        }   else {
            System.out.println("Hay bingo");
            return;
        }





    }
}
