package com.dataontheroad.tute.experimento.api.service;

import com.dataontheroad.tute.juego.service.jugador.strategy.CualquierCartaDeLaManoAleatoriamenteStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.PrimeraCartaDeLaManoStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.UltimaCartaQuePuedeGanarSinoAleatorioStrategy;
import com.dataontheroad.tute.juego.service.jugador.strategy.UltimaCartaQuePuedeGanarSinoMenorValorStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

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
}

