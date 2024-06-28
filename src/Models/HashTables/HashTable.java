package Models.HashTables;

import Models.ListaEnlazada.ListaEnlazada;

public class HashTable {
    public ListaEnlazada tablaHash [] = new ListaEnlazada[15000];

    /*
    public void setSizeHashTable (int size){
        if (size < 0)
            System.out.println("Error, ingrese un valor positivo");
        else
            this.tablaHashSize = size;
    }
    */

    public void setValueDivition (String key, String value){
        int stringToInt = passStringToInt(key);
        Integer hashIndex = hashingDivition(stringToInt);
        if(tablaHash[hashIndex] == null) {
            tablaHash[hashIndex] = new ListaEnlazada();
            tablaHash[hashIndex].addNode(value);
        }
        else
            tablaHash[hashIndex].addNode(value);
    }

    public void setValueMultiplication (String key, String value){
        int stringToInt = passStringToInt(key);
        Integer hashIndex = hashingMultiplication(stringToInt);
        if(tablaHash[hashIndex] == null) {
            tablaHash[hashIndex] = new ListaEnlazada();
            tablaHash[hashIndex].addNode(value);
        }
        else
            tablaHash[hashIndex].addNode(value);
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
        int hash = value % this.tablaHash.length;
        //System.out.println(hash);
        return hash;
    }

    public Integer hashingMultiplication (Integer value){
        int hash = (value * 666) % tablaHash.length;
        //System.out.println(hash);
        return hash;
    }

    public void recorrido (int index){

        if(tablaHash[index] == null)
            System.out.println("Sin datos");
        else{
            for(int i = 0; i < tablaHash[index].size(); i++){
                System.out.println(tablaHash[index].getElementAt(i).value);
            }
        }
    }

    public void shearchHashD (String parametroBusqueda){
        int stringToInt = passStringToInt(parametroBusqueda);
        Integer hashIndex = hashingDivition(stringToInt);
        if(tablaHash[hashIndex] == null){
            System.out.println("No se encontraron datos");
        }
        else
            recorrido(hashIndex);
    }

    public void shearchHashM (String parametroBusqueda){
        int stringToInt = passStringToInt(parametroBusqueda);
        Integer hashIndex = hashingMultiplication(stringToInt);
        if(tablaHash[hashIndex] == null){
            System.out.println("No se encontraron datos");
        }
        else
            recorrido(hashIndex);
    }
}