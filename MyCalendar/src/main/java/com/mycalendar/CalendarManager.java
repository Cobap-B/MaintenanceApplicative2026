package com.mycalendar;

import com.mycalendar.domaine.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarManager {

    private final List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouter(Event event) {
        events.add(event);
    }

    public List<Event> tousLesEvenements() {
        return new ArrayList<>(events);
    }

    public List<Event> eventsDansPeriode(DateEvenement debut, DateEvenement fin) {
        return events.stream()
                .filter(e -> e.estDansPeriode(debut, fin))
                .collect(Collectors.toList());
    }

    public boolean enConflit(Event e1, Event e2) {
        return e1.estEnConflitAvec(e2);
    }

    public void supprimer(EventId id) {
        events.removeIf(e -> e.id().equals(id));
    }
}