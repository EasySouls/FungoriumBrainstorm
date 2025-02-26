package com.tarjanyicsanad.models.game;

import com.tarjanyicsanad.TectonFactory;
import com.tarjanyicsanad.models.Tecton;

import java.util.ArrayList;
import java.util.List;

public class WorldMap implements ITectonObserver {
    private final List<Tecton> tectons;
    private final List<Thread> threads;

    // Maybe add an observer pattern here to notify the tectons about the game state

    public WorldMap() {
        tectons = new ArrayList<>();
        threads = new ArrayList<>();
    }

    public void Initialize(int tectonCount) {
        generateTectons(tectonCount);
    }

    private void generateTectons(int tectonCount) {
        for (int i = 0; i < tectonCount; i++) {
            ///  This might not work, since we need to know the current world state when generating a new Tecton
            ///  This is not a problem at the beginning of the game however
            boolean shouldSpawnFungi = false;
            Tecton tecton = TectonFactory.generateTecton(shouldSpawnFungi);
            tectons.add(tecton);
        }
    }

    public void nextTurn(int round) {
        for (Tecton tecton : tectons) {
            tecton.takeTurn(round);
        }
    }

    @Override
    public void onThreadAbsorbed(Tecton tecton, Thread thread) {
        threads.remove(thread);
        tecton.getThreads().remove(thread);
    }
}
