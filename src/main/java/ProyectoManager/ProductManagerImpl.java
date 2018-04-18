package ProyectoManager;

import java.util.*;


import org.apache.log4j.Logger;
public class ProductManagerImpl implements ProductManager {

    private static Logger log = Logger.getLogger(ProductManagerImpl.class);
    private ArrayList<Producto> catalogo=new ArrayList<Producto>();
    public Queue<Comanda> cola=new LinkedList<Comanda>();
    public HashMap<String, Usuario> diccionarioUsuario=new HashMap<String, Usuario>();
    private static ProductManagerImpl ourInstance;

    public static ProductManagerImpl getInstance() {
        if (ourInstance==null)//Si es la primera vez que se llama al constructor crea la nueva isntancia si no devuelve la ya creada
            ourInstance = new ProductManagerImpl();
        return ourInstance;
    }

    private ProductManagerImpl() {
        //Carga el catálogo de productos.
        this.catalogo = this.generarCatalogoProducto();
    }


    //1.- Listado de productos ordenados (ascendentemente) por precios.
    @Override
    public ArrayList<Producto> productosOrdenadosPrecio(){
        ArrayList<Producto> catalogoOrdenado=catalogo;
        Collections.sort(catalogoOrdenado, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return new Double(p1.getPrecio()).compareTo(p2.getPrecio());
            }
        });
        log.info("Catálogo ordenado");
        return catalogoOrdenado;
    }

    //2.-  Realizar un pedido
    @Override
    public void realizarPedido(Comanda c){
        Usuario u=c.getUsuario();

        if(diccionarioUsuario.get(u.getNombre())==null){
            diccionarioUsuario.put(u.getNombre(),u);
            log.info("Nuevo usuario añadido");
        }

        cola.add(c);
        log.info("Pedido realizado");
    }

    //3.- Servir un pedido
    @Override
    public void servirPedido(){
        Producto pservicio=new Producto();
        Comanda servicio=cola.poll();
        for (Pedido pedido:servicio.getPedido()){
            int i=pservicio.buscarPedido(pedido.getArticulo(),catalogo);
            catalogo.get(i).setVentas(catalogo.get(i).getVentas()+pedido.getCantidad());
            log.info("Sumada la cantidad de productos vendidos al artículo");
        }
        Usuario uservido=servicio.getUsuario();
        diccionarioUsuario.get(uservido.getNombre()).sethistoricoPedidos(servicio.getPedido());
        log.info("Añadido el pedido al histórico de pedidos");
    }

    // 4.- Histórico de pedidos de un usuario.
    @Override
    public ArrayList<ArrayList<Pedido>> historicoPedidos(Usuario u){
        ArrayList<ArrayList<Pedido>> historico=new ArrayList<ArrayList<Pedido>>();
        historico=u.gethistoricoPedidos();
        log.info("Se obtiene todos los pedidos de un usuario");
        return historico;
    }

    //5.- Listado de productos ordenados (descendentemente) por ventas.
    @Override
    public List<Producto> productosOrdenadosVentas(){
        ArrayList<Producto> productosOrdenadosVenta=catalogo;
        Collections.sort(productosOrdenadosVenta, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                //return p2.getVentas()-p1.getVentas();
                return new Integer(p2.getVentas()).compareTo(new Integer(p1.getVentas()));
            }
        });
        log.info("Productos ordenados por venta");

        return productosOrdenadosVenta;
    };


    //6.- Encargado de cargar el catálogo con los artículos

    public ArrayList<Producto> generarCatalogoProducto(){
        Producto p1=new Producto("cafe", 1.3);
        Producto p2=new Producto("cerveza", 1.5);
        Producto p3=new Producto("refresco", 1.7);
        Producto p4=new Producto("donuts", 1);
        Producto p5=new Producto("bocadillo", 2);
        Producto p6=new Producto("sandwich", 1.8);
        catalogo.add(p1);
        catalogo.add(p2);
        catalogo.add(p3);
        catalogo.add(p4);
        catalogo.add(p5);
        catalogo.add(p6);
        log.info("Catálogo creado");
        return catalogo;
    }
    // Metodo para mandar comandas y verlas en JSON
    public Comanda enviarComanda(){
        Usuario u=new Usuario("Fran");
        Pedido p1=new Pedido("cerveza", 3);
        Pedido p2=new Pedido("cafe", 1);
        Pedido p3=new Pedido("bocadillo", 4);
        ArrayList<Pedido> lp=new ArrayList<Pedido>();
        u.sethistoricoPedidos(lp);
        Producto j=new Producto("tortilla",1.4);
        lp.add(p1);
        lp.add(p2);
        lp.add(p3);
        Comanda c=new Comanda(u,lp);
        return c;
    }
    public static void clear(){
        ourInstance = new ProductManagerImpl();}

}
