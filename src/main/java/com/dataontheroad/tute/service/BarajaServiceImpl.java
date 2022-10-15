package com.dataontheroad.tute.service;

import com.dataontheroad.tute.domain.Baraja;
import com.dataontheroad.tute.domain.Carta;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class BarajaServiceImpl implements BarajaService {
    @Override
    public Baraja crear() {
        return new Baraja();
    }

    @Override
    public void mezclar(Baraja baraja) {
        Collections.shuffle(baraja.getBaraja());
    }

    @Override
    public Carta cogerCarta(Baraja baraja) {
        return baraja.getBaraja().size() > 0 ? baraja.getBaraja().remove(0) : null;
    }
}
