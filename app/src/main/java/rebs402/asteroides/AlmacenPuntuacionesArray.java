package rebs402.asteroides;

import java.util.Vector;

/**
 * Created by Usuario on 16/7/2017.
 */

public class AlmacenPuntuacionesArray implements AlmacenPuntuaciones {
    private Vector puntuaciones;

    public AlmacenPuntuacionesArray(){
        puntuaciones = new Vector();
        puntuaciones.add("123000 Juan Perez");
        puntuaciones.add("115000 Ramon Lopez");




        puntuaciones.add("000458 Pepe Ramiro");
        puntuaciones.add("123000 Juan Perez");
        puntuaciones.add("115000 Ramon Lopez");
        puntuaciones.add("000458 Pepe Ramiro");
        puntuaciones.add("123000 Juan Perez");
        puntuaciones.add("115000 Ramon Lopez");
        puntuaciones.add("000458 Pepe Ramiroz");
        puntuaciones.add("123000 Juan Perez");
        puntuaciones.add("115000 Ramon Lopez");
        puntuaciones.add("000458 Pepe Ramiro");
        puntuaciones.add("123000 Juan Perez");
        puntuaciones.add("115000 Ramon Lopez");
        puntuaciones.add("000458 Pepe Ramiro");

    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha) {
        puntuaciones.add(0,puntos+" "+nombre);
    }

    @Override
    public Vector listaPuntuaciones(int cantidad) {
        return puntuaciones;
    }
}
