package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.agents.PersonBuilder;
import pl.edu.pwr.simulation.events.Killer;
import pl.edu.pwr.simulation.events.Matchmaker;
import pl.edu.pwr.simulation.events.Pregnancy;
import pl.edu.pwr.simulation.output.ISimulationDumper;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final ISimulationDumper simulationDumper;
    private final Matchmaker matchmaker;
    private final Pregnancy pregnancy;
    private final Killer killer;
    private List<Person> personList;
    private final int numberOfEpoch;

    public Simulation(ISimulationDumper simulationOutput, int percentageOfMatch,
                      int percentageOfPregnancy, int percentageOfGeneDegradation,
                      int percentageOfDeath, int numberOfPeople, int numberOfEpoch
    ) {
        this.matchmaker = new Matchmaker(percentageOfMatch);
        this.pregnancy = new Pregnancy(percentageOfPregnancy, percentageOfGeneDegradation);
        this.killer = new Killer(percentageOfDeath);
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
        this.personList = this.killer.happen(this.personList);
        this.personList = this.pregnancy.happen(this.personList);
        this.personList = this.matchmaker.happen(this.personList);
        System.out.println(epochIndex + " => "+this.personList.size());
    }
    public void dumpData(){
        this.simulationDumper.dumpData(this.personList);
    }
}
