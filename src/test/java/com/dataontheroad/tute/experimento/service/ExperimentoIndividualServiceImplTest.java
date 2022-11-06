package com.dataontheroad.tute.experimento.service;

import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.experimento.domain.ExperimentoIndividual;
import com.dataontheroad.tute.juego.service.jugador.PrimeraCartaDeLaManoStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorListaJugardoresPartidaConLaMismaEstrategia;
import static com.dataontheroad.tute.experimento.service.ExperimentoIndividualService.creaExperimentoIndividual;
import static org.junit.jupiter.api.Assertions.*;

class ExperimentoIndividualServiceImplTest {

    @Test
    void alCrearMesaDeTresJugadoresTodoEsCorrecto() {
        ArrayList<Jugador> listJugadores = creadorListaJugardoresPartidaConLaMismaEstrategia(2, (new PrimeraCartaDeLaManoStrategy()));
        ExperimentoIndividual experimentoIndividual = creaExperimentoIndividual(listJugadores);

        assertNotNull(experimentoIndividual.getJugadorGanador());
        assertEquals(2, experimentoIndividual.getNumeroJugador());
        assertEquals(2, experimentoIndividual.getResultados().length);
        assertEquals(120, Arrays.stream(experimentoIndividual.getResultados()).sum());
    }

}