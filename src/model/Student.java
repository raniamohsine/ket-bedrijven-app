package model;

/**
 * Deze Klasse stelt een student voor.
 */

public class Student extends Gebruiker {

    public Student(String naam) {
        super(naam, GebruikersRol.STUDENT);
    }
}
