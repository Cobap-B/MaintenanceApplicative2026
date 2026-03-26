package com.mycalendar.domaine;

public final class DureeEvenement {

    private final int minutes;

    public DureeEvenement(int minutes) {
        this.minutes = minutes;
    }

    public int toMinutes() {
        return minutes;
    }
}