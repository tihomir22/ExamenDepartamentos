/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.Conexion;
import java.util.List;
import model.Aula;
import model.Projecte;
import org.hibernate.query.Query;

/**
 *
 * @author mati
 */
public class AulaDAO {

    public static void insertar(Aula aula) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.saveOrUpdate(aula);
        Conexion.guardarTransaccion();
    }

    public static void eliminar(Aula aula) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.delete(aula);
        Conexion.guardarTransaccion();
    }

    public static void modificar(Aula aula) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.update(aula);
        Conexion.guardarTransaccion();
    }

    public static Aula getAula(String id) {
        Conexion.iniciarTransaccion();
        Aula aula = Conexion.sesion.get(Aula.class, id);
        Conexion.guardarTransaccion();
        return aula;
    }

    public static void getAll() {
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT a.codiaula,a.nombre FROM Aula a");
        List<Object[]> lista = query.list();
        for (Object[] res : lista) {
            System.out.println("ID: " + res[0] + " " + res[1]);
        }
        Conexion.guardarTransaccion();
    }

}
