package com.tarjanyicsanad.models.players;

import com.tarjanyicsanad.models.Fungi;

import java.util.ArrayList;
import java.util.List;

public class MushroomMan extends Player {
    private Integer mushroomCount;
    private final List<Fungi> fungi = new ArrayList<>();

    public MushroomMan(Integer id) {
        super(id);
    }

    public void addFungi(Fungi fungi) {
        this.fungi.add(fungi);
    }
}
