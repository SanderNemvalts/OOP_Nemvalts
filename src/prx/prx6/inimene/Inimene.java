package prx.prx6.inimene;

import java.util.ArrayList;
import java.util.List;

public class Inimene {

    private String eesnimi;
    private String perenimi;
    private List<String> lasteNimed = new ArrayList<>();

    public Inimene(String eesnimi, String perenimi, List<String> lasteNimed) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.lasteNimed = lasteNimed;
    }

    public String getEesnimi() {
        return eesnimi;
    }

    public String getPerenimi() {
        return perenimi;
    }

    public List<String> getLasteNimed() {
        return lasteNimed;
    }

    @Override
    public String toString() {
        return eesnimi + " " + perenimi + " lapsed : " + lasteNimed.toString();
    }
}
