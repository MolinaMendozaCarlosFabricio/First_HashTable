import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import Models.HashTables.HashTable;
import Models.ListaEnlazada.ListaEnlazada;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String[] args){
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
                String[] bussines = line.split(splitBy);    // use comma as separator
                hashTableD.setValueDivition(bussines[0], bussines[1]);
                hashTableM.setValueMultiplication(bussines[0], bussines[1]);   
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        int opcion;
        System.out.println("Hashing por division: 1");
        System.out.println("Hashing por multiplicacion: 2");
        opcion = entrada.nextInt();
        if(opcion == 1){
            System.out.println("Hashing por division");
            optionsHashD(hashTableD);
        }
        if(opcion == 2){
            System.out.println("Hashing por multiplicacion");
            optionHashM(hashTableM);
        }   
    }
    public static void optionsHashD(HashTable tablaHash){
        Scanner entrada = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        System.out.println("1. Imprimir toda la tabla   2. Buscar valor");
        int option = entrada.nextInt();
        if(option == 1){
            for(int i = 0; i < tablaHash.tablaHash.length; i++){
                System.out.println("Index: " + i);
                tablaHash.recorrido(i);
            }
        }
        if(option == 2){
            System.out.println("Ingrese clave");
            String search = scanner.nextLine();
            tablaHash.shearchHashD(search);
        }
    }
    public static void optionHashM(HashTable tabla){
        Scanner entrada = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        System.out.println("1. Imprimir toda la tabla   2. Buscar valor");
        int option = entrada.nextInt();
        if(option == 1){
            for(int i = 0; i < tabla.tablaHash.length; i++){
                System.out.println("Index: " + i);
                tabla.recorrido(i);
            }
        }
        if(option == 2){
            System.out.println("Ingrese clave");
            String search = scanner.nextLine();
            tabla.shearchHashM(search);
        }
    }
}