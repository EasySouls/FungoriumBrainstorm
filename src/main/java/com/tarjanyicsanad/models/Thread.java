package com.tarjanyicsanad.models;

public class Thread {
    private final Integer id;
    private Tecton startTecton;
    private Tecton endTecton;
    private ThreadType type;

    public Thread(Integer id, Tecton startTecton, Tecton endTecton) {
        this.id = id;
        this.startTecton = startTecton;
        this.endTecton = endTecton;

        if (startTecton.equals(endTecton)) {
            type = ThreadType.ON_TECTON;
        } else {
            type = ThreadType.BETWEEN_TECTONS;
        }
    }

    public Integer getId() {
        return id;
    }

    public boolean isOnTecton() {
        return type == ThreadType.ON_TECTON;
    }

    public enum ThreadType {
        ON_TECTON,
        BETWEEN_TECTONS
    }
}
