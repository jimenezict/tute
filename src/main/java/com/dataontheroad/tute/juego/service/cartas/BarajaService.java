package com.dataontheroad.tute.juego.service.cartas;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static org.springframework.util.ObjectUtils.isEmpty;

public class BarajaService {

    public static Baraja crearBaraja() {
        return new Baraja();
    }


    public static void mezclarBaraja(Baraja baraja) {
        Collections.shuffle(baraja.getListaCartasBaraja());
    }


    public static Carta cogerCartaBaraja(Baraja baraja) {
        return !isEmpty(baraja.getListaCartasBaraja()) ? baraja.getListaCartasBaraja().remove(0) : null;
    }
}
