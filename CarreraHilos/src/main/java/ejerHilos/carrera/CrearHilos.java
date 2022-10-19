package ejerHilos.carrera;

class CrearHilos extends Thread {
    private ControladorResultado res;
    private int numCorredores;
    private int numCarrera;

    CrearHilos(int i, ControladorResultado res, int numCorredores){
        this.numCarrera = i;
        this.res = res;
        this.numCorredores = numCorredores;
    }

    public void run(){
        res.carreras[numCarrera-1] = numCarrera;
        ControladorHilos[] corredor = new ControladorHilos[numCorredores];
        for (int i = 0; i < numCorredores; i++) {
            corredor[i] = new ControladorHilos( i+1, res, numCarrera);
            corredor[i].start();
        }

        try{
            for (int i = 0; i < numCorredores; i++) {
                corredor[i].join();
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}