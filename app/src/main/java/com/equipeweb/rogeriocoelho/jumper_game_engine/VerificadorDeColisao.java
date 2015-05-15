package com.equipeweb.rogeriocoelho.jumper_game_engine;

import com.equipeweb.rogeriocoelho.jumper_game.elementos.Canos;
import com.equipeweb.rogeriocoelho.jumper_game.elementos.Passaro;

/**
 * Created by rogeriocoelho on 05/05/15.
 */
public class VerificadorDeColisao {

    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {

        return canos.temColisaoCom(passaro);
    }

}
