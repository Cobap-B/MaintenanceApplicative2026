package com.mycalendar.domaine;

public final class Lieu {

    private final String value;

    public Lieu(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}