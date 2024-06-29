package Models.ListaEnlazada;

import Models.Bussiness.Bussines;

public class Node {
    public Bussines value;
    public Node next;
    public Node (Bussines valor){
        this.value = valor;
        this.next = null;
    }
}
