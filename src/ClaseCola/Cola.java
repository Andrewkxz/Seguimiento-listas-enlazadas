package ClaseCola;

public class Cola {
    private Nodo inicio;
    private Nodo fin;
    private int tamaño;

    public Cola() {
        this.inicio = null;
        this.fin = null;
        this.tamaño = 0;
    }

    public Nodo encolar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
        tamaño++;
        return nuevoNodo;
    }

    public Nodo desencolar() {
        if (inicio == null) {
            return null; // La cola está vacía
        }
        Nodo nodoDesencolado = inicio;
        inicio = inicio.getSiguiente();
        if (inicio == null) {
            fin = null; // La cola quedó vacía después de desencolar
        }
        tamaño--;
        return nodoDesencolado;
    }


    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    @Override


}