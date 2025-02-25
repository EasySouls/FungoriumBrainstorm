package com.tarjanyicsanad.models.game;

import com.tarjanyicsanad.models.Tecton;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private List<Tecton> tectons;

    public GameMap() {
        tectons = new ArrayList<>();
        generateTectons(10);
    }

    private void generateTectons(int tectonCount) {
        for (int i = 0; i < tectonCount; i++) {
            tectons.add(new Tecton());
        }
    }
}
