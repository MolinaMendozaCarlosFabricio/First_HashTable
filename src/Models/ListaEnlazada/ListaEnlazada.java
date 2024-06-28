package Models.ListaEnlazada;

public class ListaEnlazada {
    private Node head;
    private int count;

    public ListaEnlazada (){
        this.head = null;
        this.count = 0;
    }

    public void addNode (String valor){
        Node nodo = new Node(valor);
        Node current;
        if(this.head == null)
            this.head = nodo;
        else{
            current = this.head;
            while (current.next != null) {
                current = current.next;
            }
        current.next = nodo;
        }
        this.count++;
    }

    public Node getElementAt (int index){
        if (index >= 0 && index < this.count){
            Node nodo = this.head;
            for (int i = 0; i < index && nodo != null; i++){
                nodo = nodo.next;
            }
            return nodo;
        }
        return null;
    }

    public boolean isEmpity (){
        return size() == 0;
    }

    public int size (){
        return this.count;
    }
}
