package com.mycalendar.domaine;

public final class EvenementPeriodique implements Event {

    private final EventId id;
    private final TitreEvenement titre;
    private final DateEvenement dateDebut; //Bizzare mais on considére le début de la période
    private final DureeEvenement duree;
    private final FrequenceJours frequence;

    public EvenementPeriodique(EventId id, TitreEvenement titre,
                               DateEvenement dateDebut,
                               DureeEvenement duree,
                               FrequenceJours frequence) {
        this.id = id;
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.frequence = frequence;
    }

    @Override
    public String description() {
        return "Événement périodique : " + titre + " tous les " + frequence + " jours";
    }

    @Override
    public DateEvenement dateDebut() {
        return dateDebut;
    }

    @Override
    public DureeEvenement duree() {
        return duree;
    }

    @Override
    public EventId id() {
        return id;
    }
    
    @Override
    public boolean estDansPeriode(DateEvenement debut, DateEvenement fin) {
        return !dateDebut.toLocalDateTime().isBefore(debut.toLocalDateTime()) &&
            !dateDebut.toLocalDateTime().isAfter(fin.toLocalDateTime());
    }

    @Override
    public boolean estEnConflitAvec(Event autre) {
        return false;
    }
}