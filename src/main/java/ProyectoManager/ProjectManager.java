package ProyectoManager;


import ProyectoManager.Pedido;
import ProyectoManager.Producto;
import ProyectoManager.Usuario;

import java.util.ArrayList;
import java.util.List;

interface ProductManager {

    //1.- Listado de productos ordenados (ascendentemente) por precios.

    public ArrayList<Producto> productosOrdenadosPrecio();

    //2.-  Realizar un pedido

    public void realizarPedido(Comanda c);

    //3.- Servir un pedido

    public void servirPedido();

    // 4.- Histórico de pedidos de un usuario.

    public ArrayList<ArrayList<Pedido>> historicoPedidos(Usuario u);

    //5.- Listado de productos ordenados (descendentemente) por ventas.

    public List<Producto> productosOrdenadosVentas();
}
