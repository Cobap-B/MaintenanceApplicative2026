package com.mycalendar;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class EventTest {

   @Test
    void should_describe_rdv_personnel() {
        Event event = new RendezVousPersonnel(
            new TitreEvenement("Dentiste"),
            new DateEvenement(LocalDateTime.of(2025, 3, 26, 10, 0)),
            new DureeEvenement(30)
        );

        assertEquals("RDV : Dentiste à 2025-03-26T10:00", event.description());
    }

    @Test
    void should_include_correct_date_in_description() {
        Event event = new RendezVousPersonnel(
            new TitreEvenement("Médecin"),
            new DateEvenement(LocalDateTime.of(2025, 5, 1, 14, 30)),
            new DureeEvenement(45)
        );

        assertTrue(event.description().contains("2025-05-01T14:30"));
    }

    @Test
    void should_describe_reunion() {
        Event event = new Reunion(
            new TitreEvenement("Sprint Review"),
            new Lieu("Salle 1"),
            new Participants("Alice,Bob")
        );

        assertEquals(
            "Réunion : Sprint Review à Salle 1 avec Alice,Bob",
            event.description()
        );
    }
    
    @Test
    void should_include_all_participants() {
        Event event = new Reunion(
            new TitreEvenement("Daily"),
            new Lieu("Zoom"),
            new Participants("Alice,Bob,Charlie")
        );

        assertTrue(event.description().contains("Alice,Bob,Charlie"));
    }

    @Test
    void should_describe_evenement_periodique() {
        Event event = new EvenementPeriodique(
            new TitreEvenement("Sport"),
            new FrequenceJours(7)
        );

        assertEquals(
            "Événement périodique : Sport tous les 7 jours",
            event.description()
        );
    }

}
