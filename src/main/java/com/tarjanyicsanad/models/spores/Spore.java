package com.tarjanyicsanad.models.spores;

import com.tarjanyicsanad.models.Insect;

public class Spore {
    private final Effect effect;

    public Spore(Effect effect) {
        this.effect = effect;
    }

    public void applyEffect(Insect insect, int duration) {
        insect.applyEffect(effect, duration);
    }

    public void applyEffect(Insect insect) {
        insect.applyEffect(effect, 1);
    }
}
