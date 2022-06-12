package pl.edu.pwr.simulation;

import pl.edu.pwr.app.settings.ApplicationSettings;
import pl.edu.pwr.simulation.events.Killer;
import pl.edu.pwr.simulation.events.Matchmaker;
import pl.edu.pwr.simulation.events.Pregnancy;
import pl.edu.pwr.simulation.output.ISimulationDumper;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final ISimulationDumper simulationDumper;
    private final ApplicationSettings applicationArguments;
    private final Matchmaker matchmaker;
    private final Pregnancy pregnancy;
    private final Killer killer;
    private List<Person> personList;

    public Simulation(ApplicationSettings applicationArguments, ISimulationDumper simulationOutput) {
        this.applicationArguments = applicationArguments;
        this.matchmaker = new Matchmaker(this.applicationArguments.getPercentageOfMatch());
        this.pregnancy = new Pregnancy(this.applicationArguments.getPercentageOfPregnancy(), this.applicationArguments.getPercentageOfGeneDegradation());
        this.killer = new Killer(this.applicationArguments.getPercentageOfDeath());
        this.simulationDumper = simulationOutput;

        this.personList = new ArrayList<>();
        for(int i=0;i<applicationArguments.getNumberOfPeople();++i){
            this.personList.add(PersonCreator.createRandom());
        }
    }
    public void simulate(){
        for(int i=0;i<applicationArguments.getNumberOfEpoch();++i){
            epoch(i+1);
        }
    }
    private void epoch(int epochIndex){
        this.personList.forEach(person -> person.increaseAge());
        this.personList = this.killer.survivors(this.personList);
        this.personList.addAll(this.pregnancy.getNewborn(personList));
        this.matchmaker.matchAll(this.personList);
        System.out.println(epochIndex + " => "+this.personList.size());
    }
    public void dumpData(){
        this.simulationDumper.dumpData(this.personList);
    }
}
