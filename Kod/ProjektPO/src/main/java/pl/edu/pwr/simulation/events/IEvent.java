package pl.edu.pwr.simulation.events;

import pl.edu.pwr.simulation.agents.Person;

import java.util.List;

public interface IEvent {
    List<Person> happen(List<Person> personList);
}
