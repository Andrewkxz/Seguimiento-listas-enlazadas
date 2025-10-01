package ClasePila;

import java.util.Iterator;

public class IteratorPila <T extends Comparable <T>> implements Iterator<T> {
    private Nodo<T> actual;

    public IteratorPila(Pila<T> lista){
        this.actual = lista.getFrente();
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
