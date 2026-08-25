package dienst;

import model.Bedrijf;

import java.util.ArrayList;

/**
 * Deze klasse beheert de bedrijven van de applicatie.
 */
public class BedrijfDienst {
    private ArrayList<Bedrijf> bedrijven;

    public BedrijfDienst() {
        bedrijven = new ArrayList<>();
        voegTestBedrijvenToe();
    }

    private void voegTestBedrijvenToe() {
        bedrijven.add(new Bedrijf(
                "TechBrussels",
                "Sara Peeters",
                "info@techbrussels.be",
                "02 123 45 67",
                "Brussel",
                "IT-bedrijf dat werkt rond softwareontwikkeling.",
                "stage software programmeren java"
        ));

        bedrijven.add(new Bedrijf(
                "CyberSafe",
                "Youssef Benali",
                "contact@cybersafe.be",
                "02 222 33 44",
                "Schaarbeek",
                "Bedrijf gespecialiseerd in cybersecurity.",
                "stage cybersecurity veiligheid netwerk"
        ));

        bedrijven.add(new Bedrijf(
                "DesignLab",
                "Emma Janssens",
                "hello@designlab.be",
                "02 555 66 77",
                "Elsene",
                "Creatief bedrijf voor webdesign en branding.",
                "webdesign grafisch ontwerp website"
        ));
    }

    public ArrayList<Bedrijf> getBedrijven() {
        return bedrijven;
    }

     public ArrayList<Bedrijf> zoekBedrijven(String zoekterm) {
        ArrayList<Bedrijf> resultaten = new ArrayList<>();

        String zoektermKlein = zoekterm.toLowerCase();

        for (Bedrijf bedrijf : bedrijven) {
            String tekstVanBedrijf =
                    bedrijf.getNaam() + " " +
                    bedrijf.getOmschrijving() + " " +
                    bedrijf.getZoekwoorden();

            if (tekstVanBedrijf.toLowerCase().contains(zoektermKlein)) {
                resultaten.add(bedrijf);
            }
        }
          return resultaten;
     }

     public void voegBedrijfToe(Bedrijf bedrijf) {

     }
}

