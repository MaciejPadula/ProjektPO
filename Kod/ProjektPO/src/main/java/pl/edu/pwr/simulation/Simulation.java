package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.utils.PersonUtils;
import pl.edu.pwr.simulation.events.IEvent;
import pl.edu.pwr.simulation.output.ISimulationDumper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Main simulation class
 */
public class Simulation {
    private final ISimulationDumper simulationDumper;
    private final List<IEvent> events;
    private List<Person> personList;
    private final int numberOfEpoch;
    /**
     * This method is responsible for handling all events included in the constructor
     * @param simulationOutput Interface that handles dumping data
     * @param listOfEvents list of events
     * @param numberOfEpoch number of epoch that simulation will simulate
     * @param numberOfPeople number of people before simulation start
     */
    public Simulation(ISimulationDumper simulationOutput,
                      List<IEvent> listOfEvents,
                      int numberOfPeople,
                      int numberOfEpoch
    ) {
        events = new ArrayList<>();
        events.addAll(listOfEvents);
        this.simulationDumper = simulationOutput;
        this.numberOfEpoch = numberOfEpoch;
        this.personList = PersonUtils.randomizeListOfPerson(numberOfPeople);
    }
    /**
     * This method starts the simulation.
     */
    public void simulate(){
        for(int i = 0; i< numberOfEpoch; ++i){
            epoch(i+1);
        }
    }
    private void epoch(int epochIndex){
        this.personList.forEach(person -> person.increaseAge());
        this.events.forEach(event -> this.personList = event.happen(this.personList));
    }
    /**
     * This method dumps data returned from simulation to output injected in the constructor.
     */
    public void dumpData(){
        this.simulationDumper.dumpData(this.personList);
    }
}
