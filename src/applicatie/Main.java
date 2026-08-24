package applicatie;

import dienst.BedrijfDienst;
import model.Bedrijf;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BedrijfDienst bedrijfDienst = new BedrijfDienst();
        Scanner scanner = new Scanner(System.in);

        boolean actief = true;

        while (actief) {
            System.out.println("\nKET bedrijven applicatie");
            System.out.println("1. Bedrijven zoeken");
            System.out.println("2. Afsluiten");
            System.out.print("Maak een keuze: ");

            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1":
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
                    break;

                case "2":
                    System.out.println("Applicatie wordt afgesloten.");
                    actief = false;
                    break;

                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }

        scanner.close();
    }
}