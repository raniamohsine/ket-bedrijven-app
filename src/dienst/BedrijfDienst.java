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

    /**
     * Voegt enkele testbedrijven toe aan de lijst.
     * Deze data wordt gebruikt om de applicatie te kunnen testen.
     */
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

    /**
     * Geeft alle bedrijven terug.
     *
     * @return lijst met alle bedrijven
     */
    public ArrayList<Bedrijf> getBedrijven() {
        return bedrijven;
    }

    /**
     * Zoekt bedrijven op basis van een zoekterm.
     * Er wordt gezocht in de naam, omschrijving en zoekwoorden.
     *
     * @param zoekterm de tekst waarop gezocht wordt
     * @return lijst met gevonden bedrijven
     */
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

    /**
     * Voegt een nieuw bedrijf toe aan de lijst.
     *
     * @param bedrijf het bedrijf dat toegevoegd wordt
     */
    public void voegBedrijfToe(Bedrijf bedrijf) {
        bedrijven.add(bedrijf);
    }

    /**
     * Zoekt een bedrijf op basis van de naam.
     *
     * @param naam de naam van het bedrijf
     * @return het gevonden bedrijf of null als het bedrijf niet bestaat
     */
    public Bedrijf zoekBedrijfOpNaam(String naam) {
        for (Bedrijf bedrijf : bedrijven) {
            if (bedrijf.getNaam().equalsIgnoreCase(naam)) {
                return bedrijf;
            }
        }

        return null;
    }

    /**
     * Verwijdert een bedrijf op basis van de naam.
     *
     * @param naam de naam van het bedrijf dat verwijderd moet worden
     * @return true als het bedrijf verwijderd is, anders false
     */
    public boolean verwijderBedrijfOpNaam(String naam) {
        for (int i = 0; i < bedrijven.size(); i++) {
            Bedrijf bedrijf = bedrijven.get(i);

            if (bedrijf.getNaam().equalsIgnoreCase(naam)) {
                bedrijven.remove(i);
                return true;
            }
        }

        return false;
    }
}