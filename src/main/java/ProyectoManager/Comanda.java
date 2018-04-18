package ProyectoManager;

import java.util.*;
public class Comanda {
    private int i;
    private Usuario u;
    private ArrayList<Pedido> pedido=new ArrayList<Pedido>();

    public Comanda(){}
    public Comanda (Usuario u, ArrayList<Pedido> pedido){
        this.u=u;
        this.pedido=pedido;
    }

    public Usuario getUsuario(){
        return this.u;
    }
    public void setUsuario(Usuario u) {
        this.u = u;
    }
    public ArrayList<Pedido> getPedido(){
        return this.pedido;
    }

    public void setPedido(ArrayList<Pedido> pedido) {
        this.pedido = pedido;

    }
   /* @Override

    public String toString() {

        return "Comanda [Usuario=" +u+ "Pedidos " + pedido+"]";}

*/
}
