package controller;

import controller.datastruc.Arbol;
import controller.datastruc.Nodo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.StudentsModel;

public class StudentsController {

    private final String[] columnNames = {"No. Carnet", "Nombre", "Carrera"};
    private Arbol arbol;
    
    public StudentsController() {
        this.arbol = new Arbol();
    }
    
    public List<StudentsModel> getData() {
        return this.arbol.getDataInOrden(this.arbol.raizArbol());
    }
    
    public void setDataTree(String routeFile) {
        try {
            File myObj = new File(routeFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] csv = data.split(";");
                    
                System.out.println(csv[0]);
                
                int id = Integer.parseInt(csv[0]);
                String name = csv[1];
                String study = csv[2];
                this.arbol.insertar(new StudentsModel(id, name, study));
            }
            
            System.out.println("Mostrar Arbol: ");
            Arbol.inorden(this.arbol.raizArbol());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String createStudents(StudentsModel stud) {
        try {
            this.arbol.insertar(stud);
            return "Carnet: " + stud.getIdStudents() + " ¡Creado exitosamente!";
        } catch (Exception ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
            return "Error: " + ex.getMessage();
        }
    }
    
    public String deleteStudents(StudentsModel stud) {
        try {
            this.arbol.eliminar(stud);
            return "Carnet: " + stud.getIdStudents() + " ¡Eliminado exitosamente!";
        } catch (Exception ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
            return "Error: " + ex.getMessage();
        }
    }
    
    public StudentsModel searchStudents(StudentsModel stud) {
        Nodo n = this.arbol.buscarIterador(stud);
        if(n != null) {
            return (StudentsModel) n.getContent();
        } else {
            return null;
        }
    }
    
    public String updateStudents(StudentsModel stud) {
        try {
            
            StudentsModel studFind = searchStudents(stud);
            if(studFind != null) {
                this.arbol.eliminar(studFind);
                this.arbol.insertar(stud);
                return "Carnet: " + stud.getIdStudents() + " ¡Actualizado exitosamente!";
            } else {
                return " ¡Actualización fallida!";
            }
            
        } catch (Exception ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
            return "Error: " + ex.getMessage();
        }
    }
    
    public JPanel printTree() {
        return this.arbol.getdibujo();
    }
}
