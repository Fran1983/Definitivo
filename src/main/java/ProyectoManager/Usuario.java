package ProyectoManager;

import ProyectoManager.Pedido;

import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private ArrayList<ArrayList<Pedido>> historicoPedidos=new ArrayList<ArrayList<Pedido>>();


    public Usuario(){}
    public Usuario(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<ArrayList<Pedido>> gethistoricoPedidos(){
        return this.historicoPedidos;
    }


    public void sethistoricoPedidos(ArrayList<Pedido> p){
        this.historicoPedidos.add(p);
    }


}
