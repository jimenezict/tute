package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.juego.service.jugador.strategy.CualquierCartaDeLaManoAleatoriamenteStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.PrimeraCartaDeLaManoStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.UltimaCartaQuePuedeGanarSinoAleatorioStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.UltimaCartaQuePuedeGanarSinoMenorValorStrategy;
import org.junit.jupiter.api.Test;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorListaJugardoresPartidaConLaMismaEstrategia;
import static com.dataontheroad.tute.experimento.service.ExperimentoColectivoExecutor.executar;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class ExperimentoColectivoExecutorTest {

    private static final int NUMERO_JUGADORES =4;
    private static final int NUMERO_EXPERIMENTOS =10000;

    @Test
    void ExperimentoColectivoExecutorPrimeraCartaDeLaManoStrategy() {

        List<Jugador> jugadorList = creadorListaJugardoresPartidaConLaMismaEstrategia(NUMERO_JUGADORES, (new PrimeraCartaDeLaManoStrategy()));
        ExperimentoColectivo experimentoColectivo = executar(NUMERO_EXPERIMENTOS, jugadorList);

        assertEquals(NUMERO_JUGADORES, experimentoColectivo.getNumeroDeJugadores());
        assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getNumeroDeExperimentos());

        for(int i=0; i < NUMERO_JUGADORES; i++) {
            assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getListaDeResultados().get(i).size());
        }
    }

    @Test
    void ExperimentoColectivoExecutorCualquierCartaDeLaMano() {

        List<Jugador> jugadorList = creadorListaJugardoresPartidaConLaMismaEstrategia(NUMERO_JUGADORES, (new PrimeraCartaDeLaManoStrategy()));
        jugadorList.get(0).setStrategy((new CualquierCartaDeLaManoAleatoriamenteStrategy()));
        ExperimentoColectivo experimentoColectivo = executar(NUMERO_EXPERIMENTOS, jugadorList);

        assertEquals(NUMERO_JUGADORES, experimentoColectivo.getNumeroDeJugadores());
        assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getNumeroDeExperimentos());

        for(int i=0; i < NUMERO_JUGADORES; i++) {
            assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getListaDeResultados().get(i).size());
        }
    }

    @Test
    void ExperimentoColectivoExecutorUltimaCartaQuePuedeGanarSinoAleatorio() {

        List<Jugador> jugadorList = creadorListaJugardoresPartidaConLaMismaEstrategia(NUMERO_JUGADORES, (new PrimeraCartaDeLaManoStrategy()));
        jugadorList.get(0).setStrategy((new UltimaCartaQuePuedeGanarSinoAleatorioStrategy()));
        ExperimentoColectivo experimentoColectivo = executar(NUMERO_EXPERIMENTOS, jugadorList);

        assertEquals(NUMERO_JUGADORES, experimentoColectivo.getNumeroDeJugadores());
        assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getNumeroDeExperimentos());

        for(int i=0; i < NUMERO_JUGADORES; i++) {
            assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getListaDeResultados().get(i).size());
        }
    }

    @Test
    void ExperimentoColectivoUltimaCartaQuePuedeGanarSinoMenorValorStrategy() {

        List<Jugador> jugadorList = creadorListaJugardoresPartidaConLaMismaEstrategia(NUMERO_JUGADORES, (new PrimeraCartaDeLaManoStrategy()));
        jugadorList.get(0).setStrategy((new UltimaCartaQuePuedeGanarSinoMenorValorStrategy()));
        ExperimentoColectivo experimentoColectivo = executar(NUMERO_EXPERIMENTOS, jugadorList);

        assertEquals(NUMERO_JUGADORES, experimentoColectivo.getNumeroDeJugadores());
        assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getNumeroDeExperimentos());

        for(int i=0; i < NUMERO_JUGADORES; i++) {
            assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getListaDeResultados().get(i).size());
        }
    }

}