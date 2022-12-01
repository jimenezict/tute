package com.dataontheroad.tute.juego.service.jugador.strategy;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Ronda;
import com.dataontheroad.tute.juego.service.partida.CartaMasAltaHelper;

import java.util.Random;

public class UltimaCartaQuePuedeGanarSinoAleatorioStrategy extends StrategyAbstract {

    @Override
    public Carta jugarCarta(Ronda ronda, Carta cartaMuestra, Jugador jugador) {
        Random r = new Random();
        Carta cartaJugada = jugador.getMano().get(r.nextInt(jugador.getMano().size()));

        for(Carta carta : jugador.getMano()) {
            if(CartaMasAltaHelper.cartaMasAlta(ronda.getCartaMasAlta(), cartaMuestra, carta)) {
                cartaJugada = carta;
            }
        }

        return cartaJugada;
    }
}
