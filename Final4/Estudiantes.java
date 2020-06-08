package Final4;

public class Estudiantes implements Comparador {
    int nAsignature;
    String name;

    public Estudiantes(String n, int mat) {
        name = n;
        nAsignature = mat;
    }

    public Estudiantes() {
        this(null, 0);
    }

    public String toString() {
        if (name != null)
            return name + nAsignature;
        else
            return "No asignado";
    }

    public boolean menorQue(Object op2) {
        Estudiantes p2 = (Estudiantes) op2;
        return nAsignature < p2.nAsignature;
    }

    public boolean menorIgualQue(Object op2) {
        Estudiantes p2 = (Estudiantes) op2;
        return nAsignature <= p2.nAsignature;
    }

    public boolean mayorQue(Object op2) {
        Estudiantes p2 = (Estudiantes) op2;
        return nAsignature > p2.nAsignature;
    }

    public boolean mayorIgualQue(Object op2) {
        Estudiantes p2 = (Estudiantes) op2;
        return nAsignature >= p2.nAsignature;
    }

    public boolean igualQue(Object op2) {
        Estudiantes p2 = (Estudiantes) op2;
        return nAsignature == p2.nAsignature;
    }
}
