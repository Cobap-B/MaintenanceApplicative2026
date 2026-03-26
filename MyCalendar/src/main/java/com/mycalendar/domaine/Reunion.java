package com.mycalendar.domaine;

public final class Reunion implements Event {

    private final EventId id;
    private final TitreEvenement titre;
    private final DateEvenement date;
    private final DureeEvenement duree;
    private final Lieu lieu;
    private final Participants participants;

    public Reunion(EventId id, TitreEvenement titre, DateEvenement date,
                   DureeEvenement duree, Lieu lieu, Participants participants) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.duree = duree;
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + titre + " à " + lieu + " avec " + participants;
    }

    @Override
    public DateEvenement dateDebut() {
        return date;
    }

    @Override
    public DureeEvenement duree() {
        return duree;
    }

    @Override
    public EventId id() {
        return id;
    }
}