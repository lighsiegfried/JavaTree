package model;

import controller.datastruc.Comparador;
import java.util.Objects;

public class StudentsModel implements Comparador {

    private int idStudents;
    private String name;
    private String study;

    public StudentsModel() {
    }

    public StudentsModel(int idStudents, String name, String _study) {
        this.idStudents = idStudents;
        this.name = name;
        this.study = _study;
    }

    public int getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(int idStudents) {
        this.idStudents = idStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String _study) {
        this.study = _study;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idStudents;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.study);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentsModel other = (StudentsModel) obj;
        if (this.idStudents != other.idStudents) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.study, other.study)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "StudentsModel{" + "Carnet= " + idStudents + ", Nombre= " + name + ", Carrera= " + study + '}';
    }

    @Override
    public boolean igualQue(Object q) {
            StudentsModel stud = (StudentsModel) q;
            return this.idStudents == stud.idStudents;
    }

    @Override
    public boolean menorQue(Object q) {
            StudentsModel stud = (StudentsModel) q;
            return this.idStudents < stud.idStudents;
    }

    @Override
    public boolean menorIgualQue(Object q) {
            StudentsModel stud = (StudentsModel) q;
            return this.idStudents <= stud.idStudents;
    }

    @Override
    public boolean mayorQue(Object q) {
            StudentsModel stud = (StudentsModel) q;
            return this.idStudents > stud.idStudents;
    }

    @Override
    public boolean mayorIgualQue(Object q) {
            StudentsModel stud = (StudentsModel) q;
            return this.idStudents >= stud.idStudents;
    }
}
