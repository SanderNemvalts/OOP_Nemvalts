package kdt.kdt2.sortedUniquePersonList;

import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Math.round;

public class SortedUniquePersonList {

    private Person[] main_array = new Person[1];
    private int person_count = 0;
    private final HashMap<Integer, Integer> id_map = new HashMap<>(); // key: ID | Value: index

    public Person getElementAt(int index) {
        if (index + 1 <= person_count && index >= 0) {
            return main_array[index];
        } else {return null;}
    }

    public int indexOf(int idCode) {
        if (id_map.get(idCode) == null) {return -1;}
        else {return id_map.get(idCode);}
    }

    public boolean add(Person person) {

        int new_person_id = person.getIdCode();
        int new_person_index = -1;

        if (id_map.containsKey(new_person_id)) {return false;}

        // check size of array and expand if needed
        if (main_array.length <= person_count + 1) {
            /*  veidi array suuruse arvutamisest: iga array suuruse muutmisega sihin umbes 1.5x
                person objektide arvust, mida hoiustatakse, sest siis ei tehta ülemääraseid array kopeerimisi.
                tehtest: '+1' veendub, et 0 inimse korral on arrayl ikka pikkus, kordaja 1.45 laseb ühe inimese
                korral korrutise alla ümardada ja seega +1 ei löö lõhki nõuet main_array.lenght <= 2*person_count */
            main_array = Arrays.copyOf(main_array, (int)round(person_count * 1.45 + 1));
        }

        // look for insert location
        for (int i = 0; i < person_count; i++) {
            if (new_person_id < main_array[i].getIdCode()) {

                new_person_index = id_map.get(main_array[i].getIdCode());

                // shift everyone with higher id
                for (int j = person_count; j > new_person_index; j--) {
                    main_array[j] = main_array[j - 1];
                    id_map.put(main_array[j].getIdCode(), j);
                }

                break;
            }
        }

        // if new id is largest, set as last element
        if (new_person_index == -1) {
            new_person_index = person_count;
        }

        // insert new person
        main_array[new_person_index] = person;
        id_map.put(new_person_id, new_person_index);
        person_count++;
        return true;
    }

    public boolean removeElement(int idCode) {

        if (!id_map.containsKey(idCode)) {return false;}

        int removed_index = id_map.get(idCode);

        // shift everyone
        for (int i = removed_index; i < person_count - 1; i++) {
            main_array[i] = main_array[i + 1];
            id_map.put(main_array[i].getIdCode(), i);
        }
        main_array[person_count - 1] = null;
        person_count--;
        id_map.remove(idCode);


        // check and fix array size
        if (main_array.length > 2*person_count) {
            main_array = Arrays.copyOf(main_array, (int)round(person_count*1.45 + 1));
        }

        return true;
    }

    /**
     * Calculates and returns the size of the collection.
     * @return Number of elements in the collection.
     */
    public int size() {
        return person_count;
    }
}