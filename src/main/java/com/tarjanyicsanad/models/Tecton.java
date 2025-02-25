package com.tarjanyicsanad.models;

import java.util.List;
import java.util.Set;

public class Tecton {
    private Fungi fungi;
    private Set<TectonType> types;
    private List<Thread> threads;

    public Tecton() {

    }

    public void setFungi(Fungi fungi) {
        this.fungi = fungi;
    }

    public boolean isType(TectonType type) {
        return types.contains(type);
    }

    public Fungi getFungi() {
        return fungi;
    }

    public Set<TectonType> getTypes() {
        return types;
    }

    public enum TectonType {
        /// With time, the tecton absorbs the yarn on itself.
        YARN_ABSORBENT,

        /// Multiple yarns can inhabit the tecton.
        MULTIPLE_YARNS,

        /// Only a single yarn can inhabit the tecton.
        SINGLE_YARN,

        /// No fungi can inhabit the tecton, however yarn can go through it.
        UNINHABITABLE
    }
}
