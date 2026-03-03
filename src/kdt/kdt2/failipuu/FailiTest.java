package kdt.kdt2.failipuu;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailiTest {

    static void main(String[] args) throws Exception {
        Path failiPath = Path.of(args[0]);
        if (!Files.isDirectory(failiPath)) {
            System.out.println("Path ei viita kaustale");
            return;
        }

        FailiVaatleja failiVaatleja = new FailiVaatleja(new ArrayList<>());
        Files.walkFileTree(failiPath, failiVaatleja);

        List<String> failiNimed = failiVaatleja.getFailiNimed();
        NimeVordleja nimeVordleja = new NimeVordleja();

        Collections.sort(failiNimed, nimeVordleja);

        for (String s: failiNimed){
            System.out.println(s);
        }

    }


}
