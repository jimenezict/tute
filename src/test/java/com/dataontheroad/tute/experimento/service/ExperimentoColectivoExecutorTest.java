package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.juego.service.jugador.PrimeraCartaDeLaManoStrategy;
import org.junit.jupiter.api.Test;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorListaJugardoresPartidaConLaMismaEstrategia;
import static com.dataontheroad.tute.experimento.service.ExperimentoColectivoExecutor.executar;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class ExperimentoColectivoExecutorTest {

    private static final int NUMERO_JUGADORES =4;
    private static final int NUMERO_EXPERIMENTOS =1000;

    @Test
    public void ExperimentoColectivoExecutor() {

        List<Jugador> jugadorList = creadorListaJugardoresPartidaConLaMismaEstrategia(NUMERO_JUGADORES, (new PrimeraCartaDeLaManoStrategy()));
        ExperimentoColectivo experimentoColectivo = executar(NUMERO_EXPERIMENTOS, jugadorList);

        assertEquals(NUMERO_JUGADORES, experimentoColectivo.getNumeroDeJugadores());
        assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getNumeroDeExperimentos());

        for(int i=0; i < NUMERO_JUGADORES; i++) {
            assertEquals(30, experimentoColectivo.getListaMedias().get(i), 2.5);
            assertEquals(NUMERO_EXPERIMENTOS, experimentoColectivo.getListaDeResultados().get(i).size());
            assertEquals(NUMERO_EXPERIMENTOS / NUMERO_JUGADORES, experimentoColectivo.getListaGanadores().get(i), 20);
        }
    }

}