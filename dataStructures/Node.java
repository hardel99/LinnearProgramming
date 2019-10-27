package dataStructures;

/**
 *
 * @author hardel
 */
public class Node {
    private final int valor;
    private Node conectar = null;
    
    public Node(int v){
        this.valor = v;
        this.conectar = null;
    }
    
    public void enlazarNodo(Node node){
        conectar = node;
    }
    
    public int getValor(){
        return valor;
    }
    
    
    public Node getNext(){
        return conectar;
    }

    public void setNext(Node conectar) {
        this.conectar = conectar;
    }
}
