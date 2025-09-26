package ListaSimpleCircular;

import java.util.Iterator;

public class IteratorListaSimpleCircular <T extends Comparable <T>> implements Iterator<T> {
    private Nodo<T> actual;

    public IteratorListaSimpleCircular(ListaSimpleCircular<T> lista){
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
