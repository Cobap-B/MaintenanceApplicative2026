package com.mycalendar.domaine;

public final class TitreEvenement {

    private final String value;

    public TitreEvenement(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}