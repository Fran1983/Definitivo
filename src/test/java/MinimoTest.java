import ProyectoManager.*;
import ProyectoManager.Producto;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MinimoTest {
    ProductManagerImpl restaurante;
    Usuario u1;
    Usuario u2;
    Pedido p1;
    Pedido p2;
    Pedido p3;
    Pedido p4;
    Comanda c1;
    Comanda c2;

    @org.junit.Before
    public void setUp() throws Exception {
        restaurante = ProductManagerImpl.getInstance();
        u1= new Usuario("Fran");
        u2=new Usuario("Javi");
        p1=new Pedido ("cafe",2);
        p2=new Pedido ("bocadillo",1);
        ArrayList<Pedido> lp1=new ArrayList<Pedido>();
        lp1.add(p1);
        lp1.add(p2);
        c1=new Comanda(u1,lp1);
        p3=new Pedido ("refresco",3);
        p4=new Pedido ("sandwich",2);
        ArrayList<Pedido> lp2=new ArrayList<Pedido>();
        lp2.add(p3);
        lp2.add(p4);
        c2=new Comanda(u2,lp2);

    }

    @org.junit.After
    public void tearDown() throws Exception {
        u1=null;
        u2=null;
        p1=null;
        p2=null;
        p3=null;
        p4=null;
        c1=null;
        c2=null;
        ProductManagerImpl.clear();
    }

    @org.junit.Test
    public void realizarpedido() throws Exception {
        assertNotEquals(1, restaurante.diccionarioUsuario.size());
        restaurante.realizarPedido(c1);
        assertEquals(1, restaurante.diccionarioUsuario.size());
        assertEquals(1,restaurante.cola.size());
        restaurante.realizarPedido(c2);
        assertEquals(2, restaurante.diccionarioUsuario.size());
        assertEquals(2,restaurante.cola.size());

    }
    @org.junit.Test
    public void servirPedido() throws Exception {
        assertNotEquals(2, restaurante.diccionarioUsuario.size());
        assertEquals(0,restaurante.cola.size());
        restaurante.realizarPedido(c1);
        assertEquals(1,restaurante.cola.size());
        restaurante.servirPedido();
        assertEquals(0,restaurante.cola.size());

    }

}


