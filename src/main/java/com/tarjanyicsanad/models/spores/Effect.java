package com.tarjanyicsanad.models.spores;

import com.tarjanyicsanad.models.Insect;

public enum Effect {
    ACCELERATE(new AccelerateEffect()),
    DECELERATE(new DecelerateEffect()),
    PARALYZE(new ParalyzeEffect()),
    ANTI_CUT(new AntiCutEffect());

    private final EffectBehaviour effectBehaviour;

    Effect(EffectBehaviour effectBehaviour) {
        this.effectBehaviour = effectBehaviour;
    }

    public void apply(Insect insect) {
        effectBehaviour.apply(insect);
    }
}
