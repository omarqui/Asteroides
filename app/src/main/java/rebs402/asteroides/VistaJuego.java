package rebs402.asteroides;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;

import java.util.Vector;

/**
 * Created by Usuario on 23/7/2017.
 */

public class VistaJuego extends View {
    private Vector<Grafico> Asteroides;
    private int numAsteroides = 5;
    private int numFragmentos = 3;
    private Grafico nave;
    private int giroNave;
    private float acelercionNave;

    private final static int PASO_GIRO_NAVE = 5;
    private static final float PASO_ACELERACION_NAVE = 0.5f;


    public VistaJuego(Context context, AttributeSet attrs) {
        super(context, attrs);
        Drawable drawableNave, drawableAsteroide, drawableMisil;

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        if (pref.getString("graficos","1").equals("0")){
//            Path pathAsteroide = new Path();
//            pathAsteroide.moveTo(0.0f,0.0f);
//            pathAsteroide.lineTo(2f,1f);
//            pathAsteroide.lineTo(0.0f,2f);
//            pathAsteroide.lineTo(0.0f,0.0f);
//            pathAsteroide.close();

            ShapeDrawable dAstro = new ShapeDrawable(new OvalShape());
//            ShapeDrawable dAstro = new ShapeDrawable(new PathShape(pathAsteroide,1,1));


//            Paint paint = new Paint();
//            Path path = new Path();
//            paint.setStyle(Paint.Style.FILL);
//            paint.setColor(Color.TRANSPARENT);
//
//            for (int i = 50; i < 100; i++) {
//                path.moveTo(i, i-1);
//                path.lineTo(i, i);
//            }
//            path.close();
//            paint.setStrokeWidth(3);
//            paint.setPathEffect(null);
//            paint.setColor(Color.BLACK);
//            paint.setStyle(Paint.Style.STROKE);


            //ShapeDrawable dAstro = new ShapeDrawable(new PathShape(path,1,1));

//            dAstro.getPaint().setColor(Color.WHITE);
//            dAstro.getPaint().setStyle(Paint.Style.STROKE);
//            dAstro.getPaint().setStrokeWidth(1);
            dAstro.getPaint().setStrokeWidth(1);
            dAstro.getPaint().setPathEffect(null);
            dAstro.getPaint().setColor(Color.WHITE);
            dAstro.getPaint().setStyle(Paint.Style.STROKE);
//            dAstro.setIntrinsicHeight(60);
//            dAstro.setIntrinsicWidth(60);

            drawableAsteroide = dAstro;
            setBackgroundColor(Color.BLACK);
        } else {
            drawableAsteroide = getResources().getDrawable(R.drawable.asteroide1);
        }


        drawableNave = getResources().getDrawable(R.drawable.nave);
        nave = new Grafico(this,drawableNave);

        Asteroides = new Vector();

        for (int i = 0; i < numAsteroides; i++){
            Grafico asteroide = new Grafico(this,drawableAsteroide);
            asteroide.setIncX(Math.random()*4-2);
            asteroide.setIncY(Math.random()*4 - 2);
            asteroide.setAngulo((int)(Math.random()*360));
            asteroide.setRotacion((int)(Math.random()*8-4));
            Asteroides.add(asteroide);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Grafico mAsteroide: Asteroides) {
            mAsteroide.dibujarGrafico(canvas);
        }
        nave.dibujarGrafico(canvas);
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        nave.setCenX((w-nave.getAncho())/2);
        nave.setCenY((h-nave.getAlto())/2);

        for (Grafico mAsteroide : Asteroides){
            do {
                mAsteroide.setCenX((int)(Math.random()*(w-mAsteroide.getAncho())));
                mAsteroide.setCenY((int)(Math.random()*(h-mAsteroide.getAlto())));
            }while (!validarDistacia(mAsteroide,(w+h)/10,true) && !validarDistacia(mAsteroide,mAsteroide.getRadioColicion(),false));
        }


    }

    private boolean validarDistacia(Grafico g, int distMinima, boolean soloNave){
        if (soloNave)
            return !(nave.distancia(g)<distMinima);
        else
            for (Grafico ast : Asteroides){
                if (ast.distancia(g)<distMinima)
                    return false;
            }

        return true;
    }
}
