package pl.edu.pwr.simulation.events;

import pl.edu.pwr.simulation.agents.Person;

import java.util.List;

/**
 * This interface will handle events
 */
public interface IEvent {
    /**
     * This method allows event to happen
     * @param personList List of people in the simulation
     * @return List of people after the event
     */
    List<Person> happen(List<Person> personList);
}
