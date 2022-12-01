package com.dataontheroad.tute.experimento.api.service;

import com.dataontheroad.tute.experimento.domain.ExperimentoColectivo;
import com.dataontheroad.tute.juego.domain.jugador.Jugador;
import com.dataontheroad.tute.juego.service.jugador.strategy.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.dataontheroad.tute.experimento.service.ExperimentoColectivoExecutor.executar;

@Service
public class ExperimentoServiceImpl implements ExperimentoService {
    @Override
    public ExperimentoColectivo ejecutarExperimento(List<Integer> strategyList, int numExperimentos) {
        List<Jugador> jugadorList = new ArrayList<>();
        strategyList.forEach(num -> {
            Jugador jugador = new Jugador();
            jugador.setStrategy(identificadorStrategyConverter(num));
            jugadorList.add(jugador);
        });
        return executar(numExperimentos, jugadorList);
    }

    @Override
    public StrategyAbstract identificadorStrategyConverter(Integer identificador) {
        switch(identificador) {
            case 1:
                return new PrimeraCartaDeLaManoStrategy();
            case 2:
                return new CualquierCartaDeLaManoAleatoriamenteStrategy();
            case 3:
                return new UltimaCartaQuePuedeGanarSinoAleatorioStrategy();
            case 4:
                return new UltimaCartaQuePuedeGanarSinoMenorValorStrategy();
            case 5:
                return new CartaQuePuntuaMasAlGanarSinoMenorValorStrategy();
            default:
                return null;
        }
    }
}
