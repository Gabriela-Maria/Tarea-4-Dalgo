package Problema4;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private int idVertice;
    private char tipo; // 'F' para fábrica, 'L' para librería, 'B' para bodega
    private Integer capacidad; // Puede ser null para fábricas y librerías
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

    // Getters y setters según sea necesario

    public List<Conexion> getConexiones() {
        return conexiones;
    }

    // Puede agregar más métodos aquí según sea necesario
}

class Conexion {
    private int destino;
    private Integer capacidadCamion;

    public Conexion(int destino, Integer capacidadCamion) {
        this.destino = destino;
        this.capacidadCamion = capacidadCamion;
    }

    // Getters y setters según sea necesario
}
