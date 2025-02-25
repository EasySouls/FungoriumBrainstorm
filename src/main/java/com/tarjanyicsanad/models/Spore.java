package com.tarjanyicsanad.models;

public class Spore {
    private Effect effect;

    public void applyEffect(Insect insect) {
        insect.applyEffect(effect, 1);
    }
}
