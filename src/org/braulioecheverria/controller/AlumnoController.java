package org.braulioecheverria.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import org.braulioecheverria.model.Alumno;
import org.braulioecheverria.utils.Excepciones;

/**
 *
 * @author jbmon
 */
public class AlumnoController extends Excepciones{
    private static AlumnoController instancia;
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    private String mensaje;
    
    private  AlumnoController (){
        
    }
    
    public static synchronized AlumnoController getInstancia(){
        if(instancia == null){
            instancia = new AlumnoController();
        }
        return instancia;
    }
    
    public void agregarAlumno(String codigoAcademico, String codigoTecnico, String nombres, String apellidos,  
        String email, int telefono, int id){ 
        Alumno al = new Alumno(codigoAcademico,codigoTecnico,nombres,apellidos,email,telefono,id);
        try{
            FileOutputStream fileOut = new FileOutputStream("alumnos.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            alumnos.add(al);
            objectOut.writeObject(alumnos);
            System.out.println("Se ha guardado exitosamente");
        }catch (FileNotFoundException e){
            System.out.println("Existió un erro al guardar " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("Existió un error al al ejecutar el método");
        }catch(NumberFormatException e){
            System.out.println("Ingresaste una létra en lugar de un número");
        }
    }
    
    public ArrayList leerAlumnos(){
        try{
            FileInputStream fileIn = new FileInputStream("alumnos.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            alumnos = (ArrayList)objectIn.readObject();
        }catch(FileNotFoundException e){
            System.out.println("Existió un erro al recuperar la información: " + e.getMessage());
        }catch (IOException ex) {
            System.out.println("Error de entrada o de salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Existió un error al recuperar la información, no se encuentra la clase.");
        }
        return alumnos;
    }
    
    public Alumno buscarAlumno(int id){
        for(Alumno alumno : alumnos){
            if(alumno.getId() == id){
                return alumno;
            }
        }
        return null;
    }
    
    public void actualizarAlumnoPorId(String codigoAcademico, String codigoTecnico, String nombres, String apellidos,
            String email, int telefono, int id){
         try{
            FileInputStream fileIn = new FileInputStream("alumnos.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            alumnos = (ArrayList)objectIn.readObject();
            for(Alumno alumno : alumnos){
                if(alumno.getId() == id){
                    alumno.setCodigoAcademico(codigoAcademico);
                    alumno.setCodigoTecnico(codigoTecnico);
                    alumno.setNombres(nombres);
                    alumno.setApellidos(apellidos);
                    alumno.setEmail(email);
                    alumno.setTelefono(telefono);
                    break;
                }
            }
            guardarAlumnos();
        }catch(FileNotFoundException e){
            System.out.println("Existió un error al recuperar la información: " + e.getMessage());
        }catch (IOException ex) {
            System.out.println("Error de entrada o de salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Existió un error al recuperar la información, no se encuentra la clase.");
        }
        
    }
    
    public void guardarAlumnos(){
        try{
            FileOutputStream fileOut = new FileOutputStream("alumnos.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(alumnos);
            System.out.println("Se ha guardado exitosamente");
        }catch (FileNotFoundException e){
            System.out.println("Existió un erro al guardar " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("Existió un error de ejecución");
        }
    }
    
     public void eliminarAlumnoPorId(int id){
         try{
            FileInputStream fileIn = new FileInputStream("alumnos.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            alumnos = (ArrayList)objectIn.readObject();
            for(Alumno alumno : alumnos){
                if(alumno.getId() == id){
                    alumnos.remove(alumno);
                    System.out.println("Alumno Eliminaron exitosamente");
                    break;
                }
            }
            guardarAlumnos();
        }catch(FileNotFoundException e){
            System.out.println("Existió un error al recuperar la información: " + e.getMessage());
        }catch (IOException ex) {
            System.out.println("Error de entrada o de salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Existió un error al recuperar la información, no se encuentra la clase.");
        }
    }
}
