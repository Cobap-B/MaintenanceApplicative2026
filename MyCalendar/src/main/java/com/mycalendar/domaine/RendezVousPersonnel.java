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

    @Override
    public boolean estDansPeriode(DateEvenement debut, DateEvenement fin) {
        return !date.toLocalDateTime().isBefore(debut.toLocalDateTime()) &&
            !date.toLocalDateTime().isAfter(fin.toLocalDateTime());
    }

    @Override
    public boolean estEnConflitAvec(Event autre) {
        var debut1 = date.toLocalDateTime();
        var fin1 = debut1.plusMinutes(duree.toMinutes());

        var debut2 = autre.dateDebut().toLocalDateTime();
        var fin2 = debut2.plusMinutes(autre.duree().toMinutes());

        return debut1.isBefore(fin2) && fin1.isAfter(debut2);
    }
}