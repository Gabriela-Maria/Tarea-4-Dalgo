package Problema4;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private int idVertice;
    private char tipo; // 'F' para fábrica, 'L' para librería, 'B' para bodega
    private Integer capacidad; // null en fabrica y libreria al inicio
    private List<Conexion> conexiones;

    public Vertice(int idVertice, char tipo, Integer capacidad) {
        this.idVertice = idVertice;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.conexiones = new ArrayList<>();
    }

    public int getIdVertice() {
        return idVertice;
    }

    public void setIdVertice(int idVertice) {
        this.idVertice = idVertice;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setConexiones(List<Conexion> conexiones) {
        this.conexiones = conexiones;
    }

    public void agregarConexion(int destino, Integer capacidadCamion) {
        conexiones.add(new Conexion(destino, capacidadCamion));
    }


    public List<Conexion> getConexiones() {
        return conexiones;
    }
}

