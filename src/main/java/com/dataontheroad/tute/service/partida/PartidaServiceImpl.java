package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.partida.EstadoPartidaEnum;
import com.dataontheroad.tute.domain.partida.Partida;
import com.dataontheroad.tute.domain.partida.Ronda;
import com.dataontheroad.tute.service.cartas.BarajaServiceImpl;
import com.dataontheroad.tute.service.jugador.JugadorServiceImpl;
import com.google.gson.Gson;

import java.util.Comparator;
import java.util.List;

public class PartidaServiceImpl implements PartidaService {

    @Override
    public Partida crearPartida(List<Jugador> jugadorList) {
        Partida partida = new Partida(jugadorList);
        partida.setEstadoPartida(EstadoPartidaEnum.INICIALIZADA);
        return new Partida(jugadorList);
    }

    @Override
    public void ejecutarPartida(Partida partida) {
        RondaService rondaService = new RondaServiceImpl();
        Ronda ronda;
        int numRonda = 0;
        Jugador jugadorActivo = generarJugadorInicialDeLaPrimeraRonda(partida);
        Carta cartaMuestra = partida.getMesa().getCartaMuestra();
        partida.setEstadoPartida(EstadoPartidaEnum.EN_CURSO);

        do {
            int jugadorCount = 0;
            ronda = new Ronda();
            ronda.setJugadorInicial(jugadorActivo);

            do {
                (new RondaServiceImpl()).jugadorJuegaCarta(ronda, jugadorActivo, jugadorActivo.getMano().get(0), cartaMuestra);
                jugadorCount++;
                jugadorActivo = getSiguienteJugadorActivo(partida, jugadorActivo);
            } while (jugadorCount < partida.getMesa().getJugadorList().size());

            jugadorActivo = rondaService.finalizarRonda(partida.getMesa(), ronda);
            esLaUltimaRonda(partida, rondaService, ronda);
            numRonda++;
        } while (!partida.getMesa().getJugadorList().get(0).getMano().isEmpty());

        partida.setNumRonda(numRonda);
    }

    @Override
    public void cierrePartida(Partida partida) {
        partida.setEstadoPartida(EstadoPartidaEnum.FINALIZADA);
        partida.setJugadorGanador(getJugadorGanador(partida));
        partida.setResumenPartida((new Gson()).toJson(partida));
    }

    private static Jugador getJugadorGanador(Partida partida) {
        return partida.getMesa().getJugadorList().stream().max(Comparator.comparing(Jugador::getPuntuacion)).get();
    }

    private static boolean esLaUltimaRonda(Partida partida, RondaService rondaService, Ronda ronda) {
        if (partida.getMesa().getBaraja().getListaCartasBaraja().size() + 1
                < partida.getMesa().getJugadorList().size())
            return true;
        return rondaService.iniciarRonda(partida.getMesa(), ronda, new BarajaServiceImpl(), new JugadorServiceImpl())
                || !partida.getMesa().getJugadorList().get(0).getMano().isEmpty();
    }

    private static Jugador getSiguienteJugadorActivo(Partida partida, Jugador jugadorActivo) {
        return partida.getMesa().getJugadorList().get((partida.getMesa().getJugadorList().indexOf(jugadorActivo) + 1) % partida.getMesa().getJugadorList().size());
    }

    private static Jugador generarJugadorInicialDeLaPrimeraRonda(Partida partida) {
        return partida.getMesa().getJugadorList().get((int) (Math.random() * partida.getMesa().getJugadorList().size()));
    }
}
