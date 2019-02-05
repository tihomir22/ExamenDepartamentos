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
public class ProjecteDAO {

    public static void insertar(Projecte proj) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.saveOrUpdate(proj);
        Conexion.guardarTransaccion();
    }

    public static void eliminar(Projecte proj) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.delete(proj);
        Conexion.guardarTransaccion();
    }

    public static void modificar(Projecte proj) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.update(proj);
        Conexion.guardarTransaccion();
    }

    public static Projecte getProjecte(int id) {
        Conexion.iniciarTransaccion();
        Projecte proj = Conexion.sesion.get(Projecte.class, id);
        Conexion.guardarTransaccion();
        return proj;
    }

    public static void getAll() {
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT p.codproj,p.nom FROM Projecte p");
        List<Object[]> lista = query.list();
        for (Object[] res : lista) {
            System.out.println("ID: " + res[0] + " " + res[1]);
        }
        Conexion.guardarTransaccion();
    }

    public static void nombreProyectoEmpiezaRYAula() {
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT p.nom FROM Projecte p WHERE p.lloc ='Aula' and p.nom LIKE 'R%'");
        List<Nom> lista = query.list();
        System.out.println("********** RESULTADO QUERY **********");
        for (Nom res : lista) {
            System.out.println(res.getNom());
        }
        Conexion.guardarTransaccion();
    }

    public static void ubicadosIgualQue1() {
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT p.nom FROM Projecte p WHERE p.lloc =(SELECT p.lloc FROM Projecte p WHERE p.codproj=1) and p.codproj<>1");
        List<Nom> lista = query.list();
        System.out.println("********** RESULTADO QUERY **********");
        for (Nom res : lista) {
            System.out.println(res.getNom());
        }
        Conexion.guardarTransaccion();
    }

   
}
