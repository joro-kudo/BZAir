import java.time.LocalDate;

public class Flugzeug {
    private final LocalDate ld;

    public Flugzeug(LocalDate ld) {
        this.ld = ld;
    }

    Passagier[][] passagier = new Passagier[4][40];
    int badrow = 5;
    int badseat = 3;


    public void run() {
        for (int j = 0; j < 40; j++) {

            for (int i = 0; i < 4; i++) {
                String hull;
                String hull2;
                int month = (int) Math.floor(Math.random() * (12 - 1 + 1) + 1);
                int day = (int) Math.floor(Math.random() * (28 - 1 + 1) + 1);
                int year = (int) Math.floor(Math.random() * (2021 - 1900 + 1) + 1900);

                LocalDate localDate = LocalDate.of(year, month, day);
                if (i == badseat && j == badrow) {
                    passagier[i][j] = new Passagier(j, i, Infected.INFECTED, "Lukas", "Müller", ld);
                    hull = " " + Const.ANSI_BRIGHT_BG_RED + "[";
                    hull2 = "]" + Const.ANSI_RESET + " ";

                } else if ((j == badrow - 1 || j == badrow + 1 || j == badrow) && (i == badseat - 1 || i == badseat + 1 || i == badseat)) {

                    passagier[i][j] = new Passagier(j, i, Infected.CONTRACTED, "Max", "Peter", localDate);
                    hull = " " + Const.ANSI_BRIGHT_BG_YELLOW + "{";
                    hull2 = "}" + Const.ANSI_RESET + " ";
                } else {

                    passagier[i][j] = new Passagier(j, i, Infected.CLEAN, "Martin", "Meier", localDate);

                    hull = " " + Const.ANSI_BRIGHT_BG_GREEN + "(";
                    hull2 = ")" + Const.ANSI_RESET + " ";


                }
                Passagier pass = passagier[i][j];
                String txtcolor;
                if (!(2021 - pass.getGeburtsdatum().getYear() >= 80)) {

                    txtcolor = Const.ANSI_BLACK;

                } else {
                    txtcolor = switch (pass.isInfected()) {
                        case CONTRACTED, INFECTED -> Const.ANSI_PURPLE;
                        case CLEAN -> Const.ANSI_BRIGHT_RED;

                    };
                }
                System.out.print(txtcolor + hull + pass.getVorname().charAt(0) + "." + pass.getNachname().charAt(0) + ", " + pass.getGeburtsdatum().getYear() + hull2);


            }
            System.out.println();
        }
        System.out.println();
        System.out.print(" " + Const.ANSI_BRIGHT_BG_GREEN + Const.ANSI_BLACK + "Negativ" + Const.ANSI_RESET + " ");
        System.out.print(Const.ANSI_BRIGHT_BG_RED + Const.ANSI_BLACK + "Positiv" + Const.ANSI_RESET + " ");
        System.out.print(Const.ANSI_BRIGHT_BG_YELLOW + Const.ANSI_BLACK + "Angesteckt" + Const.ANSI_RESET + " ");
        System.out.print(Const.ANSI_BRIGHT_RED + Const.ANSI_BG_BLACK + "Risiko" + Const.ANSI_RESET + " ");
        System.out.print(Const.ANSI_PURPLE + Const.ANSI_BG_BLACK + "Angesteckt Risiko" + Const.ANSI_RESET + " ");

    }
}
