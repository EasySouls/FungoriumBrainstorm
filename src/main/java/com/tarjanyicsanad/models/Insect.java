package com.tarjanyicsanad.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Insect {
    private Map<Effect, Integer> effects = new HashMap<>();

    public void takeTurn() {
        Iterator<Map.Entry<Effect, Integer>> iterator = effects.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Effect, Integer> entry = iterator.next();
            int newDuration = entry.getValue() - 1;
            if (newDuration <= 0) {
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
}
