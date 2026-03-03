package kdt.kdt2.sortedUniquePersonList;

public class Test2 {
    public static void main(String[] args) throws Exception {

        // template et testida SUPL massiliste suurustega

        SortedUniquePersonList supl = new SortedUniquePersonList();

        int genAmount = 10000;
        Person[] genPersons = new Person[genAmount];
        for (int i = 0; i < genAmount; i++) {
            genPersons[i] = new Person((int)(Math.random()*10000000), String.format("first%d", i), String.format("last%d", i));
        }

        for (Person person : genPersons) {
            supl.add(person);
        }

        int removeAmount = 1500;
        for (int i = 0; i < removeAmount; i++) {
            int removeId = genPersons[(int) (Math.random() * genAmount)].getIdCode();
            supl.removeElement(removeId);
        }


    }

    static void assertThat(String description, boolean isCorrect) throws Exception {
        if (!isCorrect)
            throw new Exception(description);
    }
}