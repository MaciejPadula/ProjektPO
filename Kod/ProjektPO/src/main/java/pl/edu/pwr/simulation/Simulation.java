package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.utils.PersonUtils;
import pl.edu.pwr.simulation.events.IEvent;
import pl.edu.pwr.simulation.output.ISimulationDumper;
import pl.edu.pwr.simulation.utils.SimulationPrinter;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final ISimulationDumper simulationDumper;
    private final List<IEvent> events;
    private List<Person> personList;
    private final int numberOfEpoch;
    private final SimulationPrinter simulationPrinter;
    public Simulation(ISimulationDumper simulationOutput,
                      SimulationPrinter simulationPrinter,
                      List<IEvent> listOfEvents,
                      int numberOfPeople,
                      int numberOfEpoch
    ) {
        events = new ArrayList<>();
        events.addAll(listOfEvents);
        this.simulationPrinter = simulationPrinter;
        this.simulationDumper = simulationOutput;
        this.numberOfEpoch = numberOfEpoch;
        this.personList = PersonUtils.randomizeListOfPerson(numberOfPeople);
    }
    public void simulate(){
        for(int i = 0; i< numberOfEpoch; ++i){
            epoch(i);
        }
    }
    private void epoch(int epochIndex){
        this.personList.forEach(Person::increaseAge);
        this.events.forEach(event -> this.personList = event.happen(this.personList));
        this.simulationPrinter.print(epochIndex, this.personList.size());
    }
    public void dumpData(){
        this.simulationDumper.dumpData(this.personList);
    }
}
