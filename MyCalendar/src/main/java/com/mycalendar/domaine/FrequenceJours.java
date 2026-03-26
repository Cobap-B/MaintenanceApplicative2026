package com.mycalendar.domaine;

public final class FrequenceJours {

    private final int value;

    public FrequenceJours(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}