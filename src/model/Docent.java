package model;

/**
 * Deze klasse stelt een docent voor.
 */

public class Docent extends Gebruiker{

    public Docent(String naam) {
          super(naam, GebruikersRol.DOCENT);
    }
}