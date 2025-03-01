package com.tarjanyicsanad.models.game;

import com.tarjanyicsanad.models.Fungi;
import com.tarjanyicsanad.models.Insect;
import com.tarjanyicsanad.models.players.Bugman;
import com.tarjanyicsanad.models.players.MushroomMan;
import com.tarjanyicsanad.models.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameState {

    private List<Player> players;
    private Integer round;
    private Integer currentPlayerIndex;

    private final WorldMap map;

    public GameState() {
        round = 0;
        currentPlayerIndex = 0;
        map = new WorldMap();
    }

    public void init(int mushroomManCount, int bugmanCount) {
        // Initialize the map with 10 tectons
        Set<Fungi> generatedFungi = map.initialize(10, mushroomManCount);

        initPlayers(mushroomManCount, bugmanCount);
        initCharacters(generatedFungi);
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

    /**
     * Initializes the characters for each player.
     * MushroomMan players get a Fungi, Bugman players get an Insect.
     * @param fungi The set of fungi to distribute to the MushroomMan players
     */
    private void initCharacters(Set<Fungi> fungi) {
        // Initialize the characters for each player
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player instanceof MushroomMan mushroomMan) {
                    mushroomMan.addFungi(fungi.iterator().next());
            } else if (player instanceof Bugman bugman) {
                bugman.setInsect(new Insect(i));
            }
        }
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
