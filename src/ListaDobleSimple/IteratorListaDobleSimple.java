package ListaDobleSimple;
import java.util.Iterator;

public class IteratorListaDobleSimple <T extends Comparable <T>> implements Iterator<T> {
    private NodoDoble<T> actual;

    public IteratorListaDobleSimple(ListaDobleSimple<T> lista){
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
