package Final4;

public class Nodo {
    protected Object dato;
    protected Nodo izquierdo;
    protected Nodo derecho;

    public Nodo(Object valor){
        dato = valor;
        izquierdo = derecho = null;
    }

    public Nodo(Nodo ramaIzquierda, Object valor, Nodo ramaDerecha){
        dato = valor;
        izquierdo = ramaIzquierda;
        derecho = ramaDerecha;
    }

    public Object valorNodo(){
        return dato;
    }

    public Nodo subArbolIzquierdo(){
        return izquierdo;
    }

    public Nodo subArbolDerecho(){
        return derecho;
    }

    public void nuevoValor(Object d){
        dato = d;
    }

    public void ramaIzquierda(Nodo n){
        izquierdo = n;
    }

    public void ramaDerecha(Nodo n){
        derecho = n;
    }

    public void visitar(){
        System.out.print(dato + " ");
    }
}