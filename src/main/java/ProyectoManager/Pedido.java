package ProyectoManager;

public class Pedido {
    private String articulo;
    private int cantidad;

    public Pedido(){};

    public Pedido(String articulo, int cantidad){
        this.articulo=articulo;
        this.cantidad=cantidad;
    }

    public String getArticulo(){
        return this.articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
