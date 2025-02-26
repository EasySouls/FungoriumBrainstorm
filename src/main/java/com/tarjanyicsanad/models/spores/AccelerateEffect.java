package com.tarjanyicsanad.models.spores;

import com.tarjanyicsanad.models.Insect;

public class AccelerateEffect implements EffectBehaviour {
    @Override
    public void apply(Insect insect) {
        insect.accelerate();
    }
}
