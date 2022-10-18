package com.dataontheroad.tute.service.partida;

import com.dataontheroad.tute.domain.cartas.Carta;
import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.domain.partida.Partida;
import com.dataontheroad.tute.domain.partida.Ronda;
import com.dataontheroad.tute.service.cartas.BarajaService;
import com.dataontheroad.tute.service.cartas.BarajaServiceImpl;
import com.dataontheroad.tute.service.jugador.JugadorService;
import com.dataontheroad.tute.service.jugador.JugadorServiceImpl;
import com.dataontheroad.tute.service.mesa.MesaService;
import com.dataontheroad.tute.service.mesa.MesaServiceImpl;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class PartidaServiceImpl implements PartidaService {

    Logger logger = getLogger(PartidaServiceImpl.class);

    @Override
    public Partida crearPartida(List<Jugador> jugadorList) {
        return new Partida(jugadorList);
    }

    @Override
    public void ejecutarPartida(Partida partida) {
        int jugadorCount, rondaCount = 0;
        RondaService rondaService = new RondaServiceImpl();
        Ronda ronda;
        Jugador jugadorActivo = generarJugadorInicialDeLaPrimeraRonda(partida);
        Carta cartaMuestra = partida.getMesa().getCartaMuestra();

        do {
            logger.info("Empezando Ronda: " + rondaCount);
            jugadorCount = 0;
            ronda = new Ronda();
            ronda.setJugadorInicial(jugadorActivo);
            rondaCount++;

            do {
                logger.info("Jugador Numero: " + jugadorCount + " con id: " + jugadorActivo.getId() + "");
                (new RondaServiceImpl()).jugadorJuegaCarta(ronda, jugadorActivo,jugadorActivo.getMano().get(0), cartaMuestra);
                jugadorCount ++;
                jugadorActivo = getSiguienteJugadorActivo(partida, jugadorActivo);
            } while (jugadorCount < partida.getMesa().getJugadorList().size());

            rondaService.finalizarRonda(partida.getMesa(), ronda);
            jugadorActivo = ronda.getJugadorGanador();
            logger.info("Terminando Ronda: " + (int) (rondaCount - 1));
        } while (rondaService.iniciarRonda(partida.getMesa(), ronda, new BarajaServiceImpl(), new JugadorServiceImpl()) && !partida.getMesa().getJugadorList().get(0).getMano().isEmpty());

        partida.getMesa();
    }

    private static Jugador getSiguienteJugadorActivo(Partida partida, Jugador jugadorActivo) {
        return partida.getMesa().getJugadorList().get((partida.getMesa().getJugadorList().indexOf(jugadorActivo) + 1) % partida.getMesa().getJugadorList().size());
    }

    private static Jugador generarJugadorInicialDeLaPrimeraRonda(Partida partida) {
        return partida.getMesa().getJugadorList().get((int) (Math.random() * partida.getMesa().getJugadorList().size()));
    }
}
