package ListaDobleSimple;

import java.util.Iterator;

public class ListaDobleSimple <T extends Comparable<T>> implements Iterable<T> {
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo; 


    public ListaDobleSimple(){
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

    public void agregarPrimero(T dato){
        NodoDoble<T> newNodo = new NodoDoble<>(dato);

        if(primero == null){
            primero = newNodo;
            ultimo = newNodo;
        }else{
            newNodo.setProximo(primero);
            primero.setAnterior(newNodo);
            primero = newNodo;
        }
        tam++;
    }
    public void agregarFinal(T dato){
        NodoDoble<T> newNodo = new NodoDoble<>(dato);
        if(primero == null){
            primero = newNodo;
            ultimo = newNodo;
        }else{
            ultimo.setProximo(newNodo);
            newNodo.setAnterior(ultimo);
            ultimo = newNodo;
        }
        tam++;
    }

    public void agregarPosicion (T dato, int posicion){
        NodoDoble<T> newNodo = new NodoDoble<>(dato);
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
            newNodo.setProximo(siguiente);
            newNodo.setAnterior(actual);
            actual.setProximo(newNodo);
            if(siguiente != null) {
                siguiente.setAnterior(newNodo);
            }
        }
        tam++;
    }

    public void agregarOrdenNatural(T dato) {
        NodoDoble<T> newNodo = new NodoDoble<>(dato);

        if (primero == null || primero.getDato().compareTo(dato) >= 0) {
            agregarPrimero(dato);
        } else {
            NodoDoble<T> actual = primero;
            while (actual.getProximo() != null && actual.getProximo().getDato().compareTo(dato) < 0) {
                actual = actual.getProximo();
            }
            NodoDoble<T> siguiente = actual.getProximo();
            newNodo.setProximo(siguiente);
            newNodo.setAnterior(actual);
            actual.setProximo(newNodo);
            if(siguiente != null) {
                siguiente.setAnterior(newNodo);
            } else {
                ultimo = newNodo;
            }
            tam++;
        }
    }

    public void mostrar(){
        NodoDoble<T> actual = primero;
        String mensaje = "[";

        while(actual != null){
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        }

        mensaje += "]";
        System.out.println(mensaje);
    }
    
    public boolean esVacia(){
        return (primero == null && tam == 0);
    }

    public int localizar(T dato){
        NodoDoble<T> actual = primero;
        int indexBusqueda = 0;

        while (actual != null){
            if(actual.getDato().equals(dato)){
                return indexBusqueda;
            }
            indexBusqueda++;
            actual = actual.getProximo();
        }
        return -1;
    }

    public boolean buscar(T datoBusqueda){
        NodoDoble<T> actual = primero;

        while (actual !=null){
            if(actual.getDato().equals(datoBusqueda)){
                return true;
            }
            actual = actual.getProximo();
        }
        return false;
    }
    
    public void eliminar(T datoBusqueda){
        NodoDoble<T> actual = primero;

        while(actual != null){
            if(actual.getDato().equals(datoBusqueda)){
                NodoDoble<T> anterior = actual.getAnterior();
                NodoDoble<T> siguiente = actual.getProximo();
                if(anterior != null) {
                    anterior.setProximo(siguiente);
                } else {
                    primero = siguiente;
                }
                if(siguiente != null) {
                    siguiente.setAnterior(anterior);
                } else {
                    ultimo = anterior;
                }
                tam--;
                return;
            }
            actual = actual.getProximo();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorListaDobleSimple<>(this);
    }
}