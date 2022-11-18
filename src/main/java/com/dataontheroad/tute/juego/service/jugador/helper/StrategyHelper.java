package com.dataontheroad.tute.juego.service.jugador.helper;

import com.dataontheroad.tute.juego.domain.cartas.Carta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrategyHelper {

    public static Carta cartaMenorPeso(Carta cartaMuestra, List<Carta> mano) {
        int menorEvaluacion = 1000;
        Carta menorCarta = mano.get(0);

        for(Carta carta: mano) {
            int cartaEvaluacion = evaluacionCarta(carta, cartaMuestra);
            if(cartaEvaluacion < menorEvaluacion) {
                menorCarta = carta;
                menorEvaluacion = cartaEvaluacion;
            }
        }

        return menorCarta;
    }

    private static int evaluacionCarta(Carta carta, Carta cartaMuestra) {
        List<Integer> miLista = new ArrayList<>(Arrays.asList(2,4,5,6,7,10,11,12,3,1));
        return miLista.indexOf(Integer.valueOf(carta.getNumero())) + (cartaMuestra.getPalo().equals(carta.getPalo()) ? 12 : 0);
    }
}
