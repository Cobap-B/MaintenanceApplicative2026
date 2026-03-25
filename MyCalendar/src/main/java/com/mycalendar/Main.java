package com.mycalendar;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        String utilisateur = null;
        boolean continuer = true;

        String utilisateurs[] = new String[99];
        String motsDePasses[] = new String[99];
        int nbUtilisateurs = 0;

        while (true) {

            if (utilisateur == null) {
                System.out.println("  _____         _                   _                __  __");
                System.out.println(" / ____|       | |                 | |              |  \\/  |");
                System.out.println(
                        "| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
                System.out.println(
                        "| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
                System.out.println(
                        "| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
                System.out.println(
                        " \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
                System.out.println(
                        "                                                                                   __/ |");
                System.out.println(
                        "                                                                                  |___/");

                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.println("Choix : ");

                switch (scanner.nextLine()) {
                    case "1":
                        System.out.print("Nom d'utilisateur: ");
                        utilisateur = scanner.nextLine();

                        if (utilisateur.equals("Roger")) {
                            String motDePasse = scanner.nextLine();
                            if (!motDePasse.equals("Chat")) {
                                utilisateur = null;
                            }
                        }
                }
            }
        }
    }
}
