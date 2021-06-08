import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Einleser einleser = new Einleser();
        LocalDate ld = einleser.getDate();

        Flugzeug flugzeug = new Flugzeug(ld);

        flugzeug.run();



    }

}
