package ProjectService;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import ProyectoManager.*;


@Path("/producto")
public class ProductService {

    ProductManagerImpl servicio;

    public ProductService() {

        servicio=ProductManagerImpl.getInstance();

    }

    @GET
    @Path("/productosOrdenadosPrecio")
    @Produces(MediaType.APPLICATION_JSON) //Para enviar datos
    //@Consumes para recibir datos
    public ArrayList<Producto> getProductosOrdenadosPrecio() {
        return servicio.productosOrdenadosPrecio();
    }

    @GET
    @Path("/productosOrdenadosVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getProductosOrdenadosVentas() {
        return servicio.productosOrdenadosVentas();
    }

    @GET
    @Path("/enviarComanda")
    @Produces(MediaType.APPLICATION_JSON)
    public Comanda setenviarComanda() {
        Comanda p=servicio.enviarComanda();
        return p;
    }

    @POST
    @Path("/productosRealizarPedido")
    @Produces(MediaType.APPLICATION_JSON) //Para enviar datos
    @Consumes(MediaType.APPLICATION_JSON)

    public Response setPedido(Comanda c) {
        servicio.realizarPedido(c);
        return Response.status(201).entity("Pedido realizado").build();
    }
    @GET
    @Path("/servirPedido")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setServirPedido() {
        servicio.servirPedido();
        return Response.status(201).entity("Pedido servido").build();

    }
}
