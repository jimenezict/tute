package com.dataontheroad.tute.experimento.api.controller;

import com.dataontheroad.tute.experimento.api.domain.ExperimentoPostForm;
import com.dataontheroad.tute.experimento.api.service.ExperimentoService;
import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class ExperimentoControllerImpl implements ExperimentoController {

    @Autowired
    ExperimentoService experimentoService;

    @Override
    @GetMapping("/experimento/")
    public ResponseEntity experimentoHealthCheck() {
        return ResponseEntity.ok(OK);
    }

    @Override
    @PostMapping("/experimento/")
    public ResponseEntity experimento(ExperimentoPostForm experimentoPostForm) {
        if(!validador(experimentoPostForm)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        ExperimentoColectivo experimentoColectivo = experimentoService.ejecutarExperimento(experimentoPostForm.getStrategyList(), experimentoPostForm.getNumExperimentos());
        return new ResponseEntity<>(experimentoColectivo, OK);
    }

    private boolean validador(ExperimentoPostForm experimentoPostForm) {
        return nonNull(experimentoPostForm)
                && nonNull(experimentoPostForm.getStrategyList())
                && experimentoPostForm.getStrategyList().isEmpty();
    }
}
