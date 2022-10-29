package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.service.jugador.PrimeraCartaDeLaManoStrategy;
import org.junit.jupiter.api.Test;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorJugardor;
import static com.dataontheroad.tute.experimento.service.ExperimentoColectivoExecutor.executar;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class ExperimentoColectivoExecutorTest {

    @Test
    public void ExperimentoColectivoExecutor() {

        List<Jugador> jugadorList = creadorJugardor(4, (new PrimeraCartaDeLaManoStrategy()));
        ExperimentoColectivoExecutor experimentoColectivoExecutor = new ExperimentoColectivoExecutor();
        ExperimentoColectivo experimentoColectivo = executar(1000, jugadorList);

        assertEquals(4, experimentoColectivo.getNumeroDeJugadores());
        assertEquals(1000, experimentoColectivo.getListaDeResultados().get(0).size());

    }

}