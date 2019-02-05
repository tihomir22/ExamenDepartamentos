/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.AulaDAO;
import controller.DepartamentDAO;
import controller.ProjecteDAO;
import model.componentes.Nom;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import model.Aula;
import model.Departament;
import model.Projecte;
import model.enumerados.Lloc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Maite
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //CREAMOS CONEXION
        Scanner teclado = new Scanner(System.in);
        int opcion = 999;
        String nombre, codigo;
        Conexion.conectarse();

        //Datos de ejemplo
        Departament dep = new Departament("TIC", Calendar.getInstance().getTime(), 10);
        dep.setNom(new Nom("Informatica Tratamiento"));
        Aula aula1 = new Aula("TIC", "Aula de Tic");
        dep.setAula(aula1);

        Projecte proj = new Projecte();
        proj.setNom(new Nom("proyecto de prueba"));
        proj.setLloc(Lloc.Aula);
        proj.setDep(dep);

        while (opcion != 0) {
            System.out.println("Que tipo de consultas deseas realizar? [1] Basicas(CRUD) [2] Complejas o [0] para Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    consultasBasicas();
                    opcion = teclado.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Se va a insertar ... ");
                            System.out.println(proj.toString());
                            Thread.sleep(1000);
                            ProjecteDAO.insertar(proj);
                            System.out.println("Insertado con exito");
                            break;

                        case 2:
                            System.out.println("Se va a eliminar ... ");
                            System.out.println(proj.toString());
                            Thread.sleep(1000);
                            ProjecteDAO.eliminar(proj);
                            System.out.println("Eliminado con exito");
                            break;
                        case 3:
                            ProjecteDAO.getAll();
                            System.out.println("Introduzca el id del Proyecto a modificar");
                            Projecte recu = ProjecteDAO.getProjecte(teclado.nextInt());
                            if (recu != null) {
                                System.out.println("Introduzca un nuevo nombre para el proyecto");
                                System.out.println(proj.toString());
                                teclado.nextLine();
                                nombre = teclado.nextLine();
                                if (!nombre.isEmpty()) {
                                    System.out.println("Recibido " + nombre);
                                    recu.setNom(new Nom(nombre));
                                    ProjecteDAO.modificar(recu);
                                } else {
                                    System.out.println("No se ha encontrado");
                                }
                            } else {
                                System.out.println("Debes introducir algo!");
                            }
                            break;

                        case 4:
                            System.out.println("Se va a insertar ... ");
                            System.out.println(dep.toString());
                            Thread.sleep(1000);
                            DepartamentDAO.insertar(dep);
                            System.out.println("Insertado con exito");
                            break;

                        case 5:
                            System.out.println("Se va a eliminar ... ");
                            System.out.println(dep.toString());
                            Thread.sleep(1000);
                            DepartamentDAO.eliminar(dep);
                            System.out.println("Eliminado con exito");
                            break;
                        case 6:
                            DepartamentDAO.getAll();
                            System.out.println("Introduzca el id del Departamento a modificar");
                            teclado.nextLine();
                            Departament recuDep = DepartamentDAO.getDepartamento(teclado.nextLine());
                            if (recuDep != null) {
                                System.out.println("Introduzca un nuevo nombre para el departamento");
                                System.out.println(recuDep.toString());
                                nombre = teclado.nextLine();
                                if (!nombre.isEmpty()) {
                                    System.out.println("Recibido " + nombre);
                                    recuDep.setNom(new Nom(nombre));
                                    DepartamentDAO.modificar(recuDep);
                                } else {
                                    System.out.println("No se ha encontrado");
                                }
                            } else {
                                System.out.println("Debes introducir algo!");
                            }
                            break;

                        case 7:
                            System.out.println("Se va a insertar ... ");
                            System.out.println(aula1.toString());
                            Thread.sleep(1000);
                            AulaDAO.insertar(aula1);
                            System.out.println("Insertado con exito");
                            break;

                        case 8:
                            System.out.println("Se va a eliminar ... ");
                            System.out.println(aula1.toString());
                            Thread.sleep(1000);
                            AulaDAO.eliminar(aula1);
                            System.out.println("Eliminado con exito");
                            break;

                        case 9:
                            AulaDAO.getAll();
                            System.out.println("Introduzca el codigoaula de la Aula a modificar");
                            teclado.nextLine();
                            Aula recuAu = AulaDAO.getAula(teclado.nextLine());
                            if (recuAu != null) {
                                System.out.println("Introduzca un nuevo nombre para la aula");
                                System.out.println(recuAu.toString());
                                nombre = teclado.nextLine();
                                if (!nombre.isEmpty()) {
                                    System.out.println("Recibido " + nombre);
                                    recuAu.setNombre(nombre);
                                    AulaDAO.modificar(recuAu);
                                } else {
                                    System.out.println("No se ha encontrado");
                                }
                            } else {
                                System.out.println("Debes introducir algo!");
                            }
                            break;

                    }
                    break;
                case 2:
                    consultasComplejas();
                    opcion = teclado.nextInt();
                    switch (opcion) {
                        case 1:
                            ProjecteDAO.nombreProyectoEmpiezaRYAula();
                            break;
                        case 2:
                            ProjecteDAO.ubicadosIgualQue1();
                            break;
                        case 3:
                            DepartamentDAO.MasQueLaMediaHoras();
                            break;

                        case 4:
                            teclado.nextLine();
                            System.out.println("Introduzca codigo del departamento (string)");
                            codigo = teclado.nextLine();
                            DepartamentDAO.visualizarDepartamentoNombre(codigo);
                            break;
                        case 5:
                            teclado.nextLine();
                            System.out.println("Introduzca codigo del departamento (string)");
                            codigo = teclado.nextLine();
                            DepartamentDAO.visualizarDepartamentoPosicional(codigo);
                            break;

                        case 6:
                            teclado.nextLine();
                            System.out.println("Introduzca codigo del departamento (string)");
                            codigo = teclado.nextLine();
                            DepartamentDAO.joinFetchConsulta(codigo);
                            break;
                        case 7:
                            teclado.nextLine();
                            System.out.println("Introduzca codigo del departamento (string)");
                            codigo = teclado.nextLine();
                            Conexion.iniciarTransaccion();

                            Query query = Conexion.sesion.createNamedQuery("consultaJoinFetch");
                            query.setParameter("dep", codigo);
                            List<Departament> lista = query.list();
                            System.out.println("Resultado consulta Visualizacion con parametros por posicion");
                            for (Departament res : lista) {
                                System.out.println("DEPARTAMENTO : " + res.getNom().getNom());
                                for (Projecte p : res.getListaProjecte()) {
                                    System.out.println("\t PROYECTO : " + p.getCodproj() + " " + p.getNom().getNom());
                                }
                            }

                            Conexion.guardarTransaccion();
                            break;
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Has introducido un valor incorrecto");
                    break;
            }
        }

        Conexion.cerrarSesion();
    }

    public static void consultasBasicas() {
        System.out.println("1.- Insertar Departamento");
        System.out.println("2.- Eliminar Departamento");
        System.out.println("3.- Modificar Departamento");

        System.out.println("4.- Insertar Proyecto");
        System.out.println("5.- Eliminar Proyecto");
        System.out.println("6.- Modificar Proyecto");
        
        System.out.println("7.- Insertar Aula");
        System.out.println("8.- Eliminar Aula");
        System.out.println("9.- Modificar Aula");

      
    }

    public static void consultasComplejas() {
        System.out.println("1.-Seleccionar nombre de los proyectos cuyo nombre empieza por R y son de aula");
        System.out.println("2.-Selecciona el nobmre de los proyectos que esten ubicados en el mismo sitio que el proyecto con numero 1");
        System.out.println("3.-Selecciona departamentos que tengan mas horas que la media");
        System.out.println("4.-Seleccionar datos de un departamento y de sus proyectos por nombre");
        System.out.println("[ATENCIÓN] LA SIGUIENTE CONSULTA LA 5 ESTA DEPRECATED, TIRARÁ UNA EXCEPCION PERO LA SINTAXIS ES LA CORRECTA, VAYA CON CUIDAO");
        System.out.println("5.-Seleciconar datos de un departamento y de sus proyectos por secuencia");
        System.out.println("6.-Consulta anterior optimizada con Join Fetch ");
        System.out.println("7.-Consulta llamada desde fichero de mapeo");
    }

}
