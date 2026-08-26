package model;

/**
 * Deze klasse stelt een student voor.
 */

public class Student extends Gebruiker {

    public Student(String naam) {
        super(naam, GebruikersRol.STUDENT);
    }
}
