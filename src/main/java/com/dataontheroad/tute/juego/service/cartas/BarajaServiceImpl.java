package com.dataontheroad.tute.juego.service.cartas;

import com.dataontheroad.tute.juego.domain.cartas.Baraja;
import com.dataontheroad.tute.juego.domain.cartas.Carta;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class BarajaServiceImpl implements BarajaService {
    @Override
    public Baraja crear() {
        return new Baraja();
    }

    @Override
    public void mezclar(Baraja baraja) {
        Collections.shuffle(baraja.getListaCartasBaraja());
    }

    @Override
    public Carta cogerCarta(Baraja baraja) {
        return !isEmpty(baraja.getListaCartasBaraja()) ? baraja.getListaCartasBaraja().remove(0) : null;
    }
}
