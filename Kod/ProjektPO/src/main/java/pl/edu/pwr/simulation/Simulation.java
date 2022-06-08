package pl.edu.pwr.simulation;

import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.simulation.events.Killer;
import pl.edu.pwr.simulation.events.Matchmaker;
import pl.edu.pwr.simulation.events.Pregnancy;
import pl.edu.pwr.simulation.genetics.GenotypeMerge;
import pl.edu.pwr.simulation.output.ISimulationOutput;
import pl.edu.pwr.simulation.probability.Probability;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends Probability {
    private final Probability probability;
    private final GenotypeMerge genotypeMerge;
    private final Matchmaker matchmaker;
    private final Pregnancy pregnancy;
    private final Killer killer;
    private ISimulationOutput simulationOutput;
    ApplicationArguments applicationArguments;
    private List<Person> personList;

    public Simulation(ApplicationArguments applicationArguments, ISimulationOutput simulationOutput) {
        this.applicationArguments = applicationArguments;
        this.probability = new Probability();
        this.genotypeMerge = new GenotypeMerge(applicationArguments, probability);
        this.matchmaker = new Matchmaker(applicationArguments, probability);
        this.pregnancy = new Pregnancy(this.applicationArguments, this.genotypeMerge, this.probability);
        this.killer = new Killer(applicationArguments, probability);
        this.simulationOutput = simulationOutput;
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

    public List<Integer> getHeights(){
        List<Integer> heights = new ArrayList<>();
        this.personList.forEach(person -> heights.add(person.getGenotype().getHeight().getGeneData()));
        return heights;
    }

    public void dumpData(){
        this.simulationOutput.dumpData(this.personList);
    }
}
