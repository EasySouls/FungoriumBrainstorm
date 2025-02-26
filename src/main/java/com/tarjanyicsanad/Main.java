package com.tarjanyicsanad;

import com.tarjanyicsanad.models.game.GameState;

public class Main {
    static GameState gameState;

    public static void main(String[] args) {
        gameState = new GameState();

        int mushroomManCount = 2;
        int bugmanCount = 2;
        gameState.init(mushroomManCount, bugmanCount);
    }
}