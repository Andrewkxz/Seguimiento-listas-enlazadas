package LinkedList;

public class MainTest2 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Double> lista1 = new ListaSimpleEnlazada<>();

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

        lista1.agregarOrdenNatural(1.5);
        lista1.agregarOrdenNatural(2.3);
        lista1.agregarOrdenNatural(1.1);
        lista1.agregarOrdenNatural(3.7);

        System.out.println("Recorrido con for-each:");
        for(Double num : lista1){
            System.out.println(num);
        }
        

        //lista1.mostrar();    
    }
}
