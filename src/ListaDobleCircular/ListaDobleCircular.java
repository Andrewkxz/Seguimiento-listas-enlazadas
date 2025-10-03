package ListaDobleCircular;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class ListaDobleCircular<T extends Comparable<T>> implements Iterable<T> {
    private NodoDoble<T> cabeza;
    private int tam;

    public ListaDobleCircular() {
        cabeza = null;
        tam = 0;
    }

    public void agregarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoDoble<T> ultimo = cabeza.getAnterior();
            nuevo.setSiguiente(cabeza);
            nuevo.setAnterior(ultimo);
            cabeza.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            cabeza = nuevo;
        }
        tam++;
    }

    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion <= 0) {
            agregarInicio(dato);
            return;
        }
        if (posicion >= tam) {
            NodoDoble<T> nuevo = new NodoDoble<>(dato);
            if (cabeza == null) {
                cabeza = nuevo;
                cabeza.setSiguiente(cabeza);
                cabeza.setAnterior(cabeza);
            } else {
                NodoDoble<T> ultimo = cabeza.getAnterior();
                nuevo.setSiguiente(cabeza);
                nuevo.setAnterior(ultimo);
                ultimo.setSiguiente(nuevo);
                cabeza.setAnterior(nuevo);
            }
            tam++;
            return;
        }

        NodoDoble<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        NodoDoble<T> anterior = actual.getAnterior();
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        nuevo.setSiguiente(actual);
        nuevo.setAnterior(anterior);
        anterior.setSiguiente(nuevo);
        actual.setAnterior(nuevo);
        tam++;
    }

    public void Ordenar() {
        if (tam <= 1) return;
        ArrayList<T> lista = new ArrayList<>();
        for (T dato : this) {
            lista.add(dato);
        }
        Collections.sort(lista);
        cabeza = null;
        tam = 0;
        for (int i = lista.size() - 1; i >= 0; i--) {
            agregarInicio(lista.get(i));
        }
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public NodoDoble<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDoble<T> cabeza) {
        this.cabeza = cabeza;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoDoble<T> actual = cabeza;
            private boolean primerElemento = true;
            private boolean terminado = false;

            @Override
            public boolean hasNext() {
                if (cabeza == null || terminado) return false;
                if (primerElemento) return true;
                return actual != cabeza;
            }

            @Override
            public T next() {
                if (!hasNext()) return null;
                T dato = actual.getDato();
                actual = actual.getSiguiente();
                primerElemento = false;
                if (actual == cabeza) terminado = true;
                return dato;
            }
        }
    }
}
