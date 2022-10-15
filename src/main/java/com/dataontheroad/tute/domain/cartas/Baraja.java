package com.dataontheroad.tute.domain.cartas;

import java.util.*;

public class Baraja {

    private List<Carta> baraja = new ArrayList<Carta>();

    public Baraja() {
        for (CartaEnum palo : CartaEnum.values()) {
            for (int i = 1; i <= 12; i++) {
                if (i != 8 && i != 9) {
                    Carta carta = new Carta(palo, i);
                    baraja.add(carta);
                }
            }
        }
    }

    public List<Carta> getBaraja() {
        return baraja;
    }

}
