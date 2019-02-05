/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author mati
 */
public class Aula implements Serializable {

    private String codiaula;
    private String nombre;

    public Aula(String codiaula, String nombre) {
        this.codiaula = codiaula;
        this.nombre = nombre;
    }

    public Aula() {
    }

    public String getCodiaula() {
        return codiaula;
    }

    public void setCodiaula(String codiaula) {
        this.codiaula = codiaula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Aula{" + "codiaula=" + codiaula + ", nombre=" + nombre + '}';
    }

}
