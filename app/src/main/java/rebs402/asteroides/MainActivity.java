package rebs402.asteroides;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAcercaDe;
    private Button btnConfiguracion;
    private Button btnSalir;
    private Button btnPuntuaciones;
    private TextView tvTitulo;

    public static AlmacenPuntuacionesArray almacen = new AlmacenPuntuacionesArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAcercaDe = (Button)findViewById(R.id.btnAcercaDe);
        btnSalir = (Button)findViewById(R.id.btnSalir);
        btnConfiguracion = (Button)findViewById(R.id.btnConfigurar);
        btnPuntuaciones = (Button)findViewById(R.id.btnPuntuaciones);
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);

        final Animation animacionGiro = AnimationUtils.loadAnimation(this, R.anim.giro_con_zoom);
        Animation animacionAparecer = AnimationUtils.loadAnimation(this, R.anim.aparecer);
        Animation animacionDesplaDerecha = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_derecha);

        tvTitulo.startAnimation(animacionGiro);
        findViewById(R.id.btnJugar).startAnimation(animacionAparecer);
        btnConfiguracion.startAnimation(animacionDesplaDerecha);
        btnAcercaDe.startAnimation(animacionAparecer);
        btnPuntuaciones.startAnimation(animacionDesplaDerecha);
        btnSalir.startAnimation(animacionAparecer);

        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAcercaDe.startAnimation(animacionGiro);
                //lanzarAcercaDeActivity(null);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir(null);
            }
        });
        btnConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarPrefericias(null);
            }
        });
        btnPuntuaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarPuntuaciones(null);
            }
        });

        findViewById(R.id.btnJugar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarJugar(null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.acercaDe) {
            lanzarAcercaDeActivity(null);
            return true;
        }

        if(id == R.id.action_setting) {
            lanzarPrefericias(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void lanzarAcercaDeActivity(View view){
        Intent i = new Intent(this,AcercaDeActivity.class);
        startActivity(i);
    }

    public void salir(View view){
        finish();
    }

    public void lanzarPrefericias(View v){
        Intent i = new Intent(this,Preferencias.class);
        startActivity(i);
    }

    public void mostrarPreferencias(View v){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String s = "Musica: "+pref.getBoolean("musica",true) + ","+
                   "Graficos: "+pref.getString("graficos","?");
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }

    public void mostrarPuntuaciones(View v){
        Intent i = new Intent(this,Puntuaciones.class);
        startActivity(i);
    }

    public void lanzarJugar(View v){
        Intent i = new Intent(this,JuegoActivity.class);
        startActivity(i);
    }
}
