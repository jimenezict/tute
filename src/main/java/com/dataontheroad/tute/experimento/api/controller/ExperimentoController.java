package com.dataontheroad.tute.experimento.api.controller;

import com.dataontheroad.tute.experimento.api.domain.ExperimentoPostForm;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ExperimentoController {


    ResponseEntity<String> experimentoHealthCheck();

    @PostMapping("/experimento/")
    ResponseEntity<ExperimentoColectivo> experimento(@RequestBody ExperimentoPostForm experimentoPostForm);


}
