package ListaSimpleEnlazada;

import java.util.Iterator;

public class ListaSimpleEnlazada <T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> primero; //Referencia al primer elemento de la lista.
    private int tam; //Tamaño de la lista.

    //Lista vacia
    public ListaSimpleEnlazada(){
        primero = null; //Null inicialmente ya que no referencia nada antes de entrar a la lista.
        tam = 0;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public int getTam() {
        return tam;
    }

    public void agregarPrimero(T dato){
        Nodo<T> newNodo = new Nodo<>(dato);

        if(primero == null){
            primero = newNodo;
            tam++;
        }else{
            newNodo.setProximo(primero);
            primero = newNodo;
            tam++;
        }
    }
    public void agregarFinal(T dato){
        Nodo<T> newNodo = new Nodo<>(dato);
        if(primero == null){
            primero = newNodo;
        }else{
            Nodo<T> actual = primero;
            while(actual.getProximo() != null){
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
        }
        tam++;
    }

    public void agregarPosicion (T dato, int posicion){
        Nodo<T> newNodo = new Nodo<>(dato);
        if(posicion == 0) {
            newNodo.setProximo(primero);
            primero = newNodo;
        }else{
            Nodo<T> actual = primero;
            for(int i = 0; i < posicion - 1; i++){
                actual = actual.getProximo();
            }
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);
        }
        tam++;
    }
    //Metodo para agregar de manera natural a una lista
    public void agregarOrdenNatural(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (primero == null || primero.getDato().compareTo(dato) >= 0) {
            newNodo.setProximo(primero);
            primero = newNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != null && actual.getProximo().getDato().compareTo(dato) < 0) {
                actual = actual.getProximo();
            }
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);
        }
        tam++;
    }

    public void mostrar(){
        Nodo<T> actual = primero;
        String mensaje = "[";

        while(actual != null){
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        }

        mensaje += "]";
        System.out.println(mensaje);
    }
    
    public boolean esVacia(){
        return (primero == null && tam == 0) ? true : false;
    }

    public int localizar(T dato){
        Nodo<T> actual = primero;
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
        Nodo<T> actual = primero;
        boolean flag = false;

        while (actual !=null){
            if(actual.getDato().equals(datoBusqueda)){
                flag = true;
            }
            actual = actual.getProximo();
        }
        return flag;
    }
    
    public void eliminar(T datoBusqueda){
        Nodo<T> actual = primero;

        if(actual.getDato().equals(datoBusqueda)){
            primero = actual.getProximo();
            tam--;
            return;
        }else{

            while(actual.getProximo() != null){
                if(actual.getProximo().getDato().equals(datoBusqueda)){
                    actual.setProximo(actual.getProximo().getProximo());
                    tam--;
                    return;
                }
                actual = actual.getProximo();
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorListaSimpleEnlazada<>(this);
    }
}


/* asi nos damos cuenta de que una lista es vacia
    public boolean esVacia(){
        return (primero == null && tam == 0) ? true : false;
 */

/* localizar elemento en una lista y se devuelve la posición
    public T localizar(T dato){
    Nodo<T> actual = primero;
    int indexBusqueda = 0;

    while (actual != null){
        if(actual.getDato().equals(datoBusqueda)){
            return indexBusqueda;
    }
    indexBusqueda++;
    actual = actual.getProximo();
        }

        return -1;
    }
 */

/*
    public boolean buscar(T datoBusqueda){
        Nodo<T> actual = primero;
        boolean flag = false;
        }
        while (actual !=null){
            if(actual.getDato().equals(datoBusqueda)){
                flag = true;
        }
        actual = actual.getProximo();
      }
      return flag;
}
 */

/*
    public void eliminar(T datoBusqueda){
        Nodo<T> actual = primero;

    if(actual.getDato().equals(datoBusqueda)){
        primero = actual.getProximo();
        tam--;
        return true;
    }else{

    while(actual.getProximo() != null){
        if(actual.getProximo().getDato().equals(datoBusqueda()){
            actual.setProximo(actual.getProximo().getProximo());
            tam--;
            return true;

            }

            actual = actual.getProximo();
        }
        return false;
     }
 */