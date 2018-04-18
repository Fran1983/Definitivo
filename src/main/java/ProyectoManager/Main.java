package ProyectoManager;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        ProductManagerImpl restaurante = ProductManagerImpl.getInstance();
        ArrayList<Producto> productos = restaurante.productosOrdenadosPrecio();
        for (Producto p:productos){
            System.out.println(p.getArticulo()+" "+p.getPrecio());
        }
    }
}

