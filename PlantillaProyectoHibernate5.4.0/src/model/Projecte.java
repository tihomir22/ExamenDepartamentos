/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.componentes.Nom;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import model.enumerados.Lloc;

/**
 *
 * @author mati
 */
public class Projecte implements Serializable {

    private int codproj;
    private Nom nom;
    private Lloc lloc;
    private Departament dep;

    public Projecte() {
    }

    public Departament getDep() {
        return dep;
    }

    public void setDep(Departament dep) {
        this.dep = dep;
    }

    public int getCodproj() {
        return codproj;
    }

    public void setCodproj(int codproj) {
        this.codproj = codproj;
    }

    public Nom getNom() {
        return nom;
    }

    public void setNom(Nom nom) {
        this.nom = nom;
    }

    public Lloc getLloc() {
        return lloc;
    }

    public void setLloc(Lloc lloc) {
        this.lloc = lloc;
    }

    @Override
    public String toString() {
        return "Projecte{" + "codproj=" + codproj + ", nom=" + nom + ", lloc=" + lloc + ", dep=" + dep + '}';
    }

}
