package com.mycalendar;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalendarManagerTest {

    private CalendarManager manager;

    @BeforeEach
    public void setUp() {
        manager = new CalendarManager();
    }

    @Test
    public void testAjouterEvent_etSize() {
        manager.ajouterEvent("RDV_PERSONNEL", "Dentiste", "Alice", LocalDateTime.of(2026, 4, 1, 9, 0), 30, "", "", 0);
        assertEquals(1, manager.events.size());
    }

    @Test
    public void testEventsDansPeriode_rendezVous() {
        LocalDateTime now = LocalDateTime.of(2026, 4, 10, 10, 0);
        manager.ajouterEvent("RDV_PERSONNEL", "Test", "Bob", now, 60, "", "", 0);

        List<Event> found = manager.eventsDansPeriode(now.minusDays(1), now.plusDays(1));
        assertEquals(1, found.size());
        assertSame(manager.events.get(0), found.get(0));
    }

    @Test
    public void testConflit_true_et_false() {
        Event a = new Event("RDV_PERSONNEL", "A", "Bob", LocalDateTime.of(2026, 4, 10, 8, 0), 60, "", "", 0);
        Event b = new Event("RDV_PERSONNEL", "B", "Bob", LocalDateTime.of(2026, 4, 10, 8, 30), 30, "", "", 0);
        Event c = new Event("RDV_PERSONNEL", "C", "Bob", LocalDateTime.of(2026, 4, 10, 10, 0), 30, "", "", 0);

        assertTrue(manager.conflit(a, b));
        assertFalse(manager.conflit(a, c));
    }
}
