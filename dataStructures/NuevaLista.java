package dataStructures;

/**
 *
 * @author hardel
 */
public class NuevaLista {
    private Node first, last;
    private int size;
    
    public NuevaLista(){
        first = null;
        last = null;
        size = 0;
    }
    
    public void addInitialNode(int dato){
        if(first == null) {
            first=new Node(dato);
        } else{
            Node aux = first;
            Node nuevo = new Node(dato);
            nuevo.enlazarNodo(aux);
            first = nuevo;  
        }
        
        size++;
    }
    
    public void addNodeZ(int dato) {
        if(first != null){
            if(dato <= 0 || dato == -1){ // si el dato es <= 0 el elemento sera 0 o si es -1 
                last.setNext(new Node(0));
                last = last.getNext();
            }else{
                last.setNext(new Node(dato*-1));
                last = last.getNext();
            }
        }else{
            first = last = new Node(dato*(-1));
        }
        
        size++;
    }
    
    public void addNodeS(int dato, char s) {
        if(first != null){
            if(dato <= 0 && s == 'a'){
                last.setNext(new Node(1));
                last = last.getNext();
                
                if(s =='s'){
                    last.setNext(new Node(0));
                    last = last.getNext();
                }
            }else{
                last.setNext(new Node(dato));
                last = last.getNext();
            }
        }else{
            first = last = new Node(dato);
        }
        
        size++;
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public int getSize(){
        return size;
    }

    public int getElementAt(int indice){
        Node nodo = first;
        
        while(indice > 0) {
            nodo = nodo.getNext();
            indice--;
        }
        
        return nodo.getValor();
    }


    public void deleteElementAt(int indice){
        if(indice==0){
            first=first.getNext();
        }else{
            int contador=0;
            Node aux=first;

            while(contador < indice-1) {
                aux=aux.getNext();
                contador++;
            }

            aux.enlazarNodo(aux.getNext().getNext());
        }

        size--;
    }


    public void deleteFrom(int indice) {
        if(indice==0){
           first.enlazarNodo(null);
        }else{
            int contador=0;
            Node aux=first;
            
            while(contador < indice-1){
                aux = aux.getNext();
                contador++;
            }
            
            aux.enlazarNodo(null);
            size = indice;
        }
    }

    public void showList(NuevaLista lista){
        for(int i=0; i < lista.getSize(); i++){
            System.out.print(" -- " + lista.getElementAt(i));
        }

        System.out.println();
    }
    
    public void  deleteElementFromIndex(int numero ) {
        if(first.getValor()== numero){
           first=first.getNext();
           System.out.println("El elemento estaba en el inicio");        
        }else {
           Node anterior,temporal;
           anterior=first;
           temporal=first.getNext();

           while(temporal != null && temporal.getValor()!= numero){
               anterior=anterior.getNext();
               temporal=temporal.getNext();     
           }

           anterior.setNext(temporal.getNext());
        }
        
        size--;
    }
    
    
    public boolean search(int elemento , NuevaLista lista){
        boolean bandera = false;
        if(lista.first.getValor() == elemento){
            bandera = true;
            System.out.println("El elemento esta en el inicio de la lista");
        }else{
            for(int i=0; i < lista.getSize(); i++  ){
                if(lista.getElementAt(i) == elemento){
                    bandera = true;
                    System.out.println("El elemento esta en la lista ");
                }
            }
        }
        
        if(!bandera){
            System.out.println("El elemento no esta en la lista");
        }        
        System.out.println(bandera);
        
        return bandera;
    }

    
    public void eliminarRecursivo(int numero,NuevaLista lista){
        if(search(numero,lista)==false){
            System.out.println("Elementos eliminados");
        } else{
            System.out.println("repite iteracion");
            
            deleteElementFromIndex(numero);
            eliminarRecursivo(numero,lista);
        }
    }
    
//    public void bubbleSort(int []arreglo){
//        int matriz[] = arreglo;
//        int aux;
//      
//        for(int x=0; x < arreglo.length; x++ ){
//            for(int y=x+1; y < arreglo.length; y++){
//                if(matriz[x]> matriz[y]){
//                  aux = matriz[x];
//                  matriz[x] = matriz[y];
//                  matriz[y] = aux;
//                }
//            }
//            
//            System.out.println(matriz[x]);
//        }
//    }
    
//    public void metodoRadix(int[] numeros){
//        int numero = 0;
//        for(int x=0; x < numeros.length; x++){
//            numero = numeros[x];
//        }
//    }
}  

