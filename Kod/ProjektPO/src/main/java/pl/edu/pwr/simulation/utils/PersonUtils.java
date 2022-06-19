package pl.edu.pwr.simulation.utils;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.agents.PersonBuilder;

import java.util.ArrayList;
import java.util.List;


public class PersonUtils {
    private PersonUtils(){}
    public static List<Person> randomizeListOfPerson(int number){
        List<Person> listOfPerson = new ArrayList<>();
        for(int i=0;i<number;++i){
            listOfPerson.add(new PersonBuilder().build());
        }
        return listOfPerson;
    }
}
