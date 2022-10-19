package ejerHilos.carrera;

//Guardo los resultados de cada carrera
class ControladorResultado {
    int[][] carrera;
    int[] carreras;
    String[][] cadena;

    ControladorResultado(int numCorredores, int numCarrera) {
        this.carrera = new int[numCarrera][numCorredores];
        this.carreras = new int[numCarrera];
        this.cadena = new String[numCarrera][numCorredores];
    }

    void getResultados() {

        for (int t = 0; t < carreras.length; t++) {
            for (int i = 0; i < carrera.length; i++) {
                this.cadena[t][i] = "El corredor " + (i + 1) + " ha tardado: " + this.carrera[t][i] + " sprints\n";
            }
        }
    }
}
