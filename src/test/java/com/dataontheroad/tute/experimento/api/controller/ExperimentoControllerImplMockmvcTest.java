package com.dataontheroad.tute.experimento.api.controller;

import com.dataontheroad.tute.experimento.api.domain.ExperimentoPostForm;
import com.dataontheroad.tute.experimento.api.service.ExperimentoServiceImpl;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static com.dataontheroad.tute.ObjectCreationHelper.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ExperimentoControllerImpl.class)
class ExperimentoControllerImplMockmvcTest {

    private static final int NUM_EXPERIMENTO = 10;

    @Autowired
    private MockMvc mvc;

    @MockBean
    ExperimentoServiceImpl experimentoServiceImpl;

    @Test
    void getExperimento() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/experimento/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void postExperimento_conStrategyListVacia_RetornaRespuestaIncorrecta() throws Exception{
        ExperimentoPostForm experimentoPostForm = creadorExperimentoPostForm(NUM_EXPERIMENTO);
        experimentoPostForm.setStrategyList(new ArrayList<>());

        mvc.perform( MockMvcRequestBuilders
                .post("/experimento/")
                .content(asJsonString(experimentoPostForm))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void postExperimento_conStrategyListFormada_RetornaRespuestaCorrecta() throws Exception{
        ExperimentoPostForm experimentoPostForm = creadorExperimentoPostForm(NUM_EXPERIMENTO);

        mvc.perform( MockMvcRequestBuilders
                .post("/experimento/")
                .content(asJsonString(experimentoPostForm))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}