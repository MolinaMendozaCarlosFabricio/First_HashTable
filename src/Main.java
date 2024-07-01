import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import Models.Bussiness.Bussines;
import Models.HashTables.HashTable;
import Models.HashTables.HashTable2;
import Models.ListaEnlazada.ListaEnlazada;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        int options;
        do{
            System.out.println("Ingrese el tipo de lista enlazada");
            System.out.println("1. Mi lista enlazada    2. Lista enlazada de Java   3. Salir");
            options = entrada.nextInt();
            if(options == 1)
                myLinkedList();
            if(options == 2)
                javasLinkedList();
        }while(options == 1 || options == 2);
    }
    public static void optionsHashD(HashTable tablaHash){
        Scanner entrada = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        System.out.println("1. Imprimir toda la tabla   2. Buscar valor");
        int option = entrada.nextInt();
        if(option == 1){
            long inicio = System.currentTimeMillis();
            for(int i = 0; i < tablaHash.tablaHash.length; i++){
                System.out.println("Index: " + i);
                tablaHash.recorrido(i);
            }
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
        if(option == 2){
            System.out.println("Ingrese clave");
            String search = scanner.nextLine();
            long inicio = System.currentTimeMillis();
            tablaHash.shearchHashD(search);
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
    }
    public static void optionHashM(HashTable tabla){
        Scanner entrada = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        System.out.println("1. Imprimir toda la tabla   2. Buscar valor");
        int option = entrada.nextInt();
        if(option == 1){
            long inicio = System.currentTimeMillis();
            for(int i = 0; i < tabla.tablaHash.length; i++){
                System.out.println("Index: " + i);
                tabla.recorrido(i);
            }
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
        if(option == 2){
            System.out.println("Ingrese clave");
            String search = scanner.nextLine();
            long inicio = System.currentTimeMillis();
            tabla.shearchHashM(search);
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
    }

    public static void myLinkedList (){
        Scanner entrada = new Scanner (System.in);
        HashTable hashTableD = new HashTable();
        HashTable hashTableM = new HashTable();
        String line = "";
        String splitBy = ",";

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] bussines = line.split(splitBy);// use comma as separator
                Bussines objBuss = new Bussines(bussines[0], bussines[1]);
                hashTableD.setValueDivition(bussines[0], objBuss);
                hashTableM.setValueMultiplication(bussines[0], objBuss);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        int opcion;
        do{
            System.out.println("Hashing por division: 1");
            System.out.println("Hashing por multiplicacion: 2");
            System.out.println("Salr: 3");
            opcion = entrada.nextInt();
            if(opcion == 1){
                System.out.println("Hashing por division");
                optionsHashD(hashTableD);
            }
            if(opcion == 2){
                System.out.println("Hashing por multiplicacion");
                optionHashM(hashTableM);

            }
        }while (opcion == 1 || opcion == 2);
    }

    public static void javasLinkedList (){
        Scanner entrada = new Scanner (System.in);
        HashTable2 hashTableD = new HashTable2();
        HashTable2 hashTableM = new HashTable2();
        String line = "";
        String splitBy = ",";

        long inicio = System.currentTimeMillis();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] bussines = line.split(splitBy);// use comma as separator
                Bussines objBuss = new Bussines(bussines[0], bussines[1]);
                hashTableD.setValueDivition(bussines[0], objBuss);

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000; // Convertir a segundos
        System.out.println("Tiempo de lectura de la tabla hash en java, por hashing de división: " + tiempo + " segundos");

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] bussines = line.split(splitBy);// use comma as separator
                Bussines objBuss = new Bussines(bussines[0], bussines[1]);

                hashTableM.setValueMultiplication(bussines[0], objBuss);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        int opcion;
        do{
            System.out.println("Hashing por division: 1");
            System.out.println("Hashing por multiplicacion: 2");
            System.out.println("Salir: 3");
            opcion = entrada.nextInt();
            if(opcion == 1){
                System.out.println("Hashing por division");
                optionsHashD2(hashTableD);
            }
            if(opcion == 2){
                System.out.println("Hashing por multiplicacion");
                optionHashM2(hashTableM);
            }
        }while (opcion == 1 || opcion == 2);

    }

    public static void optionsHashD2(HashTable2 tablaHash){
        Scanner entrada = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        System.out.println("1. Imprimir toda la tabla   2. Buscar valor");
        int option = entrada.nextInt();
        if(option == 1){
            long inicio = System.currentTimeMillis();
            for(int i = 0; i < tablaHash.tablaHash.length; i++){
                System.out.println("Index: " + i);
                tablaHash.recorrido(i);
            }
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
        if(option == 2){
            System.out.println("Ingrese clave");
            String search = scanner.nextLine();
            long inicio = System.currentTimeMillis();
            tablaHash.shearchHashD(search);
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
    }

    public static void optionHashM2(HashTable2 tabla){
        Scanner entrada = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        System.out.println("1. Imprimir toda la tabla   2. Buscar valor");
        int option = entrada.nextInt();
        if(option == 1){
            long inicio = System.currentTimeMillis();
            for(int i = 0; i < tabla.tablaHash.length; i++){
                System.out.println("Index: " + i);
                tabla.recorrido(i);
            }
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
        if(option == 2){
            System.out.println("Ingrese clave");
            String search = scanner.nextLine();
            long inicio = System.nanoTime();
            tabla.shearchHashM(search);
            long fin = System.nanoTime();
            double tiempo = (double) (fin - inicio) / 1000000000f;
            System.out.println(tiempo + "seg");
        }
    }

}