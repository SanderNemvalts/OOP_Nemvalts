package prx.prx6.yl4;

public class AineHinne {

    private String nimetus;
    private char hinne;

    public AineHinne(String nimetus, char hinne) {
        this.nimetus = nimetus;
        this. hinne = hinne;
    }

    public AineHinne(String nimetus, String[] punktid) {
        this.nimetus = nimetus;
        this.hinne = hinnePunktideMassiivist(punktid);
    }

    public char getHinne() {
        return hinne;
    }
    public String getNimetus() {
        return nimetus;
    }
    @Override
    public String toString() {
        return nimetus + " | " + hinne;
    }

    private char hinnePunktideMassiivist(String[] punktid) {
        double sum = 0;
        for (String s : punktid) sum += Double.parseDouble(s);

        if (sum > 90) return 'A';
        if (sum > 80) return 'B';
        if (sum > 70) return 'C';
        if (sum > 60) return 'D';
        if (sum >= 51) return 'E';
        return 'F';
    }

}
