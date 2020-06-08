package Final4;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    static Scanner input;
    static String a1 = "";
    static String str[] = new String[19];
    static int i = 0;

    static ArbolBinarioBusqueda zw = new ArbolBinarioBusqueda();
    static BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
    static Estudiantes std;
    static String temp;

    private static void readPrintLine() {
        String line = input.nextLine();
        a1 = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            String a = Character.toString(c);
            a1 = a1 + a;
        }
        str[i] = a1;
    }
    public static void main(String[] a) {
        int nm;
        Random r;
        r = new Random(413);
        final int Mx = 999;
        try {
            input = new Scanner(new File("alumnos.txt"));
            for (i = 0; i < 19; i++) {
                readPrintLine();
                int a1 = r.nextInt(Mx) + 1;
                std = new Estudiantes(Menu.a1, a1);
                zw.insertar(std);
            }
            for (i = 0; i < 19; i++) {
                for (int j = i + 1; j < 19; j++) {
                    if (str[i].compareTo(str[j]) > 0) {
                        temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                    }
                }
            }
            do {
                System.out.println("1. Mostrar el  Árbol");
                System.out.println("2. Eliminar un estudiante");
                System.out.println("3. Ordenado");
                System.out.println("4. Salir");

                do
                    nm = Integer.parseInt(entry.readLine());
                while (nm < 1 || nm > 4);
                if (nm == 1) {
                    System.out.println("Estudiantes");
                    ArbolBinario.inorden(zw.raizArbol()) ;
                    System.out.print("\n \n preorden \n");
                    ArbolBinario.preorden(zw.raizArbol());



                } else if (nm == 2) {
                    int nmt;
                    System.out.print("Matricula: ");
                    nmt = Integer.parseInt(entry.readLine());
                    try {
                        zw.eliminar(new Estudiantes(null, nmt));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else if (nm == 3) {
                    for (int i = 0; i <= 19 - 1; i++) {
                        System.out.print(str[i] + ", \n");
                    }

                }
            } while (nm != 4);
        } catch (Exception er) {
            er.printStackTrace();
        }
    }
    static void visualizar(Nodo r) {
        if (r != null) {
            visualizar(r.subArbolIzquierdo());
            System.out.println(r.valorNodo());
            visualizar(r.subArbolDerecho());
        }
    }
    public static void searchMax(Nodo n) {

        if (n != null) {

        }

    }

}