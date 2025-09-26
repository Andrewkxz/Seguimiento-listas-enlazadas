package RepasoJavaRecursividad.Preparcial1.Punto1;

public class Main {
    public static void main(String[] args) {
        MiLista miLista = new MiLista(5);
        miLista.agregarCadena("Hola");
        miLista.agregarCadena("que");
        miLista.agregarCadena("tal");
        miLista.agregarCadena("estas");
        miLista.agregarCadena("?");
        
        for (String cadena : miLista) {
            System.out.println(cadena);
        }
    }
}
