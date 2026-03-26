package com.mycalendar.domaine;

public final class Reunion implements Event {

    private final TitreEvenement titre;
    private final Lieu lieu;
    private final Participants participants;

    public Reunion(TitreEvenement titre, Lieu lieu, Participants participants) {
        this.titre = titre;
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + titre + " à " + lieu + " avec " + participants;
    }
}