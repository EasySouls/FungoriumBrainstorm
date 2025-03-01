package com.tarjanyicsanad.models;

import java.util.*;

public class Tecton {
    private Fungi fungi;
    private Set<TectonType> types = new HashSet<>();
    private final List<Thread> threads = new ArrayList<>();

    // We might not need this and can rely on the WorldMap
    private final List<Tecton> neighbours = new ArrayList<>();


    public Tecton(Fungi ownFungi, Set<TectonType> tectonTypes) {
        types = tectonTypes;
        fungi = ownFungi;
    }

    public void takeTurn(int round) {
        if (isType(TectonType.THREAD_ABSORBENT)) {
            for (Thread thread : threads) {
                // Do something based on the type of the thread
                // Maybe use some nice design pattern here
            }
        }
    }

    public void addThread(Thread thread) {
        threads.add(thread);
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

    public List<Thread> getThreads() {
        return threads;
    }

    public List<Thread> getThreadsBetween(Tecton tecton) {
        return threads.stream().filter(thread -> !thread.isOnTecton()).toList();
    }

    public List<Thread> getThreadsOnTecton() {
        return threads.stream().filter(Thread::isOnTecton).toList();
    }

    public List<Tecton> getNeighbours() {
        return neighbours;
    }

    public Set<TectonType> getTypes() {
        return types;
    }

    public enum TectonType {
        /// With time, the tecton absorbs the yarn on itself.
        THREAD_ABSORBENT,

        /// Multiple yarns can inhabit the tecton.
        MULTIPLE_YARNS,

        /// Only a single yarn can inhabit the tecton.
        SINGLE_YARN,

        /// No fungi can inhabit the tecton, however yarn can go through it.
        UNINHABITABLE
    }
}
