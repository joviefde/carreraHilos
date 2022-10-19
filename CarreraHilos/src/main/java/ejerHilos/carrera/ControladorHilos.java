package ejerHilos.carrera;

class ControladorHilos extends Thread {
    private int numhilo;
    private Ventana ventana_hilo;
    private final int meta = 50;
    private ControladorResultado res;
    private int numCarrera;

    ControladorHilos(int i, ControladorResultado res, int numCarrera){
        this.numhilo = i;
        ventana_hilo = new Ventana("Caballo " + numhilo, i*300, i);
        this.res = res;
        this.numCarrera = numCarrera-1;
    }

    public void run(){
        String cadena = new String();
        int metros = 1;
        int i = 1;
        while (metros < meta){
            cadena="Soy el corredor " + numhilo + " es mi sprint " + i +  " y he recorrido " + metros + " m\n";
            ventana_hilo.escribecadena(cadena);
            try{
                sleep(1000);
            }catch(InterruptedException e) {
                System.out.println("Interrupción del hilo.");
            }
            i++;
            metros = metros + (int) (Math.random() * 20);
        }
        res.carrera[numCarrera][numhilo-1]=i;

        System.out.println("Fin del corredor "+ numhilo );
        cadena="Fin del corredor" + numhilo;
        ventana_hilo.escribecadena(cadena);

    }

}
