/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.componentes.Nom;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mati
 */
public class Departament implements Serializable {

    private String dep;
    private Nom nom;
    private Date data;
    private int horas;
    private Set<Projecte> listaProjecte = new HashSet(0);
    private Aula aula;

    public Departament(String dep, Date data, int horas) {
        this.dep = dep;
        this.data = data;
        this.horas = horas;
    }

    public Departament() {
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public Nom getNom() {
        return nom;
    }

    public void setNom(Nom nom) {
        this.nom = nom;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Set<Projecte> getListaProjecte() {
        return listaProjecte;
    }

    public void setListaProjecte(Set<Projecte> listaProjecte) {
        this.listaProjecte = listaProjecte;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    @Override
    public String toString() {
        return "Departament{" + "dep=" + dep + ", nom=" + nom + ", data=" + data + ", horas=" + horas + ", listaProjecte=" + listaProjecte + ", aula=" + aula + '}';
    }

}
