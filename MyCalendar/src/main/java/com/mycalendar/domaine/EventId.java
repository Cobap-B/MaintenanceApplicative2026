package com.mycalendar.domaine;

public final class EventId {

    private final String value;

    public EventId(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EventId)) return false;
        return value.equals(((EventId) obj).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}