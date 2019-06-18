package org.launchcode;

import org.launchcode.comparators.NameComparator;
import org.launchcode.comparators.PopulationComparator;
import org.launchcode.comparators.StateComparator;
import org.launchcode.comparators.AreaComparator;
import org.launchcode.comparators.CompoundComparator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<City> cities = CityData.loadData();

        // TODO - Use different comparators here
        StateComparator stateComparator = new StateComparator();
        PopulationComparator populationComparator = new PopulationComparator();
        CompoundComparator compoundComparator = new CompoundComparator();
        compoundComparator.add(stateComparator);
        compoundComparator.add(populationComparator);
        cities.sort(compoundComparator);

        printCities(cities);

    }

    private static void printCities(ArrayList<City> cities) {

        System.out.println(City.getTableHeader());

        for(City c : cities) {
            System.out.println(c);
        }

    }
}
