package com.mycalendar.domaine;

public final class RendezVousPersonnel implements Event {

    private final TitreEvenement titre;
    private final DateEvenement date;
    private final DureeEvenement duree;

    public RendezVousPersonnel(TitreEvenement titre, DateEvenement date, DureeEvenement duree) {
        this.titre = titre;
        this.date = date;
        this.duree = duree;
    }

    @Override
    public String description() {
        return "RDV : " + titre + " à " + date;
    }
}