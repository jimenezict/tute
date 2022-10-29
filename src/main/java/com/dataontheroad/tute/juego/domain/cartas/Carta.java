package com.dataontheroad.tute.juego.domain.cartas;

import java.util.Objects;

public class Carta {

    private CartaEnum palo;
    private Integer numero;

    public Carta(CartaEnum palo, Integer numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public CartaEnum getPalo() {
        return palo;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return palo == carta.palo && Objects.equals(numero, carta.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(palo, numero);
    }

    @Override
    public String toString() {
        return "Palo: " + palo + " Numero: " + numero;
    }


}
