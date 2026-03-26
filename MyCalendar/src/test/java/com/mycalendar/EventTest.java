package com.mycalendar;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    void should_create_personal_event_description() {
        Event e = new Event(
            "RDV_PERSONNEL",
            "Dentiste",
            "Hugo",
            LocalDateTime.of(2025, 3, 26, 10, 0),
            30,
            null,
            null,
            0
        );

        assertEquals("RDV : Dentiste à 2025-03-26T10:00", e.description());
    }
}
