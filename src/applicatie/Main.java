package applicatie;

import dienst.BedrijfDienst;
import hulpmiddel.BestandSchrijver;
import model.AdministratiefPersoneel;
import model.Bedrijf;
import model.Docent;
import model.Gebruiker;
import model.GebruikersRol;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Startklasse van de KET bedrijven applicatie.
 * In deze klasse kiest de gebruiker een rol en gebruikt hij het menu.
 */
public class Main {

    /**
     * Start de applicatie.
     *
     * @param args niet gebruikt
     */
    public static void main(String[] args) {
        BedrijfDienst bedrijfDienst = new BedrijfDienst();
        BestandSchrijver bestandSchrijver = new BestandSchrijver();
        Scanner scanner = new Scanner(System.in);

        Gebruiker gebruiker = kiesGebruiker(scanner);
        ArrayList<Bedrijf> laatsteZoekresultaten = new ArrayList<>();

        boolean actief = true;

        while (actief) {
            boolean isAdmin = gebruiker.getRol() == GebruikersRol.ADMINISTRATIEF_PERSONEEL;

            toonMenu(gebruiker, isAdmin);
            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1":
                    laatsteZoekresultaten = zoekBedrijven(scanner, bedrijfDienst);
                    break;

                case "2":
                    bestandSchrijver.schrijfBedrijvenNaarBestand(
                            laatsteZoekresultaten,
                            "zoekresultaten.txt"
                    );
                    break;

                case "3":
                    if (isAdmin) {
                        voegBedrijfToe(scanner, bedrijfDienst);
                    } else {
                        System.out.println("Applicatie wordt afgesloten.");
                        actief = false;
                    }
                    break;

                case "4":
                    if (isAdmin) {
                        verwijderBedrijf(scanner, bedrijfDienst);
                    } else {
                        System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    }
                    break;

                case "5":
                    if (isAdmin) {
                        pasBedrijfAan(scanner, bedrijfDienst);
                    } else {
                        System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    }
                    break;

                case "6":
                    if (isAdmin) {
                        System.out.println("Applicatie wordt afgesloten.");
                        actief = false;
                    } else {
                        System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    }
                    break;

                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Laat de gebruiker een rol kiezen.
     *
     * @param scanner scanner om input van de gebruiker te lezen
     * @return de gekozen gebruiker
     */
    private static Gebruiker kiesGebruiker(Scanner scanner) {
        while (true) {
            System.out.println("Kies je rol:");
            System.out.println("1. Student");
            System.out.println("2. Docent");
            System.out.println("3. Administratief personeel");
            System.out.print("Maak een keuze: ");

            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1":
                    return new Student("Student");
                case "2":
                    return new Docent("Docent");
                case "3":
                    return new AdministratiefPersoneel("Administratief medewerker");
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    /**
     * Toont het menu afhankelijk van de rol van de gebruiker.
     *
     * @param gebruiker de gekozen gebruiker
     * @param isAdmin true als de gebruiker administratief personeel is
     */
    private static void toonMenu(Gebruiker gebruiker, boolean isAdmin) {
        System.out.println("\nKET bedrijven applicatie");
        System.out.println("Gebruiker: " + gebruiker.getNaam() + " - " + gebruiker.getRol());
        System.out.println("1. Bedrijven zoeken");
        System.out.println("2. Laatste zoekresultaten opslaan");

        if (isAdmin) {
            System.out.println("3. Bedrijf toevoegen");
            System.out.println("4. Bedrijf verwijderen");
            System.out.println("5. Bedrijf aanpassen");
            System.out.println("6. Afsluiten");
        } else {
            System.out.println("3. Afsluiten");
        }

        System.out.print("Maak een keuze: ");
    }

    /**
     * Zoekt bedrijven op basis van een zoekterm en toont de resultaten.
     *
     * @param scanner scanner om input van de gebruiker te lezen
     * @param bedrijfDienst dienst die de bedrijven beheert
     * @return lijst met gevonden bedrijven
     */
    private static ArrayList<Bedrijf> zoekBedrijven(Scanner scanner, BedrijfDienst bedrijfDienst) {
        System.out.print("Geef een zoekterm: ");
        String zoekterm = scanner.nextLine();

        ArrayList<Bedrijf> resultaten = bedrijfDienst.zoekBedrijven(zoekterm);

        if (resultaten.isEmpty()) {
            System.out.println("Geen bedrijven gevonden.");
        } else {
            System.out.println("Zoekresultaten:");

            for (Bedrijf bedrijf : resultaten) {
                System.out.println("--------------------");
                System.out.println(bedrijf);
            }
        }

        return resultaten;
    }

    /**
     * Laat administratief personeel een nieuw bedrijf toevoegen.
     *
     * @param scanner scanner om input van de gebruiker te lezen
     * @param bedrijfDienst dienst die de bedrijven beheert
     */
    private static void voegBedrijfToe(Scanner scanner, BedrijfDienst bedrijfDienst) {
        System.out.print("Naam van het bedrijf: ");
        String naam = scanner.nextLine();

        System.out.print("Contactpersoon: ");
        String contactPersoon = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefoonnummer: ");
        String telefoonnummer = scanner.nextLine();

        System.out.print("Adres: ");
        String adres = scanner.nextLine();

        System.out.print("Omschrijving: ");
        String omschrijving = scanner.nextLine();

        System.out.print("Zoekwoorden: ");
        String zoekwoorden = scanner.nextLine();

        Bedrijf bedrijf = new Bedrijf(
                naam,
                contactPersoon,
                email,
                telefoonnummer,
                adres,
                omschrijving,
                zoekwoorden
        );

        bedrijfDienst.voegBedrijfToe(bedrijf);

        System.out.println("Bedrijf is toegevoegd.");
    }

    /**
     * Laat administratief personeel een bedrijf verwijderen.
     *
     * @param scanner scanner om input van de gebruiker te lezen
     * @param bedrijfDienst dienst die de bedrijven beheert
     */
    private static void verwijderBedrijf(Scanner scanner, BedrijfDienst bedrijfDienst) {
        System.out.print("Naam van het bedrijf dat je wil verwijderen: ");
        String naam = scanner.nextLine();

        boolean verwijderd = bedrijfDienst.verwijderBedrijfOpNaam(naam);

        if (verwijderd) {
            System.out.println("Bedrijf is verwijderd.");
        } else {
            System.out.println("Bedrijf niet gevonden.");
        }
    }

    /**
     * Laat administratief personeel een bestaand bedrijf aanpassen.
     *
     * @param scanner scanner om input van de gebruiker te lezen
     * @param bedrijfDienst dienst die de bedrijven beheert
     */
    private static void pasBedrijfAan(Scanner scanner, BedrijfDienst bedrijfDienst) {
        System.out.print("Naam van het bedrijf dat je wil aanpassen: ");
        String naam = scanner.nextLine();

        Bedrijf bedrijf = bedrijfDienst.zoekBedrijfOpNaam(naam);

        if (bedrijf == null) {
            System.out.println("Bedrijf niet gevonden.");
            return;
        }

        System.out.print("Nieuwe naam: ");
        bedrijf.setNaam(scanner.nextLine());

        System.out.print("Nieuwe contactpersoon: ");
        bedrijf.setContactPersoon(scanner.nextLine());

        System.out.print("Nieuwe email: ");
        bedrijf.setEmail(scanner.nextLine());

        System.out.print("Nieuw telefoonnummer: ");
        bedrijf.setTelefoonnummer(scanner.nextLine());

        System.out.print("Nieuw adres: ");
        bedrijf.setAdres(scanner.nextLine());

        System.out.print("Nieuwe omschrijving: ");
        bedrijf.setOmschrijving(scanner.nextLine());

        System.out.print("Nieuwe zoekwoorden: ");
        bedrijf.setZoekwoorden(scanner.nextLine());

        System.out.println("Bedrijf is aangepast.");
    }
}