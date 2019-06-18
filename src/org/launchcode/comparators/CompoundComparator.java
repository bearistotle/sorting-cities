package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<City> {
    List<Comparator<City>> comparators = new ArrayList<>();

    public void add(Comparator<City> c){
        comparators.add(c);
    }

    @Override
    public int compare(City o1, City o2){

        int comparatorIdx = 0;
        int signum;

        do {
            Comparator<City> c = comparators.get(comparatorIdx);
            signum = c.compare(o1, o2);

        } while (signum == 0); {
            comparatorIdx++;
            Comparator<City> c = comparators.get(comparatorIdx);
            signum = c.compare(o1, o2);
        }

        return signum;
    }
}
