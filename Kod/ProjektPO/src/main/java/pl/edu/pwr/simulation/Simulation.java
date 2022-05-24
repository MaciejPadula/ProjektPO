package pl.edu.pwr.simulation;

import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.simulation.probability.Probability;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends Probability {
    private final Probability probability;
    private final GenotypeMerge genotypeMerge;
    private final Matchmaker matchmaker;
    private final Pregnancy pregnancy;
    private final Killer killer;

    ApplicationArguments applicationArguments;
    private List<Person> personList;

    public Simulation(ApplicationArguments applicationArguments) {
        this.probability = new Probability();
        this.genotypeMerge = new GenotypeMerge(applicationArguments, probability);
        this.matchmaker = new Matchmaker(applicationArguments, probability);
        this.pregnancy = new Pregnancy();
        this.killer = new Killer(applicationArguments, probability);

        this.applicationArguments = applicationArguments;

        this.personList = new ArrayList<>();
        for(int i=0;i<applicationArguments.getNumberOfPeople();++i){
            this.personList.add(new Person());
        }
        System.out.println(this.personList);
    }

    public List<Person> simulate(){
        for(int i=0;i<applicationArguments.getNumberOfEpoch();++i){
            epoch(i+1);
        }
        return personList;
    }

    private void epoch(int epochIndex){
        personList.forEach(person -> person.increaseAge());
        this.personList = killer.survivors(this.personList);
        matchmaker.matchAll(this.personList);
        System.out.println(epochIndex + " => "+personList.size());
    }
}
