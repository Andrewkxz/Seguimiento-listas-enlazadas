package ListaDobleCircular;

public class NodoDoble<T extends Comparable<T>> implements Comparable<NodoDoble<T>> {
    private T dato;
    private NodoDoble<T> anterior; //Referencia al nodo anterior.
    private NodoDoble<T> proximo; //Referencia al Proximo elemento.

    public NodoDoble(T dato){
        this.dato = dato;
        anterior = null; //Null inicialmente ya que no referencia nada antes de entrar a la lista.
        proximo = null; //Null inicialmente ya que no referencia nada antes de entrar a la lista.
    }

    public T getDato() {
        return dato;
    }   

    public void setDato(T dato) {
        this.dato = dato;
    }
    
    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public NodoDoble<T> getProximo() {
        return proximo;
    } 
    
    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    public void setProximo(NodoDoble<T> proximo) {
        this.proximo = proximo;
    }   

    @Override
    public String toString() {
        return "Nodo [dato=" + dato + "]";
    }

    @Override
    public int compareTo(NodoDoble<T> o) {
        return this.getDato().compareTo(o.getDato());
    }
    
}
