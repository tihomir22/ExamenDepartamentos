/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.Conexion;
import java.util.List;
import model.Departament;
import model.Projecte;
import model.componentes.Nom;
import org.hibernate.query.Query;

/**
 *
 * @author mati
 */
public class DepartamentDAO {

    public static void insertar(Departament dep) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.saveOrUpdate(dep);
        Conexion.guardarTransaccion();
    }

    public static void eliminar(Departament dep) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.delete(dep);
        Conexion.guardarTransaccion();
    }

    public static void modificar(Departament dep) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.update(dep);
        Conexion.guardarTransaccion();
    }

    public static Departament getDepartamento(String id) {
        Conexion.iniciarTransaccion();
        Departament dep = Conexion.sesion.get(Departament.class, id);
        Conexion.guardarTransaccion();
        return dep;
    }

    public static void getAll() {
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT d.dep,d.nom FROM Departament d");
        List<Object[]> lista = query.list();
        for (Object[] res : lista) {
            System.out.println("ID: " + res[0] + " " + res[1]);
        }
        Conexion.guardarTransaccion();
    }

    public static void MasQueLaMediaHoras() {
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT d FROM Departament d WHERE d.horas > (SELECT AVG(d.horas) FROM Departament d)");
        List<Departament> lista = query.list();
        System.out.println("********** RESULTADO QUERY **********");
        for (Departament res : lista) {
            System.out.println(res.getNom().getNom() + "\t" + res.getDep());
        }
        Conexion.guardarTransaccion();
    }

    public static void visualizarDepartamentoNombre(String id) {

        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT d FROM Departament d WHERE d.dep=:dep");
        query.setParameter("dep", id);
        List<Departament> lista = query.list();
        System.out.println("Resultado consulta Visualizacion con parametros por nombre");
        for (Departament res : lista) {
            System.out.println("DEPARTAMENTO : " + res.getNom().getNom());
            for (Projecte p : res.getListaProjecte()) {
                System.out.println("\t PROYECTO : " + p.getCodproj() + " " + p.getNom().getNom());
            }
        }
        Conexion.guardarTransaccion();
    }

    public static void visualizarDepartamentoPosicional(String id) {

        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT d FROM Departament d WHERE d.dep=?");
        query.setString(0, id);
        List<Departament> lista = query.list();
        System.out.println("Resultado consulta Visualizacion con parametros por posicion");
        for (Departament res : lista) {
            System.out.println("DEPARTAMENTO : " + res.getNom().getNom());
            for (Projecte p : res.getListaProjecte()) {
                System.out.println("\t PROYECTO : " + p.getCodproj() + " " + p.getNom().getNom());
            }
        }
        Conexion.guardarTransaccion();
    }

    public static void joinFetchConsulta(String id) {

        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT d FROM Departament d LEFT JOIN FETCH d.listaProjecte WHERE d.dep=:dep");
        query.setParameter("dep", id);
        List<Departament> lista = query.list();
        System.out.println("Resultado consulta Visualizacion con parametros por posicion");
        for (Departament res : lista) {
            System.out.println("DEPARTAMENTO : " + res.getNom().getNom());
            for (Projecte p : res.getListaProjecte()) {
                System.out.println("\t PROYECTO : " + p.getCodproj() + " " + p.getNom().getNom());
            }
        }
        Conexion.guardarTransaccion();
    }

}
