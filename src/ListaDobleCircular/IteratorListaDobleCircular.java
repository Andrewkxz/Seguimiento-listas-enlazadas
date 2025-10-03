package ListaDobleCircular;
import java.util.Iterator;

public class IteratorListaDobleCircular <T extends Comparable <T>> implements Iterator<T> {
    private NodoDoble<T> actual;

    public IteratorListaDobleCircular(ListaDobleCircular<T> lista){
        this.actual = lista.getPrimero();
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T dato = actual.getDato(); //Obtenemos el dato del nodo actual.
        actual = actual.getProximo(); //Avanzamos al siguiente nodo.
        return dato; //Devolvemos el dato del nodo actual.
    }
    
}
