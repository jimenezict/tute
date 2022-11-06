package com.dataontheroad.tute.juego.service.jugador;

import com.dataontheroad.tute.juego.domain.cartas.Carta;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorService {

    private JugadorService() {
        throw new IllegalStateException("Utility class");
    }

    public static void ganarMano(Jugador jugador, List<Carta> cartaList) {
        jugador.getDescartes().addAll(cartaList);
        jugador.setPuntuacion(
                jugador.getPuntuacion()
                + cartaList.stream().mapToInt(JugadorService::calcularPuntuacion).sum()
        );
    }


    public static boolean robarCarta(Jugador jugador, Carta carta) {
        if(jugador.getMano().size() < 3) {
            jugador.getMano().add(carta);
            return true;
        }
        return false;
    }

    public static boolean tirarCarta(Jugador jugador, Carta carta) {
        if(jugador.getMano().contains(carta)) {
            jugador.getMano().remove(carta);
            return true;
        }
        return false;
    }

    public static void inicializarJugadorPartida(Jugador jugador) {
        jugador.setPuntuacion(0);
        jugador.setMano(new ArrayList<>());
        jugador.setDescartes(new ArrayList<>());
    }

    private static int calcularPuntuacion(Carta carta) {
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
