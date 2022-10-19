package ejerHilos.carrera;

import javax.swing.*;
import java.util.Scanner;

public class Caballo {

    static int numCarreras;
    private static CrearHilos corredor[];
    private static int numCorredores;

    public static void Correr(Scanner TECLADO) {

        numCorredores = pedirCaballos();
        numCarreras = numCorredores;
        ControladorResultado res = new ControladorResultado(numCorredores, numCarreras);
        corredor = new CrearHilos[numCarreras];

        for (int i = 0; i < 1; i++) {
            corredor[i] = new CrearHilos(i + 1, res, numCarreras);
            corredor[i].start();
            try {
                corredor[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("¡FINAL! Llegaron los " + numCarreras + " jowkes a caballo");
        res.getResultados();
        for (int t = 0; t < 1; t++) {
            for (int i = 0; i < numCorredores; i++)
                System.out.print(res.cadena[t][i]);
        }
    }

    public static int pedirCaballos(){
       int counter, resultado;
        do{
           String corredores = JOptionPane.showInputDialog(null, "¿Cuántos caballos correrán?, [MÁXIMO 8]");
           resultado = Integer.parseInt(corredores);
           counter = resultado;
       }while(counter>8); //Máximo 8

         return resultado;
    }
}

