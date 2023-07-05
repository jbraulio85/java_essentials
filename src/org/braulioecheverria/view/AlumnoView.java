package org.braulioecheverria.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import org.braulioecheverria.controller.AlumnoController;
import org.braulioecheverria.model.Alumno;
import org.braulioecheverria.utils.ScannerSingleton;

/**
 *
 * @author jbmon
 */
public class AlumnoView {
    private String codigoAcademico;
    private String codigoTecnico;
    private String nombres;
    private String apellidos;
    private String email;
    private int telefono;
    private int id;
    Scanner leer = ScannerSingleton.getInstancia();
    AlumnoController alumnoc = AlumnoController.getInstancia();
    
    /**
     * 
     * @param codigoAcedimico recibe el código académico del estudiante.
     * @param codigoTecnico recibe el código técnico del estudiante
     * @param nombres recibe los nombre del estudiante
     * @param apellidos recibe los apellidos del estudiante
     * @param email recibe el email del estudiante
     * 
     */

    public void menuAgregarAlumno(){
        try{
            System.out.println("Ingresa el código académico");
            codigoAcademico = leer.nextLine();
            codigoAcademico = leer.nextLine();
            System.out.println("Ingresa el código técnico:");
            codigoTecnico = leer.nextLine();
           // codigoTecnico = leer.nextLine();
            System.out.println("Ingresa los nombres");
            nombres = leer.nextLine();
            //nombres = leer.nextLine();
            System.out.println("Ingresa los apellidos");
            apellidos = leer.nextLine();
            //apellidos = leer.nextLine();
            System.out.println("Ingresa el email");
            email = leer.nextLine();
            
            boolean validInput = false;
            while(!validInput){
                try{
                    System.out.println("Ingresa el teléfono");
                     telefono = leer.nextInt();
                     validInput = true;
                }catch(InputMismatchException e){
                    System.out.println("Error: Se ingresó una letra en lugar de un número");
                    leer.nextLine();
                }
            }
           validInput = false;
           while(!validInput){
                try{
                    System.out.println("Ingresa el ID");
                     id = leer.nextInt();
                     validInput = true;
                }catch(InputMismatchException e){
                    System.out.println("Error: Se ingresó una letra en lugar de un número");
                    leer.nextLine();
                }
            }
        
            alumnoc.agregarAlumno(codigoAcademico,codigoTecnico,nombres,apellidos,email,telefono,id);
        }catch(InputMismatchException e){
            System.out.println("Se ingresó una letra en lugar de un número " + e.getMessage());
        }
        
    }
    
    public void mostrarAlumnos(){
        ArrayList<Alumno> arreglo = alumnoc.leerAlumnos();
        
        for(int c = 0; c < arreglo.size(); c++){
            System.out.println(arreglo.get(c));
        }
    }
    
    public void alumnoEncontrado(){
        System.out.println("Ingresa el id del alumno que deseas buscar");
        id = leer.nextInt();
        System.out.println(alumnoc.buscarAlumno(id));
    }
    
    public void actualizarAlumno(){
        System.out.println("Ingresa el id del alumno a actualizar");
        id = leer.nextInt();
        System.out.println("Ingresa el nuevo código académico");
        codigoAcademico = leer.nextLine();
        codigoAcademico = leer.nextLine();
        System.out.println("Ingresa el nuevo código técnico:");
        codigoTecnico = leer.nextLine();
       // codigoTecnico = leer.nextLine();
        System.out.println("Ingresa los nuevos nombres");
        nombres = leer.nextLine();
        //nombres = leer.nextLine();
        System.out.println("Ingresa los nuevos apellidos");
        apellidos = leer.nextLine();
        //apellidos = leer.nextLine();
        System.out.println("Ingresa el nuevo email");
        email = leer.nextLine();
        //email = leer.nextLine();
         boolean validInput = false;
            while(!validInput){
                try{
                    System.out.println("Ingresa el teléfono");
                     telefono = leer.nextInt();
                     validInput = true;
                }catch(InputMismatchException e){
                    System.out.println("Error: Se ingresó una letra en lugar de un número");
                    leer.nextLine();
                }
            }
         alumnoc.actualizarAlumnoPorId(codigoAcademico,codigoTecnico,nombres,apellidos,email,telefono,id);
    }
    
    public void eliminarAlumnoId(){
        System.out.println("Ingresa el id del alumno que deseas buscar");
        id = leer.nextInt();
        alumnoc.eliminarAlumnoPorId(id);
    }
    
}
