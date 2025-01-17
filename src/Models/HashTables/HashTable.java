package Models.HashTables;

import Models.Bussiness.Bussines;
import Models.ListaEnlazada.ListaEnlazada;

public class HashTable {
    public ListaEnlazada tablaHash [] = new ListaEnlazada[15000];

    public void setValueDivition (String key, Bussines value){
        int stringToInt = passStringToInt(key);
        Integer hashIndex = hashingDivition(stringToInt);
        if(tablaHash[hashIndex] == null) {
            tablaHash[hashIndex] = new ListaEnlazada();
            tablaHash[hashIndex].addNode(value);
        }
        else
            tablaHash[hashIndex].addNode(value);
    }

    public void setValueMultiplication (String key, Bussines value){
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
        return value % this.tablaHash.length;
    }

    public Integer hashingMultiplication (Integer value){
        return (value * 601) % tablaHash.length;
    }

    public void recorrido (int index){

        if(tablaHash[index] == null)
            System.out.println("Sin datos");
        else{
            for(int i = 0; i < tablaHash[index].size(); i++){
                System.out.println(tablaHash[index].getElementAt(i).value.nameBussines);
            }
        }
    }

    public void busqueda (int index, String key){
        boolean bandera = false;
        for(int i = 0; i < tablaHash[index].size(); i++){
            if(tablaHash[index].getElementAt(i).value.key.equals(key)) {
                System.out.println("Elemento encontrado:");
                System.out.println(tablaHash[index].getElementAt(i).value.nameBussines);
                bandera = true;
                i = tablaHash[index].size() + 1;
            }
        }
        if(!bandera)
            System.out.println("no se encontro el elemento");
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