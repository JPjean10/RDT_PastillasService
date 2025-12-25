package com.RDT_PastillasSercio.model;

public class PresionModel {

    private long id_usuario;
    private long id_presion;
    private int sys;
    private int dia;
    private int pul;
    private String fecha_hora_creacion;
    private boolean estado;

    public long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }
    public long getId_presion() {
        return id_presion;
    }
    public void setId_presion(long id_presion) {
        this.id_presion = id_presion;
    }
    public int getSys() {
        return sys;
    }
    public void setSys(int sys) {
        this.sys = sys;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getPul() {
        return pul;
    }
    public void setPul(int pul) {
        this.pul = pul;
    }
    public String getFecha_hora_creacion() {
        return fecha_hora_creacion;
    }
    public void setFecha_hora_creacion(String fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
