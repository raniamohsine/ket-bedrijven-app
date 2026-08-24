package model;

/**
 * Deze klasse stelt een bedrijf voor.
 */
public class Bedrijf {
    private String naam;
    private String contactPersoon;
    private String email;
    private String telefoonnummer;
    private String adres;
    private String omschrijving;
    private String zoekwoorden;

    public Bedrijf(String naam, String contactPersoon, String email,
                   String telefoonnummer, String adres,
                   String omschrijving, String zoekwoorden) {
        this.naam = naam;
        this.contactPersoon = contactPersoon;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
        this.adres = adres;
        this.omschrijving = omschrijving;
        this.zoekwoorden = zoekwoorden;
    }

    public String getNaam() {
        return naam;
    }

    public String getContactPersoon() {
        return contactPersoon;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public String getAdres() {
        return adres;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getZoekwoorden() {
        return zoekwoorden;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setContactPersoon(String contactPersoon) {
        this.contactPersoon = contactPersoon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public void setZoekwoorden(String zoekwoorden) {
        this.zoekwoorden = zoekwoorden;
    }

    @Override
    public String toString() {
        return "Bedrijf: " + naam +
                "\nContactpersoon: " + contactPersoon +
                "\nEmail: " + email +
                "\nTelefoonnummer: " + telefoonnummer +
                "\nAdres: " + adres +
                "\nOmschrijving: " + omschrijving;
    }
}