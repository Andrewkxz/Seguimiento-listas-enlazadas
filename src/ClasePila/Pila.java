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
