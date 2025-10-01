package ClaseCola;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int tam;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tam = 0;
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    
}
