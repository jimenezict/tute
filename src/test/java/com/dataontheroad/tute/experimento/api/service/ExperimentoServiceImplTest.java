package com.dataontheroad.tute.experimento.api.service;

import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.juego.service.jugador.strategy.CualquierCartaDeLaManoAleatoriamenteStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.PrimeraCartaDeLaManoStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.UltimaCartaQuePuedeGanarSinoAleatorioStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.UltimaCartaQuePuedeGanarSinoMenorValorStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
class ExperimentoServiceImplTest {

    ExperimentoService experimentoService;

    @BeforeEach
    public void setUp() {
        experimentoService = new ExperimentoServiceImpl();
    }

    @Test
    public void identificadorStrategyConverter1() {
        assertThat(experimentoService.identificadorStrategyConverter(1)).isInstanceOf(PrimeraCartaDeLaManoStrategy.class);
        assertThat(experimentoService.identificadorStrategyConverter(2)).isInstanceOf(CualquierCartaDeLaManoAleatoriamenteStrategy.class);
        assertThat(experimentoService.identificadorStrategyConverter(3)).isInstanceOf(UltimaCartaQuePuedeGanarSinoAleatorioStrategy.class);
        assertThat(experimentoService.identificadorStrategyConverter(4)).isInstanceOf(UltimaCartaQuePuedeGanarSinoMenorValorStrategy.class);
    }

    @Test
    public void ejecutarExperimento_sobre4Jugadores() {
        ArrayList<Integer> strategyList = new ArrayList<Integer>(asList(new Integer[]{1,1,1,1}));
        ExperimentoColectivo experimentoCollectivo = experimentoService.ejecutarExperimento(strategyList, 10);
        assertEquals(4, experimentoCollectivo.getNumeroDeJugadores());
        assertEquals(10,experimentoCollectivo.getNumeroDeExperimentos());
    }

}

