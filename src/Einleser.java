import java.time.LocalDate;
import java.util.Scanner;

public class Einleser {

    private Scanner scanner;

    public Einleser() {
        scanner = new Scanner(System.in);
    }


    // Methoden für Int --> Kann auch so für Double umgesetzt werden
    public int readInt() {
        while (!scanner.hasNextInt()) {
            System.err.println("Bitte Ganzzahl eingeben");
            scanner.nextLine();
        }
        int zahl = scanner.nextInt();
        scanner.nextLine(); // Löscht das "\n" Zeichen aus dem Scanner
        return zahl;
    }

    public int readInt(String text) {
        System.out.print(text + " > ");
        return readInt();
    }

    public int readInt(String text, int from, int to) {
        System.out.print(text + " (" + from + "-" + to + ") > ");

        int zahl = readInt();
        while (zahl < from || zahl > to) {
            System.out.println("Zahl ausserhalb des zulässigen Bereiches");
            System.out.print(text + " (" + from + "-" + to + ") > ");
            zahl = readInt();
        }
        return zahl;
    }

    // Methoden für char
    public char readChar() {
        String input = scanner.nextLine();
        while (input.length() != 1) {
            System.out.println("Bitte ein Zeichen eingeben");
            input = scanner.nextLine();
        }
        return input.charAt(0);
    }

    public char readChar(String text) {
        System.out.print(text + " > ");
        return readChar();
    }

    // Methoden für String
    public String readString() {
        return scanner.nextLine();
    }

    // Methoden für Datum
    public LocalDate getDate() {
        int tag, monat, jahr;
        jahr = readInt("Geben Sie das Jahr an");
        monat = readInt("Geben Sie den Monat an", 1, 12);
        tag = readInt("Geben Sie den Tag an", 1, 31);

        return LocalDate.of(jahr, monat, tag);
    }


}
