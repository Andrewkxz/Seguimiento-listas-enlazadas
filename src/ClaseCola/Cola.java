package ClaseCola;

import java.util.Iterator;

public class Cola<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tam;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tam = 0;
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

    public void ordenar(){
        if(frente == null || frente.getProximo() == null){
            return; //La cola esta vacia o tiene un solo elemento.
        }

        Nodo<T> actual = frente;

        while(actual != null){
            Nodo<T> siguiente = actual.getProximo();
            while(siguiente != null){
                if(actual.getDato().compareTo(siguiente.getDato()) > 0){
                    T cambiar = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(cambiar);
                }
                siguiente = siguiente.getProximo();
            }
            actual = actual.getProximo();
        }
    }

    //Metodo para agregar de manera natural a una lista
    public void agregarOrdenNatural(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (frente == null || frente.getDato().compareTo(dato) >= 0) {
            newNodo.setProximo(frente);
            frente = newNodo;
            fin = newNodo; // Si la cola estaba vacía, el nuevo nodo es también el fin
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
        return new IteratorCola<>(this);
    }

    
}
