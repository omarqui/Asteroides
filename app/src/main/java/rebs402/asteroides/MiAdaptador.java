package rebs402.asteroides;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by Usuario on 17/7/2017.
 */

public class MiAdaptador extends BaseAdapter {

    private final Activity actividad;
    private final Vector lista;

    public MiAdaptador(Activity pActividad, Vector pVector){
        super();
        actividad = pActividad;
        lista = pVector;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.elementAt(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elemento_lista,null,true);
        TextView tvTitulo = (TextView)view.findViewById(R.id.titulo);
        tvTitulo.setText(lista.elementAt(position).toString());
        ImageView imagen = (ImageView)view.findViewById(R.id.icono);
        switch (Math.round((float)Math.random()*3)){
            case 0:
                imagen.setImageResource(R.drawable.asteroide1);
                break;
            case 1:
                imagen.setImageResource(R.drawable.asteroide2);
                break;
            default:
                imagen.setImageResource(R.drawable.asteroide3);
                break;
        }

        return view;
    }
}
