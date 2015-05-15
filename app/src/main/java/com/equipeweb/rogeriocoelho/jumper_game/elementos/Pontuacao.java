package com.equipeweb.rogeriocoelho.jumper_game.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.equipeweb.rogeriocoelho.jumper_game.graficos.Cores;

/**
 * Created by rogeriocoelho on 05/05/15.
 */
public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public void desenhaNo(Canvas canvas)
    {
        canvas.drawText(String.valueOf(pontos),100,100,BRANCO);
    }

    public void aumenta()
    {
        this.pontos++;
    }
}
