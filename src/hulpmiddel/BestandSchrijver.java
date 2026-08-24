package hulpmiddel;

import model.Bedrijf;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Deze klasse schrijft bedrijven naar een tekstbestand.
 */
public class BestandSchrijver {

    public void schrijfBedrijvenNaarBestand(ArrayList<Bedrijf> bedrijven, String bestandsNaam) {
        try (FileWriter writer = new FileWriter(bestandsNaam)) {

            if (bedrijven.isEmpty()) {
                writer.write("Geen bedrijven gevonden.");
            } else {
                for (Bedrijf bedrijf : bedrijven) {
                    writer.write("--------------------\n");
                    writer.write(bedrijf.toString());
                    writer.write("\n");
                }
            }

            System.out.println("Resultaten zijn opgeslagen in " + bestandsNaam);

        } catch (IOException e) {
            System.out.println("Er ging iets mis bij het schrijven naar het bestand.");
        }
    }
}
