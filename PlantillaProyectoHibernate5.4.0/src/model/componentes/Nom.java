/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.componentes;

import java.io.Serializable;

/**
 *
 * @author mati
 */
public class Nom implements Serializable {

    private String nom;

    public Nom(String nom) {
        this.nom = nom;
    }

    public Nom() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Nom{" + "nom=" + nom + '}';
    }

}
