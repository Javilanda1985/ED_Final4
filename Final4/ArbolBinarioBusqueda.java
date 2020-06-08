package Final4;

public class ArbolBinarioBusqueda extends ArbolBinario {

    public ArbolBinarioBusqueda() {
        super();
    }

    public Nodo buscar(Object buscado) {
        Comparador dato;
        dato = (Comparador) buscado;
        if (raiz == null)
            return null;
        else
            return localizar(raizArbol(), dato);
    }

    protected Nodo localizar(Nodo raizSub, Comparador buscado) {
        if (raizSub == null)
            return null;
        else if (buscado.igualQue(raizSub.valorNodo()))
            return raiz;
        else if (buscado.menorQue(raizSub.valorNodo()))
            return localizar(raizSub.subArbolIzquierdo(), buscado);
        else
            return localizar (raizSub.subArbolDerecho(), buscado);
    }

    public Nodo buscarIterativo (Object buscado) {
        Comparador dato;
        boolean encontrado = false;
        Nodo raizSub = raiz;
        dato = (Comparador) buscado;
        while (!encontrado && raizSub != null) {
            if (dato.igualQue(raizSub.valorNodo()))
                encontrado = true;
            else if (dato.menorQue(raizSub.valorNodo()))
                raizSub = raizSub.subArbolIzquierdo();
            else
                raizSub = raizSub.subArbolDerecho();
        }
        return raizSub;
    }

    public void insertar (Object valor )throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = insertar(raiz, dato);
    }

    //método interno para realizar la operación
    protected Nodo insertar(Nodo raizSub, Comparador dato) throws Exception {
        if (raizSub == null)
            raizSub = new Nodo(dato);
        else if (dato.menorQue(raizSub.valorNodo())) {
            Nodo iz;
            iz = insertar(raizSub.subArbolIzquierdo(), dato);
            raizSub.ramaIzquierda(iz);
        }
        else if (dato.mayorQue(raizSub.valorNodo())) {
            Nodo dr;
            dr = insertar(raizSub.subArbolDerecho(), dato);
            raizSub.ramaDerecha(dr);
        }
        else
            throw new Exception("Nodo duplicado");
        return raizSub;
    }

    public void eliminar (Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = eliminar(raiz, dato);
    }

    //método interno para realizar la operación
    protected Nodo eliminar (Nodo raizSub, Comparador dato) throws Exception {
        if (raizSub == null)
            throw new Exception ("No encontrado el nodo con la clave");
        else if (dato.menorQue(raizSub.valorNodo())) {
            Nodo iz;
            iz = eliminar(raizSub.subArbolIzquierdo(), dato);
            raizSub.ramaIzquierda(iz);
        }
        else if (dato.mayorQue(raizSub.valorNodo())) {
            Nodo dr;
            dr = eliminar(raizSub.subArbolDerecho(), dato);
            raizSub.ramaDerecha(dr);
        }
        else{ // Nodo encontrado
            Nodo q;
            q = raizSub; // nodo a quitar del árbol
            if (q.subArbolIzquierdo() == null)
                raizSub = q.subArbolDerecho();
            else if (q.subArbolDerecho() == null)
                raizSub = q.subArbolIzquierdo();
            else { // tiene rama izquierda y derecha
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }

    // método interno para susutituir por el mayor de los menores
    private Nodo reemplazar(Nodo act) {
        Nodo a, p;
        p = act;
        a = act.subArbolIzquierdo(); // rama de nodos menores
        while (a.subArbolDerecho() != null) {
            p = a;
            a = a.subArbolDerecho();
        }
        act.nuevoValor(a.valorNodo());
        if (p == act)
            p.ramaIzquierda(a.subArbolIzquierdo());
        else
            p.ramaDerecha(a.subArbolIzquierdo());
        return a;
    }
}
