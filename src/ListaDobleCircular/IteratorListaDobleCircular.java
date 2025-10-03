package ListaDobleCircular;
import java.util.Iterator;

public class IteratorListaDobleCircular <T extends Comparable <T>> implements Iterator<T> {
    private NodoDoble<T> actual;
    private NodoDoble<T> primero; // Nodo inicial para detectar el ciclo
    private boolean recorridoCompleto; // Indicador para saber si hemos completado un ciclo

    public IteratorListaDobleCircular(ListaDobleCircular<T> lista){
        this.primero = lista.getPrimero();
        this.actual = primero;
        this.recorridoCompleto = false;
    }

    @Override
    public boolean hasNext() {
        return actual != null && (!recorridoCompleto || actual != primero);
    }

    @Override
    public T next() {
        T dato = actual.getDato(); //Obtenemos el dato del nodo actual.
        actual = actual.getProximo(); //Avanzamos al siguiente nodo.
        recorridoCompleto = true; // Marcamos que hemos avanzado al menos una vez
        return dato; //Devolvemos el dato del nodo actual.
    }
    
}
