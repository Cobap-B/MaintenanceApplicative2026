package com.mycalendar.domaine;

public final class Participants {

    private final String value;

    public Participants(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}