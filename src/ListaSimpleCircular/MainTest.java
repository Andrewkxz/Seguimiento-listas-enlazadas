package ListaSimpleCircular;

public class MainTest {
    public static void main(String[] args) {
        ListaSimpleCircular<String> lista = new ListaSimpleCircular<>();

        /**
        lista.agregarPrimero("una lista");
        lista.agregarPrimero("desde");
        lista.agregarPrimero("a todos");
        lista.agregarPrimero("Hola");
        **/

        /** 
        lista.agregarUltimo("Hola");
        lista.agregarUltimo("a todos");
        lista.agregarUltimo("desde");
        lista.agregarUltimo("una lista");
        **/

        /** 
        lista.agregarPosicion("sapa", 0);
        lista.agregarPosicion("a todos", 1);    
        lista.agregarPosicion("Hola", 2);  
        lista.agregarPosicion("una lista", 3);
        **/

        lista.agregarOrdenNatural("hola");
        lista.agregarOrdenNatural("a todos");
        lista.agregarOrdenNatural("desde"   );
        lista.agregarOrdenNatural("una lista");


        lista.mostrar();    
    }
}
