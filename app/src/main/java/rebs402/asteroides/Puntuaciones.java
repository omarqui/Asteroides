package rebs402.asteroides;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Usuario on 16/7/2017.
 */

public class Puntuaciones extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);
//        setListAdapter(new ArrayAdapter(this,R.layout.elemento_lista,R.id.titulo,MainActivity.almacen.listaPuntuaciones(10)));
        setListAdapter(new MiAdaptador(this,MainActivity.almacen.listaPuntuaciones(20)));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = getListAdapter().getItem(position);
        Toast.makeText(this,"Seleccion: "+Integer.toString(position)+"-"+ o.toString(),Toast.LENGTH_SHORT).show();
    }
}
