package com.dataontheroad.tute.experimento.api.controller;

import com.dataontheroad.tute.experimento.api.domain.ExperimentoPostForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ExperimentoController {

    public ResponseEntity experimentoHealthCheck();

    @PostMapping("/experimento/")
    ResponseEntity experimento(@RequestBody ExperimentoPostForm experimentoPostForm);


}
