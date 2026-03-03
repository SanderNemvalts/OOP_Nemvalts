package prx.prx3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TranspordiametiKampaania {

    private static List<Kodanik> loeKodanikud(String failinimi) throws IOException {
        return Files.lines(Path.of(failinimi)).map(Kodanik::valueOf).toList();
    }

    private void printKodanikuInfo(Kodanik kodanik) {

    }

    public static void main(String[] args) throws IOException {

        List<Kodanik> kodanikud = loeKodanikud("src/prx/prx3/kodanikud.txt");

    }


}
