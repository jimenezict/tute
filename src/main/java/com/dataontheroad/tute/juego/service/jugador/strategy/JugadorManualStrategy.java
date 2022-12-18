package com.dataontheroad.tute.juego.service.jugador.strategy;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.domain.partida.Ronda;

import java.util.Scanner;

public class JugadorManualStrategy extends StrategyAbstract {
    @Override
    public Carta jugarCarta(Ronda ronda, Carta cartaMuestra, Jugador jugador) {
        visualizaPartida(ronda, cartaMuestra);
        return escogeCarta(jugador);
    }

    private Carta escogeCarta(Jugador jugador) {
        Scanner lectura = new Scanner (System.in);
        jugador.getMano().forEach(carta -> {
          System.out.println("Carta: {}" + carta.toString());
        });

        return jugador.getMano().get(lectura.nextInt());
    }

    private static void visualizaPartida(Ronda ronda, Carta cartaMuestra) {
        System.out.println("Carta Muestra: " + cartaMuestra.toString());
        System.out.println("Carta Mas Alta de la Ronda: " + ronda.getCartaMasAlta().toString());
    }
}
