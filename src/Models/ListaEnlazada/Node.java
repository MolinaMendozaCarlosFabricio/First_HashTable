package Models.ListaEnlazada;

public class Node {
    public String value;
    public Node next;
    public Node (String valor){
        this.value = valor;
        this.next = null;
    }
}
