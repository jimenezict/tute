package com.dataontheroad.tute.juego.service.jugador.helper;

import com.dataontheroad.tute.juego.domain.cartas.Carta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrategyHelper {

    public static Carta cartaMenorPeso(Carta cartaMuestra, List<Carta> mano) {
        Carta cartaMenor = mano.get(0);
        for(Carta carta : mano) {
            if(!valorPonderado(carta, cartaMenor, cartaMuestra)) {
                cartaMenor = carta;
            }
        }
        return cartaMenor;
    }

    private static boolean valorPonderado(Carta carta1, Carta carta2, Carta cartaMuestra) {
        List<Integer> miLista = new ArrayList<>(Arrays.asList(1,3,12,11,10,7,6,5,4,2));
        return miLista.indexOf(Integer.valueOf(carta1)) < miLista.indexOf(Integer.valueOf(carta2));
    }

    private int sumaDocenaSi
}
