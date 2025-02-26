package com.tarjanyicsanad.models.game;

import com.tarjanyicsanad.models.Tecton;

public interface ITectonObserver {
    void onThreadAbsorbed(Tecton tecton, Thread thread);
}
