package com.mycalendar.domaine;

public interface Event {

    String description();

    DateEvenement dateDebut();

    DureeEvenement duree();

    EventId id();

    boolean estDansPeriode(DateEvenement debut, DateEvenement fin);

    boolean estEnConflitAvec(Event autre);
}