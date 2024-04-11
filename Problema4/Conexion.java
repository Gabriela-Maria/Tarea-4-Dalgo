package Problema4;

public class Conexion {
    private int destino;
    private Integer capacidadCamion;

    public Conexion(int destino, Integer capacidadCamion) {
        this.destino = destino;
        this.capacidadCamion = capacidadCamion;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public Integer getCapacidadCamion() {
        return capacidadCamion;
    }

    public void setCapacidadCamion(Integer capacidadCamion) {
        this.capacidadCamion = capacidadCamion;
    }

}
