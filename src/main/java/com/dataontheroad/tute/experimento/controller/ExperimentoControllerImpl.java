package com.dataontheroad.tute.experimento.controller;

import com.dataontheroad.tute.experimento.controller.domain.ExperimentoPostForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class ExperimentoControllerImpl implements ExperimentoController {

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

        return ResponseEntity.ok(OK);
    }

    private boolean validador(ExperimentoPostForm experimentoPostForm) {
        return nonNull(experimentoPostForm)
                && nonNull(experimentoPostForm.getStrategyList())
                && experimentoPostForm.getStrategyList().size() > 0;
    }
}
