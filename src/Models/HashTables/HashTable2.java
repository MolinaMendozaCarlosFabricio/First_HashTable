package Models.HashTables;

import Models.Bussiness.Bussines;
import java.util.LinkedList;

public class HashTable2 {
    public LinkedList<Bussines>[] tablaHash = new LinkedList[15000];

    public void setValueDivition(String key, Bussines value) {
        int stringToInt = passStringToInt(key);
        Integer hashIndex = hashingDivition(stringToInt);
        if (tablaHash[hashIndex] == null) {
            tablaHash[hashIndex] = new LinkedList<>();
            tablaHash[hashIndex].add(value);
        } else {
            tablaHash[hashIndex].add(value);
        }
    }

    public void setValueMultiplication(String key, Bussines value) {
        int stringToInt = passStringToInt(key);
        Integer hashIndex = hashingMultiplication(stringToInt);
        if (tablaHash[hashIndex] == null) {
            tablaHash[hashIndex] = new LinkedList<>();
            tablaHash[hashIndex].add(value);
        } else {
            tablaHash[hashIndex].add(value);
        }
    }

    public int passStringToInt (String value){
        int result = 0;
        char sumatorio;
        for(int i = 0; i < value.length(); i++){
            sumatorio = value.charAt(i);
            int ascii = sumatorio;
            result = result + ascii;
        }
        return result;
    }

    public Integer hashingDivition (Integer value){
        return value % this.tablaHash.length;
    }

    public Integer hashingMultiplication (Integer value){
        return (value * 601) % tablaHash.length;
    }

    public void recorrido(int index) {
        if (tablaHash[index] == null) {
            System.out.println("Sin datos");
        } else {
            for (Bussines business : tablaHash[index]) {
                System.out.println(business.nameBussines);
            }
        }
    }

    public void busqueda(int index, String key) {
        boolean bandera = false;
        if (tablaHash[index] != null) {
            for (Bussines business : tablaHash[index]) {
                if (business.key.equals(key)) {
                    System.out.println("Elemento encontrado:");
                    System.out.println(business.nameBussines);
                    bandera = true;
                    break;
                }
            }
        }
        if (!bandera) {
            System.out.println("No se encontró el elemento");
        }
    }

    public void shearchHashD (String parametroBusqueda){
        int stringToInt = passStringToInt(parametroBusqueda);
        Integer hashIndex = hashingDivition(stringToInt);
        if(tablaHash[hashIndex] == null){
            System.out.println("No se encontraron datos");
        }
        else
            busqueda(hashIndex, parametroBusqueda);
    }

    public void shearchHashM (String parametroBusqueda){
        int stringToInt = passStringToInt(parametroBusqueda);
        Integer hashIndex = hashingMultiplication(stringToInt);
        if(tablaHash[hashIndex] == null){
            System.out.println("No se encontraron datos");
        }
        else
            busqueda(hashIndex, parametroBusqueda);
    }

}
