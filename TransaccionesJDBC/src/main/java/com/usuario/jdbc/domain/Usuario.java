package com.usuario.jdbc.domain;

public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String clave_usuario;

    public int getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return this.nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave_usuario() {
        return this.clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    // Borrar -> DELETE
    public Usuario() {
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    // Insertar -> INSERT

    public Usuario(String nombre_usuario, String clave_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.clave_usuario = clave_usuario;
    }

    // Actualizar -> UPDATE

    public Usuario(int id_usuario, String nombre_usuario, String clave_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.clave_usuario = clave_usuario;
    }

    // vista en consola -> toString

    @Override
    public String toString() {
        return "{" +
                " id_usuario='" + getId_usuario() + "'" +
                ", nombre_usuario='" + getNombre_usuario() + "'" +
                ", clave_usuario='" + getClave_usuario() + "'" +
                "}";
    }

}
