package com.dataontheroad.tute.service;

import com.dataontheroad.tute.domain.Carta;
import com.dataontheroad.tute.domain.Jugador;

import java.util.List;

public class JugadorServiceImpl implements JugadorService {

    @Override
    public void ganarMano(Jugador jugador, List<Carta> cartaList) {
        jugador.getDescartes().addAll(cartaList);
        jugador.setPuntuacion(
                jugador.getPuntuacion()
                + calcularPuntuacion(cartaList.get(0))
                + calcularPuntuacion(cartaList.get(1))
                + calcularPuntuacion(cartaList.get(2))
        );
    }

    @Override
    public boolean robarCarta(Jugador jugador, Carta carta) {
        if(jugador.getMano().size() < 3) {
            jugador.getMano().add(carta);
            return true;
        }
        return false;
    }

    @Override
    public boolean tirarCarta(Jugador jugador, Carta carta) {
        if(jugador.getMano().contains(carta)) {
            jugador.getMano().remove(carta);
            return true;
        }
        return false;
    }

    private int calcularPuntuacion(Carta carta) {
        switch (carta.getNumero()) {
            case (1):
                return 11;
            case (3):
                return 10;
            case (10):
                return 2;
            case (11):
                return 3;
            case (12):
                return 4;
            default:
                return 0;
        }
    }
}
