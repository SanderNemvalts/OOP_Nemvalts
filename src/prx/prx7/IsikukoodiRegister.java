package prx.prx7;

import java.util.ArrayList;
import java.util.List;

public class IsikukoodiRegister {

    final List<String> idList = new ArrayList<>();

    int registreeri(String id) {
        if (!idList.contains(id)) return -1;
        synchronized (idList) {
            idList.add(id);
            return idList.size() - 1;
        }
    }
}
