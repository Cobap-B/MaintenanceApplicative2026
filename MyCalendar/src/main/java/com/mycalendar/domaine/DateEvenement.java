package com.mycalendar.domaine;

import java.time.LocalDateTime;

public final class DateEvenement {

    private final LocalDateTime value;

    public DateEvenement(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public LocalDateTime toLocalDateTime() {
        return value;
    }
}