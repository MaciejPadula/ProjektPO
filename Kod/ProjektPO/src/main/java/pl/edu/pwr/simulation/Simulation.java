package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.probability.Probability;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Simulation extends Probability {
    private final Probability probability;
    private final GenotypeMerge genotypeMerge;
    private final int epoches;
    private List<Person> personList;

    public Simulation(int epoches, int startingPersonCount) {
        this.probability = new Probability();
        this.genotypeMerge = new GenotypeMerge();
        this.epoches = epoches;
        this.personList = new ArrayList<>();
        for(int i=0;i<startingPersonCount;++i){
            this.personList.add(new PersonBuilder().build());
        }
        System.out.println(this.personList);
    }

    public List<Person> simulate(){
        for(int i=0;i<epoches;++i){
            epoch(i+1);
        }
        return personList;
    }

    private void epoch(int epochIndex){
        personList.forEach(person -> person.increseAge());
        this.personList = survivors();
        System.out.println(epochIndex+" => "+personList.size());
    }

    public List<Person> survivors(){
        return personList
                .stream()
                .filter(person -> person.getAge() <= person
                        .getGenotype()
                        .getGeneByType("maxAge")
                        .getGeneValue() || this.probability.percentage(10))///10% na losowa smierc
                .collect(Collectors.toList());
    }
}
