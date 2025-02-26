package com.tarjanyicsanad.models.spores;

import com.tarjanyicsanad.models.Insect;

public class ParalyzeEffect implements EffectBehaviour {
    @Override
    public void apply(Insect insect) {
        insect.paralyze();
    }
}
