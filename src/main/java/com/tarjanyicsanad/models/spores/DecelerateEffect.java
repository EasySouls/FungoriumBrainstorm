package com.tarjanyicsanad.models.spores;

import com.tarjanyicsanad.models.Insect;

public class DecelerateEffect implements EffectBehaviour{
    @Override
    public void apply(Insect insect) {
        insect.decelerate();
    }
}
