package com.dataontheroad.tute.experimento.api.controller;

import com.dataontheroad.tute.experimento.api.domain.ExperimentoPostForm;
import com.dataontheroad.tute.experimento.api.service.ExperimentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

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
    public void postExperimentoExperimento_conStrategyListVacia_RetornaRespuestaIncorrecta() {
        ExperimentoPostForm experimentoPostForm = new ExperimentoPostForm();
        experimentoPostForm.setNumExperimentos(NUM_EXPERIMENTO);
        experimentoPostForm.setStrategyList(new ArrayList<>());

        ResponseEntity responseEntity = experimentoController.experimento(experimentoPostForm);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postExperimentoExperimento_conStrategyListFormada_RetornaRespuestaCorrecta() {
        ExperimentoPostForm experimentoPostForm = creadorExperimentoPostForm(NUM_EXPERIMENTO);
        when(experimentoService.ejecutarExperimento(experimentoPostForm.getStrategyList(), NUM_EXPERIMENTO))
                .thenReturn(experimentoColectivo(NUM_EXPERIMENTO));
        ResponseEntity responseEntity = experimentoController.experimento(experimentoPostForm);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertTrue(responseEntity.getBody().toString().contains("numeroDeJugadores"));
    }

}