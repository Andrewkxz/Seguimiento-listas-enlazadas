package BiCola;

import java.util.Iterator;

public class BiCola<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tam;

    public BiCola() {
        this.frente = null;
        this.fin = null;
        this.tam = 0;
    }

    public void encolarFrente(Nodo<T> nuevoNodo){
        if(frente == null && tam == 0){
            frente = nuevoNodo;
            fin = nuevoNodo;
        }else{
            nuevoNodo.setProximo(frente);
            frente = nuevoNodo;
        }
        tam++;
    }

    public void encolarFin(Nodo<T> nuevoNodo){
        if(frente == null && tam == 0){
            frente = nuevoNodo;
            fin = nuevoNodo;
        }else{
            fin.setProximo(nuevoNodo);
            fin = nuevoNodo;
        }
        tam++;
    }

    public Nodo<T> desencolarFrente(){
        if(frente == null && tam == 0){
            System.out.println("BiCola vacia, no se puede desencolar");
            return null;
        }else{
            Nodo<T> aux = frente;
            frente = frente.getProximo();
            tam--;
            return aux;
        }
    }

    public Nodo<T> desencolarFin(){
        if(frente == null && tam == 0){
            System.out.println("BiCola vacia, no se puede desencolar");
            return null;
        }else{
            Nodo<T> aux = fin;
            Nodo<T> actual = frente;
            while(actual.getProximo() != fin){
                actual = actual.getProximo();
            }
            fin = actual;
            fin.setProximo(null);
            tam--;
            return aux;
        }
    }

    public void encolar(Nodo<T> nuevoNodo){
        if(frente == null && tam == 0){

            frente = nuevoNodo;
            fin = nuevoNodo;
        }else{
            fin.setProximo(nuevoNodo);
            fin = nuevoNodo;
        }
        tam++;
    }

    public Nodo<T> desencolar(){
        if(frente == null && tam == 0){
            System.out.println("Cola vacia, no se puede desencolar");
            return null;
        }else{
            Nodo<T> aux = frente;
            frente = frente.getProximo();
            tam--;
            return aux;
        }
    }

     public void agregarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        encolarFrente(nuevoNodo);
    }

     public void agregarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        encolarFin(nuevoNodo);

    }

        public void agregarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tam) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (posicion == 0) {
            agregarInicio(dato);
        } else if (posicion == tam) {
            agregarFinal(dato);
        } else {
            Nodo<T> actual = frente;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getProximo();
            }
            nuevoNodo.setProximo(actual.getProximo());
            actual.setProximo(nuevoNodo);
            tam++;
        }
    }

    public void ordenar(){
        if(frente == null || frente.getProximo() == null){
            return; //La lista está vacía, entonces ya está ordenada.
        }

        boolean cambio;
        do {
            cambio = false;
            Nodo<T> actual = frente;
            Nodo<T> siguiente = frente.getProximo();

            while(siguiente != null){
                if(actual.getDato().compareTo(siguiente.getDato()) > 0){
                    //cambio de datos
                    T cambiar = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(cambiar);
                    cambio = true;
                }
                actual = siguiente;
                siguiente = siguiente.getProximo();
            }
        } while(cambio);
    }

    //Metodo para agregar de manera natural a una lista
    public void agregarOrdenNatural(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (frente == null || frente.getDato().compareTo(dato) >= 0) {
            newNodo.setProximo(frente);
            frente = newNodo;
            if(fin == null){
                fin = newNodo;
            }
            tam++;
            return;
        } else {
            Nodo<T> actual = frente;
            while (actual.getProximo() != null && actual.getProximo().getDato().compareTo(dato) < 0) {
                actual = actual.getProximo();
            }
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);
            if (newNodo.getProximo() == null) {
                fin = newNodo; // Actualiza el fin si se inserta al final
            }
        }
        tam++;
    }

    public Nodo<T> getFrente() {
        return frente;
    }

    public void setFrente(Nodo<T> frente) {
        this.frente = frente;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorBiCola<>(this);
    }

    
}
