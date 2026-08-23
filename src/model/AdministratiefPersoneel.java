package model;

/**
 * Deze klasse stelt administratief personeel voor.
 */
public class AdministratiefPersoneel extends Gebruiker {


    public AdministratiefPersoneel(String naam) {
        super(naam, GebruikersRol.ADMINISTRATIEF_PERSONEEL);
    }
}
