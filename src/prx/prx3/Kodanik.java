package prx.prx3;

class Kodanik {

    private String eesnimi;
    private String perenimi;
    private String isikukood;
    private boolean juhiluba;

    Kodanik(String eesnimi, String perenimi, String isikukood, boolean juhiluba) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.isikukood = isikukood;
        this.juhiluba = juhiluba;
    }

    public String getIsikukood() {
        return isikukood;
    }

    public boolean kasJuhilubaOnOlemas() {
        return juhiluba;
    }

    public boolean kasOnTäiskasvanuAastal2018() {
        String substring = isikukood.substring(1, 2);
        int age = Integer.parseInt(substring);
        return (30 <= age && age <= 2000);
    }

    public String toString() {
        StringBuilder nimi = new StringBuilder(50);
        nimi.append(eesnimi);
        nimi.append(" ");
        nimi.append(perenimi);
        return nimi.toString();
    }

    public static Kodanik valueOf(String rida) {
        String[] values = rida.split(",");
        return new Kodanik(values[1], values[0], values[2], values[3].equals("Olemas"));
    }
}
