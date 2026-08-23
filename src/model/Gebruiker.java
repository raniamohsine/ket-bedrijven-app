package model;

/**
 * Basisklasse voor alle gebruikers van de applicatie.
 */

public abstract class Gebruiker {
    private String naam;
    private GebruikersRol rol;
    public Gebruiker(String naam, GebruikersRol rol) {
        this.naam = naam;
        this.rol = rol;
    }

    public String getNaam() {
        return naam;
    }
    public GebruikersRol getRol() {
        return rol;
    }
}
