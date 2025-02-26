package com.tarjanyicsanad;

import com.tarjanyicsanad.models.Fungi;
import com.tarjanyicsanad.models.Tecton;

import java.util.Set;

public class TectonFactory {
    public static Tecton generateTecton(boolean shouldSpawnFungi) {
        Fungi fungi = shouldSpawnFungi ? new Fungi(0) : null;
        // Generate this randomly
        Tecton.TectonType tectonType = Tecton.TectonType.SINGLE_YARN;
        return new Tecton(fungi, Set.of(tectonType));
    }
}
