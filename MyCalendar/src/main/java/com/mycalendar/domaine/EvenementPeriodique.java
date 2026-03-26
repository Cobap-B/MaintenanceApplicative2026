package com.mycalendar.domaine;

public final class EvenementPeriodique implements Event {

    private final TitreEvenement titre;
    private final FrequenceJours frequence;

    public EvenementPeriodique(TitreEvenement titre, FrequenceJours frequence) {
        this.titre = titre;
        this.frequence = frequence;
    }

    @Override
    public String description() {
        return "Événement périodique : " + titre + " tous les " + frequence + " jours";
    }
}