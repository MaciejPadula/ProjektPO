package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.agents.PersonBuilder;
import pl.edu.pwr.simulation.events.IEvent;
import pl.edu.pwr.simulation.events.Killer;
import pl.edu.pwr.simulation.events.Matchmaker;
import pl.edu.pwr.simulation.events.Pregnancy;
import pl.edu.pwr.simulation.output.ISimulationDumper;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final ISimulationDumper simulationDumper;
    private final List<IEvent> events;
    private List<Person> personList;
    private final int numberOfEpoch;

    public Simulation(ISimulationDumper simulationOutput,
                      List<IEvent> listOfEvents,
                      int numberOfPeople,
                      int numberOfEpoch
    ) {
        events = new ArrayList<>();
        events.addAll(listOfEvents);
        this.simulationDumper = simulationOutput;
        this.numberOfEpoch = numberOfEpoch;
        this.personList = new ArrayList<>();
        for(int i=0;i<numberOfPeople;++i){
            this.personList.add(new PersonBuilder().withRandomAge().build());
        }
    }
    public void simulate(){
        for(int i = 0; i< numberOfEpoch; ++i){
            epoch(i+1);
        }
    }
    private void epoch(int epochIndex){
        this.personList.forEach(person -> person.increaseAge());
        this.events.forEach(event -> this.personList = event.happen(this.personList));
        System.out.println(epochIndex + " => "+this.personList.size());
    }
    public void dumpData(){
        this.simulationDumper.dumpData(this.personList);
    }
}
