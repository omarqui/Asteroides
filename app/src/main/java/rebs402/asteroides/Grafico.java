package rebs402.asteroides;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by Usuario on 23/7/2017.
 */

public class Grafico {
    private Drawable drawable;  //Imagen a dibujar
    private int cenX, cenY;  //Pocision central
    private double incX, incY;  //velocidad movimiento
    private int angulo, rotacion; //angulo y velocidad de rotacion
    private int ancho, alto; //tamaños
    private int radioColicion;
    private int radioInval;
    private int xAnterior, yAnterior;

    private View view;

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public double getCenX() {
        return cenX;
    }

    public void setCenX(int cenX) {
        if (cenX < ancho/2)
            Log.d(TAG, "setCenX: Hola");
        this.cenX = cenX + ancho / 2;
    }

    public double getCenY() {
        return cenY;
    }

    public void setCenY(int cenY) {
        if (cenY < alto/2)
            Log.d(TAG, "setCenX: Hola");
        this.cenY = cenY + alto / 2;
    }

    public double getIncX() {
        return incX;
    }

    public void setIncX(double incX) {
        this.incX = incX;
    }

    public double getIncY() {
        return incY;
    }

    public void setIncY(double incY) {
        this.incY = incY;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public int getRotacion() {
        return rotacion;
    }

    public void setRotacion(int rotacion) {
        this.rotacion = rotacion;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getRadioColicion() {
        return radioColicion;
    }

    public void setRadioColicion(int radioColicion) {
        this.radioColicion = radioColicion;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getRadioInval() {
        return radioInval;
    }

    public void setRadioInval(int radioInval) {
        this.radioInval = radioInval;
    }

    public int getxAnterior() {
        return xAnterior;
    }

    public void setxAnterior(int xAnterior) {
        this.xAnterior = xAnterior;
    }

    public int getyAnterior() {
        return yAnterior;
    }

    public void setyAnterior(int yAnterior) {
        this.yAnterior = yAnterior;
    }

    public static final int MAX_VELOCIDAD = 20;

    public Grafico(View view, Drawable drawable){
        this.drawable = drawable;
        this.view = view;

        ancho = drawable.getIntrinsicWidth();
        alto = drawable.getIntrinsicHeight();

        radioColicion = (ancho + alto)/4;
        radioInval = (int)Math.hypot(ancho/2,alto/2);
    }

    public void dibujarGrafico(Canvas canvas){
        int x = cenX -(ancho/2);
        int y = cenY -(alto/2);
        drawable.setBounds(x,y,x+ancho,y+alto);

        canvas.save();


        canvas.rotate(angulo,cenX,cenY);

        drawable.draw(canvas);
        canvas.restore();

//        int rInval = (int) Math.hypot(alto,ancho)/2+MAX_VELOCIDAD;
//        view.invalidate(x-rInval,y-rInval,x+rInval,y+rInval);
        view.invalidate(cenX-radioInval,cenY-radioInval,cenX+radioInval,cenY+radioInval);
        view.invalidate(xAnterior -radioInval, yAnterior - radioInval, xAnterior +radioInval, yAnterior +radioInval);
        xAnterior = cenX;
        yAnterior = cenY;
    }

    public void incrementarPos(double factor){
        cenX +=incX * factor;
        if (cenX < -ancho/2)
            cenX = view.getWidth()-ancho/2;

        if (cenX >view.getWidth()-ancho/2)
            cenX = -ancho/2;

        cenY +=incY * factor;
        if (cenY < -alto/2)
            cenY = view.getHeight()-alto/2;

        if (cenY > view.getHeight()-alto/2)
            cenY = -alto/2;

        angulo += rotacion * factor;
    }

    public double distancia(Grafico g){
        return Math.hypot(cenX -g.cenX, cenY -g.cenY);
    }

    public boolean verificarColision(Grafico g){
        return (distancia(g) < (radioColicion + g.radioColicion));
    }
}
