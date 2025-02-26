package com.tarjanyicsanad.models;

import com.tarjanyicsanad.models.spores.Effect;
import com.tarjanyicsanad.models.spores.Spore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Insect {
    private Integer id;
    private int baseCost = 5;
    private boolean isParalyzed = false;
    private boolean canCut = true;

    private final Map<Effect, Integer> effects = new HashMap<>();

    public Insect(Integer id) {
        this.id = id;
    }

    public void takeTurn() {
        Iterator<Map.Entry<Effect, Integer>> iterator = effects.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Effect, Integer> entry = iterator.next();
            int newDuration = entry.getValue() - 1;
            if (newDuration <= 0) {
                removeEffect(entry.getKey());
                iterator.remove();
            } else {
                entry.setValue(newDuration);
            }
        }
    }

    public void applyEffect(Effect effect, int duration) {
        effects.put(effect, duration);
    }

    public void eatSpore(Spore spore) {
        spore.applyEffect(this);
    }

    public void paralyze() {
        isParalyzed = true;
    }

    public void accelerate() {
        baseCost -= 3;
    }

    public void decelerate() {
        baseCost += 3;
    }

    public void setAntiCut() {
        canCut = false;
    }

    private void removeEffect(Effect effect) {
        switch (effect) {
            case PARALYZE:
                isParalyzed = false;
                break;
            case ACCELERATE:
                baseCost += 3;
                break;
            case DECELERATE:
                baseCost -= 3;
                break;
            case ANTI_CUT:
                canCut = true;
                break;
        }
    }

}
