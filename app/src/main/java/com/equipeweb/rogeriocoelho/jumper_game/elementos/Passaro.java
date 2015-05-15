package com.equipeweb.rogeriocoelho.jumper_game.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.equipeweb.rogeriocoelho.jumper_game.R;
import com.equipeweb.rogeriocoelho.jumper_game.graficos.Cores;
import com.equipeweb.rogeriocoelho.jumper_game.graficos.Tela;
import com.equipeweb.rogeriocoelho.jumper_game_engine.Som;

/**
 * Created by rogeriocoelho on 25/03/15.
 */
public class Passaro {

    public static final int X = 100;
    public static final int RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private Tela tela;
    private Bitmap passaro;
    private Som som;

    private int altura;

    public Passaro(Tela tela, Context context, Som som) {
        this.som = som;
        this.tela = tela;
        this.altura = 450;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if(!chegouNoChao) {
            altura += 5;
        }
    }

    public void pula() {
        if(altura > RAIO) {
            som.toca(Som.PULO);
            altura -= 150;
        }
    }

    public int getAltura()
    {
        return altura;
    }
    public void desenhaNo(Canvas canvas) {
        canvas.drawBitmap(passaro,X - RAIO,altura - RAIO,null);
        //canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }
}
