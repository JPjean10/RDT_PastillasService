package com.RDT_PastillasSercio.model;

public class GlucosaModel {

    private Long id_glucosa;
    private Long id_usuario;
    private int nivel_glucosa;
    private String fecha_hora_creacion;
    private Boolean en_ayunas;
    private Boolean estado;

    public Long getId_glucosa() {
        return id_glucosa;
    }
    public void setId_glucosa(Long id_glucosa) {
        this.id_glucosa = id_glucosa;
    }
    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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
    public Boolean getEn_ayunas() {
        return en_ayunas;
    }
    public void setEn_ayunas(Boolean en_ayunas) {
        this.en_ayunas = en_ayunas;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
