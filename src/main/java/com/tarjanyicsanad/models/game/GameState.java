package com.tarjanyicsanad.models.game;

import com.tarjanyicsanad.models.Fungi;
import com.tarjanyicsanad.models.Insect;
import com.tarjanyicsanad.models.players.Bugman;
import com.tarjanyicsanad.models.players.MushroomMan;
import com.tarjanyicsanad.models.players.Player;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private List<Player> players;
    private Integer round;
    private Integer currentPlayerIndex;

    private WorldMap map;

    public GameState() {
        round = 0;
        currentPlayerIndex = 0;
        map = new WorldMap();

        // Initialize the map with 10 tectons
        map.Initialize(10);
    }

    public void init(int mushroomManCount, int bugmanCount) {
        initPlayers(mushroomManCount, bugmanCount);
        initCharacters();
    }

    private void initPlayers(int mushroomManCount, int bugmanCount) {
        players = new ArrayList<>();

        ///  Add separate id's for each player
        int i;
        for (i = 0; i < mushroomManCount; i++) {
            players.add(new MushroomMan(i));
        }
        for (; i < bugmanCount; i++) {
            players.add(new Bugman(i));
        }
    }

    private void initCharacters() {
        // Initialize the characters for each player
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player instanceof MushroomMan mushroomMan) {
                    mushroomMan.addFungi(new Fungi(i, 0));
            } else if (player instanceof Bugman bugman) {
                bugman.setInsect(new Insect(i));
            }
        }
    }

    private void initWorldState() {

    }

    public void nextTurn() {
        round++;
        map.nextTurn(round);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void saveState() {
        // Save the current state of the game
    }

    public void loadState() {
        // Load the saved state of the game
    }
}
