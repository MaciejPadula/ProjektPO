package pl.edu.pwr.simulation.utils;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.agents.PersonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains methods that manipulate person objects
 */
public class PersonUtils {
    private PersonUtils(){}

    /**
     * This static method creates list of random people
     * @param number Number of people to create
     * @return List of random people with size of number provided
     */
    public static List<Person> randomizeListOfPerson(int number){
        List<Person> listOfPerson = new ArrayList<>();
        for(int i=0;i<number;++i){
            listOfPerson.add(new PersonBuilder().build());
        }
        return listOfPerson;
    }
}
