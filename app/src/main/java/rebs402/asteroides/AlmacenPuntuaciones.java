package rebs402.asteroides;

import java.util.Vector;

/**
 * Created by Usuario on 16/7/2017.
 */

public interface AlmacenPuntuaciones {
    void guardarPuntuacion(int puntos, String nombre, long fecha);
    Vector listaPuntuaciones(int cantidad);
}
