package ListaDobleCircular;

import java.util.Iterator;


public class ListaDobleCircular <T extends Comparable<T>> implements Iterable<T> {
    private NodoDoble<T> primero; //Referencia al primer elemento de la lista.
    private NodoDoble<T> ultimo;  //Referencia al último elemento de la lista.
    private int tam; //Tamaño de la lista.

    //Lista vacia
    public ListaDobleCircular(){
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public NodoDoble<T> getPrimero() {
        return primero;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }

    public int getTam() {
        return tam;
    }

    public void ordenar(){
        if(primero == null || primero.getProximo() == primero){
            return;
        }
        NodoDoble<T> actual = primero;
        do {
            NodoDoble<T> siguiente = actual.getProximo();
            do {
                if(actual.getDato().compareTo(siguiente.getDato()) > 0){
                    T cambiar = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(cambiar);
                }
                siguiente = siguiente.getProximo();
            } while(siguiente != primero);
            actual = actual.getProximo();
        } while(actual != primero);
    }

    public void insertarOrdenado(T dato){
        NodoDoble<T> newNodo = new NodoDoble<>(dato);
        if(primero == null){
            primero = newNodo;
            ultimo = newNodo;
            primero.setProximo(primero);
            primero.setAnterior(primero);
            tam++;
            return;
        }
        if(primero.getDato().compareTo(dato) >= 0){
            agregarPrimero(dato);
            return;
        }
        NodoDoble<T> actual = primero;
        while(actual.getProximo() != primero && actual.getProximo().getDato().compareTo(dato) < 0){
            actual = actual.getProximo();
        }
        NodoDoble<T> siguiente = actual.getProximo();
        newNodo.setProximo(siguiente);
        newNodo.setAnterior(actual);
        actual.setProximo(newNodo);
        siguiente.setAnterior(newNodo);
        if(actual == ultimo){
            ultimo = newNodo;
        }
        tam++;
    }

    public void agregarPrimero(T dato){
        NodoDoble<T> newNodo = new NodoDoble<>(dato);
        if(primero == null){
            primero = newNodo;
            ultimo = newNodo;
            primero.setProximo(primero);
            primero.setAnterior(primero);
        }else{
            newNodo.setProximo(primero);
            newNodo.setAnterior(ultimo);
            primero.setAnterior(newNodo);
            ultimo.setProximo(newNodo);
            primero = newNodo;
        }
        tam++;
    }
    public void agregarFinal(T dato){
        NodoDoble<T> newNodo = new NodoDoble<>(dato);
        if(primero == null){
            primero = newNodo;
            ultimo = newNodo;
            primero.setProximo(primero);
            primero.setAnterior(primero);
        }else{
            ultimo.setProximo(newNodo);
            newNodo.setAnterior(ultimo);
            newNodo.setProximo(primero);
            primero.setAnterior(newNodo);
            ultimo = newNodo;
        }
        tam++;
    }

    public void agregarPosicion (T dato, int posicion){
        if(posicion == 0) {
            agregarPrimero(dato);
            return;
        } else if (posicion >= tam) {
            agregarFinal(dato);
            return;
        } else {
            NodoDoble<T> actual = primero;
            for(int i = 0; i < posicion - 1; i++){
                actual = actual.getProximo();
            }
            NodoDoble<T> siguiente = actual.getProximo();
            NodoDoble<T> newNodo = new NodoDoble<>(dato);
            newNodo.setProximo(siguiente);
            newNodo.setAnterior(actual);
            actual.setProximo(newNodo);
            siguiente.setAnterior(newNodo);
        }
        tam++;
    }

    public void mostrar(){
        if(primero == null){
            System.out.println("[]");
            return;
        }
        NodoDoble<T> actual = primero;
        String mensaje = "[";
        do {
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        } while(actual != primero);
        mensaje += "]";
        System.out.println(mensaje);
    }
    
    public boolean esVacia(){
        return (primero == null && tam == 0);
    }

    public int localizar(T dato){
        if(primero == null) return -1;
        NodoDoble<T> actual = primero;
        int indexBusqueda = 0;
        do {
            if(actual.getDato().equals(dato)){
                return indexBusqueda;
            }
            indexBusqueda++;
            actual = actual.getProximo();
        } while(actual != primero);
        return -1;
    }

    public boolean buscar(T datoBusqueda){
        if(primero == null) return false;
        NodoDoble<T> actual = primero;
        do {
            if(actual.getDato().equals(datoBusqueda)){
                return true;
            }
            actual = actual.getProximo();
        } while(actual != primero);
        return false;
    }

    public void eliminar(T datoBusqueda){
        if(primero == null) return;
        NodoDoble<T> actual = primero;
        do {
            if(actual.getDato().equals(datoBusqueda)){
                NodoDoble<T> anterior = actual.getAnterior();
                NodoDoble<T> siguiente = actual.getProximo();
                anterior.setProximo(siguiente);
                siguiente.setAnterior(anterior);
                if(actual == primero){
                    primero = siguiente;
                }
                if(actual == ultimo){
                    ultimo = anterior;
                }
                tam--;
                if(tam == 0){
                    primero = null;
                    ultimo = null;
                }
                return;
            }
            actual = actual.getProximo();
        } while(actual != primero);
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorListaDobleCircular<>(this);
    }
}