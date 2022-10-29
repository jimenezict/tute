package com.dataontheroad.tute.juego.service.partida;

import com.dataontheroad.tute.juego.domain.cartas.Carta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;

public class CartaMasAltaHelper {

    public static boolean cartaMasAlta(Carta cartaMasAlta, Carta cartaMuestra, Carta carta) {
        if(isNull(cartaMasAlta)) return true;
        if(carta.getPalo().equals(cartaMuestra.getPalo())) {
            return valorPonderado(carta.getNumero(), cartaMasAlta.getNumero()) ? true : false;
        } else if (carta.getPalo().equals(cartaMasAlta.getPalo())) {
            return valorPonderado(carta.getNumero(), cartaMasAlta.getNumero()) ? true : false;
        } else {
            return false;
        }
    }

    private static boolean valorPonderado(int carta1, int carta2) {
        List<Integer> miLista = new ArrayList<Integer>(Arrays.asList(1,3,10,11,12,2,4,5,6,7));
        return miLista.indexOf(Integer.valueOf(carta1)) < miLista.indexOf(Integer.valueOf(carta2));


    }


}
