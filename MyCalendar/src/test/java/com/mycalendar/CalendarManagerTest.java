package com.mycalendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.mycalendar.domaine.*;

public class CalendarManagerTest {

    @Test
    void should_add_event_to_calendar() {
        CalendarManager calendar = new CalendarManager();

        Event event = new RendezVousPersonnel(
            new EventId("1"),
            new TitreEvenement("Dentiste"),
            new DateEvenement(LocalDateTime.of(2025, 3, 26, 10, 0)),
            new DureeEvenement(30)
        );

        calendar.ajouter(event);

        assertEquals(1, calendar.tousLesEvenements().size());
    }

    @Test
    void should_return_events_in_given_period() {
        CalendarManager calendar = new CalendarManager();

        Event event = new RendezVousPersonnel(
            new EventId("1"),
            new TitreEvenement("Dentiste"),
            new DateEvenement(LocalDateTime.of(2025, 3, 26, 10, 0)),
            new DureeEvenement(30)
        );

        calendar.ajouter(event);

        List<Event> result = calendar.eventsDansPeriode(
            new DateEvenement(LocalDateTime.of(2025, 3, 25, 0, 0)),
            new DateEvenement(LocalDateTime.of(2025, 3, 27, 0, 0))
        );

        assertEquals(1, result.size());
    }

    @Test
    void should_return_empty_list_when_no_events_in_period() {
        CalendarManager calendar = new CalendarManager();

        List<Event> result = calendar.eventsDansPeriode(
            new DateEvenement(LocalDateTime.of(2025, 1, 1, 0, 0)),
            new DateEvenement(LocalDateTime.of(2025, 1, 2, 0, 0))
        );

        assertTrue(result.isEmpty());
    }

    @Test
    void should_detect_conflict_between_two_events() {
        CalendarManager calendar = new CalendarManager();

        Event e1 = new RendezVousPersonnel(
            new EventId("1"),
            new TitreEvenement("Dentiste"),
            new DateEvenement(LocalDateTime.of(2025, 3, 26, 10, 0)),
            new DureeEvenement(60)
        );

        Event e2 = new RendezVousPersonnel(
            new EventId("2"),
            new TitreEvenement("Coiffeur"),
            new DateEvenement(LocalDateTime.of(2025, 3, 26, 10, 30)),
            new DureeEvenement(30)
        );

        assertTrue(calendar.enConflit(e1, e2));
    }

    @Test
    void should_not_detect_conflict_when_events_do_not_overlap() {
        CalendarManager calendar = new CalendarManager();

        Event e1 = new RendezVousPersonnel(
            new EventId("1"),
            new TitreEvenement("Dentiste"),
            new DateEvenement(LocalDateTime.of(2025, 3, 26, 10, 0)),
            new DureeEvenement(30)
        );

        Event e2 = new RendezVousPersonnel(
            new EventId("2"),
            new TitreEvenement("Sport"),
            new DateEvenement(LocalDateTime.of(2025, 3, 26, 11, 0)),
            new DureeEvenement(30)
        );

        assertFalse(calendar.enConflit(e1, e2));
    }

    @Test
    void should_remove_event_by_id() {
        CalendarManager calendar = new CalendarManager();

        EventId id = new EventId("1");

        Event event = new RendezVousPersonnel(
            id,
            new TitreEvenement("Dentiste"),
            new DateEvenement(LocalDateTime.of(2025, 3, 26, 10, 0)),
            new DureeEvenement(30)
        );

        calendar.ajouter(event);

        calendar.supprimer(id);

        assertTrue(calendar.tousLesEvenements().isEmpty());
    }
}