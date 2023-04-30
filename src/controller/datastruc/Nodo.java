package controller.datastruc;

import model.StudentsModel;

public class Nodo {
    private StringBuilder sBuilder;
    private Nodo izquierda;
    private Nodo derecha;
    private Object content;

    public Nodo(Object content) {
        this.content = content;
        this.izquierda = null;
        this.derecha = null;
        this.sBuilder = new StringBuilder();
    }

    public Nodo(Nodo izquierda, Nodo derecha, Object content) {
        this.content = content;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public void visitar() {
        System.out.println(this.content + " ");
    }
    
    public void setSBuilder() {
        this.sBuilder = new StringBuilder();
    }
    
    public String getSBuilder() {
        return this.sBuilder.toString();
    }
    
    public void printBinaryTree(Nodo root, int level){
        
        if(root==null)
             return;
        StudentsModel stud = (StudentsModel) root.getContent();
        printBinaryTree(root.getDerecha(), level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                this.sBuilder.append("|\t");
                //System.out.print("|\t");
            //System.out.println("|-------"+root.getContent());
            this.sBuilder.append("|-------").append(stud.getIdStudents()).append("\n");
        }
        else
            this.sBuilder.append(stud.getIdStudents()).append("\n");
            //System.out.println(root.getContent());
        printBinaryTree(root.getIzquierda(), level+1);
    }    
}
