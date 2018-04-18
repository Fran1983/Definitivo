package ProyectoManager;

import java.util.ArrayList;
public class Producto {

    private String articulo;
    private double precio;
    private int ventas;

    public Producto(){}

    public Producto(String articulo, double precio){
        this.articulo=articulo;
        this.precio=precio;
        this.ventas=0;
    }

    public String getArticulo(){
        return this.articulo;
    }
    public void setArticulo(String articulo){
        this.articulo=articulo;
    }
    public double getPrecio(){
        return this.precio;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public int getVentas(){
        return this.ventas;
    }

    public void setVentas(int ventas){
        this.ventas=ventas;
    }
    public int buscarPedido(String articulo, ArrayList<Producto> productos) {
        int resultado = -1;
        int i = 0;
        while (i < productos.size()) {
            if (productos.get(i).getArticulo().equals(articulo)) {
                resultado = i;
            }
            i++;
        }
        return resultado;
    }
   /* @Override

    public String toString() {

        return "Producto [Artículo=" +articulo+ "precio " + precio+ " Ventas " + ventas+"]";}

*/

    // Los setters los implementaré si los necesito a lo largo del desarrolo del código.
}
