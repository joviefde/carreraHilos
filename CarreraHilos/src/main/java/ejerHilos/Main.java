package ejerHilos;

import java.util.Scanner;
import ejerHilos.carrera.Caballo;

public class Main {
    public static Scanner TECLADO=new Scanner(System.in);

    public static void main(String[] args) {

        Caballo.Correr(TECLADO);
    }
}
