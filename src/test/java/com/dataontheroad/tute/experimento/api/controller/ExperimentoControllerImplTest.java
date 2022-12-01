package com.dataontheroad.tute.experimento.api.controller;

import com.dataontheroad.tute.experimento.api.domain.ExperimentoPostForm;
import com.dataontheroad.tute.experimento.api.service.ExperimentoService;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static com.dataontheroad.tute.ObjectCreationHelper.creadorExperimentoPostForm;
import static com.dataontheroad.tute.ObjectCreationHelper.experimentoColectivo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ExperimentoControllerImplTest {

    private static final int NUM_EXPERIMENTO = 10;

    @InjectMocks
    ExperimentoControllerImpl experimentoController;

    @Mock
    ExperimentoService experimentoService;

    @Test
    void postExperimento_conStrategyListVacia_RetornaRespuestaIncorrecta() {
        ExperimentoPostForm experimentoPostForm = creadorExperimentoPostForm(NUM_EXPERIMENTO);
        experimentoPostForm.setStrategyList(new ArrayList<>());
        ResponseEntity responseEntity = experimentoController.experimento(experimentoPostForm);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void postExperimento_conStrategyListFormada_RetornaRespuestaCorrecta() {
        ExperimentoPostForm experimentoPostForm = creadorExperimentoPostForm(NUM_EXPERIMENTO);
        when(experimentoService.ejecutarExperimento(experimentoPostForm.getStrategyList(), NUM_EXPERIMENTO))
                .thenReturn(experimentoColectivo(NUM_EXPERIMENTO));
        ResponseEntity responseEntity = experimentoController.experimento(experimentoPostForm);
        assertEquals( HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(4, ((ExperimentoColectivo) responseEntity.getBody()).getNumeroDeJugadores());
    }

}