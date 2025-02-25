package com.tarjanyicsanad.models.game;

import com.tarjanyicsanad.models.players.Player;

import java.util.List;

public class GameState {

    private List<Player> players;
    private Integer round;
    private Integer currentPlayerIndex;

    private GameMap map;
}
