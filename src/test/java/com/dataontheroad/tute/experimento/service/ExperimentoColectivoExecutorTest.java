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

    @Test
    public void ExperimentoColectivoExecutor() {

        List<Jugador> jugadorList = creadorListaJugardoresPartidaConLaMismaEstrategia(4, (new PrimeraCartaDeLaManoStrategy()));
        ExperimentoColectivo experimentoColectivo = executar(1000, jugadorList);

        assertEquals(4, experimentoColectivo.getNumeroDeJugadores());
        assertEquals(1000, experimentoColectivo.getListaDeResultados().get(0).size());
        assertEquals(1000, experimentoColectivo.getNumeroDeExperimentos());

    }

}