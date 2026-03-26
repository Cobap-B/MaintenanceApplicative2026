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
    
    // Sans if je sais pas comment faire ca
    @Override
    public boolean estDansPeriode(DateEvenement debut, DateEvenement fin) {
        var occurrence = dateDebut.toLocalDateTime();
        var finPeriode = fin.toLocalDateTime();

        while (!occurrence.isAfter(finPeriode)) {
            if (!occurrence.isBefore(debut.toLocalDateTime())) {
                return true;
            }
            occurrence = occurrence.plusDays(frequence.toInt());
        }
        return false;
    }

    // Sans if je sais pas comment faire ca
    @Override
    public boolean estEnConflitAvec(Event autre) {
        var occurrence = dateDebut.toLocalDateTime();
        var dureeMinutes = duree.toMinutes();
        var finAutre = autre.dateDebut().toLocalDateTime().plusMinutes(autre.duree().toMinutes());

    
        while (occurrence.isBefore(finAutre)) {
            var finOccurrence = occurrence.plusMinutes(dureeMinutes);
            if (occurrence.isBefore(finAutre) && finOccurrence.isAfter(autre.dateDebut().toLocalDateTime())) {
                return true; 
            }
            occurrence = occurrence.plusDays(frequence.toInt());
        }

        return false;
    }
}