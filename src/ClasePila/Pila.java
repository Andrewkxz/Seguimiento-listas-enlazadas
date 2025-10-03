package ClasePila;

import java.util.Iterator;

public class Pila<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> frente;
    private int tam;

    public Pila() {
        this.frente = null;
        this.tam = 0;
    }

    public void empilar(Nodo<T> nuevoNodo){
        if(frente == null && tam == 0){
            frente = nuevoNodo;
        }else{
            nuevoNodo.setProximo(frente);
            frente = nuevoNodo;
        }
        tam++;
    }

    public Nodo<T> desempilar(){
        if(frente == null && tam == 0){
            System.out.println("Pila vacia, no se puede desapilar");
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
            return; //La pila esta vacia o tiene un solo elemento.
        }

        boolean cambio;
        do{
            cambio = false;
            Nodo<T> actual = frente;
            Nodo<T> siguiente = frente.getProximo();

            while(siguiente != null){
                if(actual.getDato().compareTo(siguiente.getDato()) > 0){
                    T cambiar = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(cambiar);
                    cambio = true;
                }
                actual = siguiente;
                siguiente = siguiente.getProximo();
            }
        }while(cambio);
    }

    //Metodo para agregar de manera natural a una lista
    public void agregarOrdenNatural(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (frente == null || frente.getDato().compareTo(dato) >= 0) {
            newNodo.setProximo(frente);
            frente = newNodo;
        } else {
            Nodo<T> actual = frente;
            while (actual.getProximo() != null && actual.getProximo().getDato().compareTo(dato) < 0) {
                actual = actual.getProximo();
            }
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);
        }
        tam++;
    }

    public Nodo<T> getFrente() {
        return frente;
    }

    public void setFrente(Nodo<T> frente) {
        this.frente = frente;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorPila<>(this);
    }
    
}
