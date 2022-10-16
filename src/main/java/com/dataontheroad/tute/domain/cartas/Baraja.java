package com.dataontheroad.tute.domain.cartas;

import java.util.ArrayList;
import java.util.List;

public class Baraja {

    private List<Carta> listaCartasBaraja = new ArrayList<>();

    public Baraja() {
        for (CartaEnum palo : CartaEnum.values()) {
            for (int i = 1; i <= 12; i++) {
                if (i != 8 && i != 9) {
                    Carta carta = new Carta(palo, i);
                    listaCartasBaraja.add(carta);
                }
            }
        }
    }

    public List<Carta> getListaCartasBaraja() {
        return listaCartasBaraja;
    }

    public void setListaCartasBaraja(List<Carta> listaCartasBaraja) {
        this.listaCartasBaraja = listaCartasBaraja;
    }
}
