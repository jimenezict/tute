package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.domain.jugador.Jugador;
import com.dataontheroad.tute.service.jugador.PrimeraCartaDeLaManoStrategy;
import org.junit.jupiter.api.Test;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorJugardor;
import static com.dataontheroad.tute.experimento.service.ExperimentoColectivoExecutor.executar;

import java.util.List;

class ExperimentoColectivoExecutorTest {

    @Test
    public void ExperimentoColectivoExecutor() {

        List<Jugador> jugadorList = creadorJugardor(4, (new PrimeraCartaDeLaManoStrategy()));
        ExperimentoColectivoExecutor experimentoColectivoExecutor = new ExperimentoColectivoExecutor();
        executar(100, jugadorList);

    }

}