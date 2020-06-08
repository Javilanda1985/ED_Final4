package Final4;

public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo raizArbol() {
        return raiz;
    }

    // Comprueba el estatus del árbol
    boolean esVacio() {
        return raiz == null;
    }

    // ...
    public static Nodo nuevoArbol(Nodo ramaIzqda, Object dato, Nodo ramaDrcha) {
        return new Nodo(ramaIzqda, dato, ramaDrcha);
    }

    // Recorrido de un árbol binario en preorden
    public static void preorden(Nodo r) {
        if (r != null) {
            r.visitar();
            preorden(r.subarbolIzdo());
            preorden(r.subarbolDcho());
        }
    } // Recorrido de un árbol binario en inorden

    public static void inorden(Nodo r) {
        if (r != null) {
            inorden(r.subarbolIzdo());
            r.visitar();
            inorden(r.subarbolDcho());
        }
    } // Recorrido de un árbol binario en postorden

    public static void postorden(Nodo r) {
        if (r != null) {
            postorden(r.subarbolIzdo());
            postorden(r.subarbolDcho());
            r.visitar();
        }
    }

    public static int numNodos(Nodo raiz) {
        if (raiz == null)
            return 0;
        else
            return 1 + numNodos(raiz.subarbolIzdo()) + numNodos(raiz.subarbolDcho());
    }

    public static int altura(Nodo raiz) {
        if (raiz == null)
            return 0;
        else {
            int alturaIz = altura(raiz.subarbolIzdo());
            int alturaDr = altura(raiz.subarbolDcho());
            if (alturaIz > alturaDr)
                return alturaIz + 1;
            else
                return alturaDr + 1;
        }
    }

    public static boolean arbolLleno(Nodo raiz) {
        if (raiz == null)
            return true;
        else if (altura(raiz.subarbolIzdo()) != altura(raiz.subarbolDcho()))
            return false;
        return arbolLleno(raiz.subarbolIzdo()) && arbolLleno(raiz.subarbolDcho());
    }

    public static ArbolBinario copiaArbol(Nodo raiz) {
        Nodo raizCopia;
        if (raiz == null)
            raizCopia = null;
        else {
            ArbolBinario izdoCopia, dchoCopia;
            izdoCopia = copiaArbol(raiz.subarbolIzdo());
            dchoCopia = copiaArbol(raiz.subarbolDcho());
            raizCopia = new Nodo(izdoCopia.raizArbol(), raiz.valorNodo(), dchoCopia.raizArbol());
        }
        return new ArbolBinario(raizCopia);
    }

    public static double evaluar(Nodo raiz, double[] operandos) throws Exception {
        double x, y, valor;
        char ch;
        Character nr;
        valor = 0.0;
        if (raiz != null) { // no está vacío
            nr = (Character) raiz.valorNodo();
            ch = nr.charValue();
            if (ch >= 'A' && ch <= 'Z')
                return operandos[ch - 'A'];
            else {
                x = evaluar(raiz.subarbolIzdo(), operandos);
                y = evaluar(raiz.subarbolDcho(), operandos);

                switch (ch) {
                    case '+':
                        valor = x + y;
                        break;
                    case '-':
                        valor = x - y;
                        break;
                    case '*':
                        valor = x * y;
                        break;
                    case '/':
                        if (y != 0)
                            valor = x / y;
                        else
                            throw new Exception("Error: división por 0");
                        break;
                    case '^':
                        valor = Math.pow(x, y);
                }
            }
        }
        return valor;
    }

}
