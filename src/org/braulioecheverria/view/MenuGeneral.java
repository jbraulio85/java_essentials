
package org.braulioecheverria.view;

import java.util.Scanner;
import org.braulioecheverria.utils.ScannerSingleton;

/**
 *
 * @author jbmon
 */
public class MenuGeneral {
    
    public void iniciar(){
        AlumnoView av = new AlumnoView();
        Boolean flag = true;
        Scanner leer = ScannerSingleton.getInstancia();
        
        while(flag == true){
            System.out.println("Seleccional la opción que deseas realizar");
            System.out.println("1. agregar alumno");
            System.out.println("2. mostrar alumno");
            System.out.println("3. buscar un alumno por id");
            System.out.println("4. actualizar alumno");
            System.out.println("5. eliminar alumno");
            int op = leer.nextInt();
            switch(op){
                case  1:
                    av.menuAgregarAlumno();
                    break;
                case 2:
                    av.mostrarAlumnos();
                    break;
                case 3:
                    av.alumnoEncontrado();
                    break;
                case 4:
                    av.actualizarAlumno();
                    break;
                case 5:
                    av.eliminarAlumnoId();
                    break;
            }
            System.out.println("Deseas continuar 1. Si, 2. No");
            int op2 = leer.nextInt();
            if(op2 == 1){
                flag = true;
            }else{
                flag = false;
            }
        }
    }
}
