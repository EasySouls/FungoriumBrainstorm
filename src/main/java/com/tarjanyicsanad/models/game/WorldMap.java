package com.tarjanyicsanad.models.game;

import com.tarjanyicsanad.TectonFactory;
import com.tarjanyicsanad.models.Fungi;
import com.tarjanyicsanad.models.Tecton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorldMap {
    private final List<Tecton> tectons;

    // Maybe add an observer pattern here to notify the tectons about the game state

    public WorldMap() {
        tectons = new ArrayList<>();
    }

    /**
     * Initializes the world map with the given number of tectons
     * @param tectonCount The number of tectons to generate
     * @return The set of fungi that were generated
     */
    public Set<Fungi> initialize(int tectonCount, int mushroomManCount) {
        return generateTectons(tectonCount, mushroomManCount);
    }

    private Set<Fungi> generateTectons(int tectonCount, int mushroomManCount) {
        Set<Fungi> generatedFungi = new HashSet<>();

        for (int i = 0; i < tectonCount; i++) {
            ///  This might not work, since we need to know the current world state when generating a new Tecton
            ///  This is not a problem at the beginning of the game however

            // Might need to change this to a more complex logic
            // For now it generates a fungi for the first mushroomManCount tectons
            boolean shouldSpawnFungi = i < mushroomManCount;
            Tecton tecton = TectonFactory.generateTecton(i, shouldSpawnFungi, generatedFungi);
            tectons.add(tecton);
        }

        return generatedFungi;
    }

    public void nextTurn(int round) {
        for (Tecton tecton : tectons) {
            tecton.takeTurn(round);
        }
    }
}
