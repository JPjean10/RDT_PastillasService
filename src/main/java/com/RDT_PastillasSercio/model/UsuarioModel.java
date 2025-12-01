package com.RDT_PastillasSercio.model;

public class UsuarioModel {

    private Long id_usuario;

    private String usuario;

    private String contrasena;

    private String FechaHoraCreacion;

    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getFechaHoraCreacion() {
        return FechaHoraCreacion;
    }
    public void setFechaHoraCreacion(String fechaHoraCreacion) {
        FechaHoraCreacion = fechaHoraCreacion;
    }

}
