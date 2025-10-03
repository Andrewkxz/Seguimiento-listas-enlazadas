package ListaDobleCircular;

import java.util.Iterator;

public class IteratorListaDobleCircular<T> implements Iterator<T> {
    private Nodo<T> actual;
    private Nodo<T> cabeza;
    private boolean primerElemento;

    public IteratorListaDobleCircular(Nodo<T> cabeza) {
        this.cabeza = cabeza;
        this.actual = cabeza;
        this.primerElemento = true;
    }

    @Override
    public boolean hasNext() {
        return actual != null && (primerElemento || actual != cabeza);
    }

    @Override
    public T next() {
        if (!hasNext()) return null;
        T dato = actual.dato;
        actual = actual.siguiente;
        primerElemento = false;
        return dato;
    }
}
