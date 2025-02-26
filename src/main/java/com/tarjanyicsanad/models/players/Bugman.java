package com.tarjanyicsanad.models.players;

import com.tarjanyicsanad.models.Insect;

public class Bugman extends Player {
    private Insect insect;

    public Bugman(Integer id) {
        super(id);
    }

    public void setInsect(Insect insect) {
        this.insect = insect;
    }
}
