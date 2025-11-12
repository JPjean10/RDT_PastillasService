package com.RDT_PastillasSercio.model;

public class GlucosaModel {

    private Integer id_glucosa;
    private int nivel_glucosa;
    private String fecha_hora_creacion;
    private Boolean estado;

    public Integer getId_glucosa() {
        return id_glucosa;
    }
    public void setId_glucosa(Integer id_glucosa) {
        this.id_glucosa = id_glucosa;
    }
    public int getNivel_glucosa() {
        return nivel_glucosa;
    }
    public void setNivel_glucosa(int nivel_glucosa) {
        this.nivel_glucosa = nivel_glucosa;
    }
    public String getFecha_hora_creacion() {
        return fecha_hora_creacion;
    }
    public void setFecha_hora_creacion(String fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
