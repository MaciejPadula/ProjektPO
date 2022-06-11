package pl.edu.pwr.simulation;

import pl.edu.pwr.app.settings.ApplicationSettings;
import pl.edu.pwr.simulation.events.Killer;
import pl.edu.pwr.simulation.events.Matchmaker;
import pl.edu.pwr.simulation.events.Pregnancy;
import pl.edu.pwr.simulation.output.ISimulationDumper;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends Probability {
    private final ISimulationDumper simulationDumper;
    private final ApplicationSettings applicationArguments;
    private final Matchmaker matchmaker;
    private final Pregnancy pregnancy;
    private final Killer killer;

    private List<Person> personList;

    public Simulation(ApplicationSettings applicationArguments, ISimulationDumper simulationOutput) {
        this.applicationArguments = applicationArguments;
        this.matchmaker = new Matchmaker(applicationArguments);
        this.pregnancy = new Pregnancy(this.applicationArguments);
        this.killer = new Killer(applicationArguments);
        this.simulationDumper = simulationOutput;

        this.personList = new ArrayList<>();
        for(int i=0;i<applicationArguments.getNumberOfPeople();++i){
            this.personList.add(new Person());
        }
    }

    public void simulate(){
        for(int i=0;i<applicationArguments.getNumberOfEpoch();++i){
            epoch(i+1);
        }
    }

    private void epoch(int epochIndex){
        personList.forEach(person -> person.increaseAge());
        this.personList = killer.survivors(this.personList);
        personList.addAll(pregnancy.getNewborn(personList));
        matchmaker.matchAll(this.personList);
        System.out.println(epochIndex + " => "+personList.size());
    }

    public void dumpData(){
        this.simulationDumper.dumpData(this.personList);
    }
}
