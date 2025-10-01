package BiCola;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {
    private T dato;
    private Nodo<T> proximo; //Referencia al Proximo elemento.

    public Nodo(T dato){
        this.dato = dato;
        proximo = null; //Null inicialmente ya que no referencia nada antes de entrar a la lista.
    }

    public T getDato() {
        return dato;
    }   

    public void setDato(T dato) {
        this.dato = dato;
    }   

    public Nodo<T> getProximo() {
        return proximo;
    }           

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }   

    @Override
    public String toString() {
        return "Nodo [dato=" + dato + "]";
    }

    @Override
    public int compareTo(Nodo<T> o) {
        return this.getDato().compareTo(o.getDato());
    }
    
}
