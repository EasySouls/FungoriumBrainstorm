package com.tarjanyicsanad;

import com.tarjanyicsanad.models.Fungi;
import com.tarjanyicsanad.models.Tecton;

import java.util.Set;

public class TectonFactory {
    public static Tecton generateTecton(int id, boolean shouldSpawnFungi, Set<Fungi> generatedFungi) {
        Fungi fungi = shouldSpawnFungi ? new Fungi(id, 0) : null;
        if (shouldSpawnFungi) {
            generatedFungi.add(fungi);
        }

        // Generate this randomly
        Tecton.TectonType tectonType = Tecton.TectonType.SINGLE_YARN;
        return new Tecton(fungi, Set.of(tectonType));
    }
}
