package com.equipeweb.rogeriocoelho.jumper_game_engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.equipeweb.rogeriocoelho.jumper_game.R;
import com.equipeweb.rogeriocoelho.jumper_game.elementos.Canos;
import com.equipeweb.rogeriocoelho.jumper_game.elementos.GameOver;
import com.equipeweb.rogeriocoelho.jumper_game.elementos.Passaro;
import com.equipeweb.rogeriocoelho.jumper_game.elementos.Pontuacao;
import com.equipeweb.rogeriocoelho.jumper_game.graficos.Tela;

/**
 * Created by rogeriocoelho on 21/03/15.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Canos canos;
    private Bitmap background;
    private Tela tela;
    private Pontuacao pontuacao;
    private Context context;
    private Som som;

    public void inicia() {
        this.isRunning = true;
    }

    public void cancela() {
        isRunning = false;
    }

    @Override
    public void run()
    {
        while(isRunning) {

            if(!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, null);
            passaro.desenhaNo(canvas);
            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);

            if(new VerificadorDeColisao(passaro, canos).temColisao()) {
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);

        }
    }

    private void inicializaElementos() {
        this.passaro = new Passaro(tela, context, som);
        this.pontuacao = new Pontuacao();
        this.canos = new Canos(tela, pontuacao, context);

        Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);

    }

    public Game(Context context) {
        super(context);
        this.context = context;
        this.tela = new Tela(context);
        this.som = new Som(context);

        setOnTouchListener(this);

        inicializaElementos();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }

}
