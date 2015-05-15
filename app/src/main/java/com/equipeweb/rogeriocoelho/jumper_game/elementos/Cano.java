package com.equipeweb.rogeriocoelho.jumper_game.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.equipeweb.rogeriocoelho.jumper_game.R;
import com.equipeweb.rogeriocoelho.jumper_game.graficos.Cores;
import com.equipeweb.rogeriocoelho.jumper_game.graficos.Tela;

/**
 * Created by rogeriocoelho on 25/03/15.
 */
public class Cano {

    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;

    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private Tela tela;
    private int posicao;
    private final Paint verde = Cores.getCorDoCano();
    private Bitmap canoInferior;
    private Bitmap canoSuperior;

    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();

        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp,LARGURA_DO_CANO,this.alturaDoCanoInferior,false);
        this.canoSuperior = Bitmap.createScaledBitmap(bp,LARGURA_DO_CANO,this.alturaDoCanoSuperior,false);

    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao()
    {
        return posicao;
    }

    private int valorAleatorio()
    {
        return (int) (Math.random() * 150);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        //canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), verde);
        canvas.drawBitmap(canoInferior,posicao,alturaDoCanoInferior,null);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
        //canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, verde);
        canvas.drawBitmap(canoSuperior,posicao,0,null);

    }

    public void move() {
        posicao -= 5;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {



        return passaro.getAltura() - passaro.RAIO < this.alturaDoCanoSuperior
               || passaro.getAltura() + passaro.RAIO > this.alturaDoCanoInferior;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {

        return this.posicao - passaro.X < passaro.RAIO;
    }

}

