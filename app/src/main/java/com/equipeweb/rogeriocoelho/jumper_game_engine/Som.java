package com.equipeweb.rogeriocoelho.jumper_game_engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.equipeweb.rogeriocoelho.jumper_game.R;

/**
 * Created by rogeriocoelho on 06/05/15.
 */
public class Som {

    private SoundPool soundPool;
    public static int PULO;

    public Som(Context context) {
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = soundPool.load(context, R.raw.pulo, 0);
    }

    public void toca(int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }
}
