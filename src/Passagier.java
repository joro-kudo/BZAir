import java.time.LocalDate;
import java.util.Scanner;


public class Passagier {




    static Scanner scanner;

    private final Infected infected;
    private final String vorname;
    private final String nachname;
    private final LocalDate geburtsdatum;

    public Passagier(int sitzreihe, int sitznummer, Infected infected,String Vorname, String Nachname, LocalDate Geburtsdatum) {

        this.infected = infected;
        this.vorname = Vorname;
        this.nachname = Nachname;
        this.geburtsdatum = Geburtsdatum;
        scanner = new Scanner(System.in);

    }


    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }


    public String getNachname() {
        return nachname;
    }


    public String getVorname() {
        return vorname;
    }



    public Infected isInfected() {
        return infected;
    }


}