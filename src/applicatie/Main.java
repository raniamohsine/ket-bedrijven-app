package applicatie;

import dienst.BedrijfDienst;
import model.Bedrijf;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("KET bedrijven applicatie");

        BedrijfDienst bedrijfDienst = new BedrijfDienst();
        Scanner scanner = new Scanner(System.in);

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

        scanner.close();
    }
}