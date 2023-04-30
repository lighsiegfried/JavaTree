package controller.datastruc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.StudentsModel;

public class Arbol {
	
    private Nodo raiz;
    private static List<StudentsModel> list;
    public Arbol() {
        Arbol.list = new ArrayList<>();
    }

    public Arbol(Nodo raiz) {
            this.raiz = null;
    }

    public Nodo raizArbol() {
            return this.raiz;
    }

    public boolean esVacio() {
            return this.raiz == null;
    }

    public static Nodo nuevoArbol(Nodo ramaIzq, Nodo ramaDere, Object dato){
            return new Nodo(ramaIzq, ramaDere, dato);
    }
    
    public List<StudentsModel> getDataInOrden(Nodo r) {
        Arbol.list = new ArrayList<>();
        inorden(r);
        return Arbol.list;
    }

    public static void preorden(Nodo r) {
            if(r != null) {
                    r.visitar();
                    preorden(r.getIzquierda());
                    preorden(r.getDerecha());
            }
    }

    public static void inorden(Nodo r) {
            if(r != null) {
                    inorden(r.getIzquierda());
                    Arbol.list.add((StudentsModel) r.getContent());
                    //r.visitar();
                    inorden(r.getDerecha());
            }
    }

    public static void postorden(Nodo r) {
            if(r != null) {
                    postorden(r.getIzquierda());
                    postorden(r.getDerecha());
                    r.visitar();
            }
    }

    public Nodo buscar(Object buscado) {
            Comparador dato;
            dato = (Comparador) buscado;
            if(this.raiz == null) 
                    return null;
            else 
                    return localizar(this.raizArbol(), dato);
    }

    public Nodo buscarIterador(Object buscado) {
            int Saltos = 0;
            Comparador dato; 
            boolean encontrado = false;
            Nodo raizSub =this.raiz;
            dato = (Comparador) buscado;
            while(!encontrado && raizSub != null) {
                    if(dato.igualQue(raizSub.getContent())) {
                            encontrado = true;
                    } else if(dato.menorQue(raizSub.getContent())) {
                            Saltos += 1;
                            raizSub = raizSub.getIzquierda();
                    } else {
                            Saltos += 1;
                            raizSub = raizSub.getDerecha();
                    }
            }
            JOptionPane.showMessageDialog(null, "La cantidad de nodos visitados son: " + Saltos);
            return raizSub;
    }

    public Nodo localizar(Nodo raizSub, Comparador buscado) {
            if(raizSub == null) {
                    return null;
            } else if(buscado.igualQue(raizSub.getContent())) {
                    return this.raiz;
            } else if(buscado.menorQue(raizSub.getContent())) {
                    return localizar(raizSub.getIzquierda(), buscado);
            } else {
                    return localizar(raizSub.getDerecha(), buscado);
            }
    }

    public void insertar(Object valor) throws Exception {
            Comparador dato;
            dato = (Comparador) valor;
            this.raiz = insertar(this.raiz, dato);
    }

    private Nodo insertar(Nodo raizSub, Comparador dato) throws Exception {
            if(raizSub == null)
                    raizSub = new Nodo(dato);
            else if(dato.menorQue(raizSub.getContent())) {
                    Nodo iz;
                    iz = insertar(raizSub.getIzquierda(), dato);
                    raizSub.setIzquierda(iz);
            } else if(dato.mayorQue(raizSub.getContent())) {
                    Nodo dr;
                    dr = insertar(raizSub.getDerecha(), dato);
                    raizSub.setDerecha(dr);
            } else {
                    throw new Exception("Nodo duplicado");
            }
            return raizSub;
    }

    public void eliminar(Object valor) throws Exception {
            Comparador dato;
            dato = (Comparador) valor;
            this.raiz = eliminar(this.raiz, dato);
    }

    private Nodo eliminar(Nodo raizSub, Comparador dato) throws Exception {
            if(raizSub == null) {
                    throw new Exception("No encontrado el nodo con la clave.");
            } else if(dato.menorQue(raizSub.getContent())) {
                    Nodo iz;
                    iz = eliminar(raizSub.getIzquierda(), dato);
                    raizSub.setIzquierda(iz);
            } else if(dato.mayorQue(raizSub.getContent())) {
                    Nodo dr;
                    dr = eliminar(raizSub.getDerecha(), dato);
                    raizSub.setDerecha(dr);
            } else {
                    Nodo q;
                    q = raizSub;
                    if(q.getIzquierda() == null) 
                            raizSub = q.getDerecha();
                    else if(q.getDerecha() == null)
                            raizSub = q.getIzquierda();
                    else 
                            q = remplazar(q);

                    q = null;
            }
            return raizSub;
    }

    private Nodo remplazar(Nodo act) {
            Nodo a, p;

            p = act;
            a = act.getIzquierda();

            while(a.getDerecha() != null) {
                    p = a;
                    a = a.getDerecha();
            }

            act.setContent(a.getContent());

            if(p == act) {
                    p.setIzquierda(a.getIzquierda());
            } else {
                    p.setDerecha(a.getIzquierda());
            }

            return a;
    }
    
    public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
    
}
