package Estructuras;

/**
 *
 * @author hardel
 */
public class Node {
    private final float valor;
    private Node conectar = null;
    
    public Node(float v){
        this.valor = v;
        this.conectar = null;
    }
    
    public void enlazarNodo(Node node){
        conectar = node;
    }
    
    public float getValor(){
        return valor;
    }
    
    
    public Node getNext(){
        return conectar;
    }

    public void setNext(Node conectar) {
        this.conectar = conectar;
    }
}
