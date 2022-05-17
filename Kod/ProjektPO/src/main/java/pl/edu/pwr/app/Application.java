package pl.edu.pwr.app;

import pl.edu.pwr.simulation.Person;
import pl.edu.pwr.simulation.PersonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        List<Person> list = new ArrayList<>();
        for(int i=0;i<20;++i){
            list.add(new PersonBuilder().build());
        }
        list.forEach(person -> System.out.println(person));
    }
}
