package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.Genotype;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int age=0;
    private Genotype genotype;
    private Person[] parents;
    private List<Person> childred;

    public Person(Genotype genotype, Person[] parents) {
        this.parents = parents;
        this.childred = new ArrayList<>();
        this.genotype = genotype;
    }

    public int getAge() {
        return age;
    }

    public void addChild(Person child){
        this.childred.add(child);
    }
    public List<Person> getChildred() {
        return childred;
    }
    public void killChild(Person child){
        this.childred.remove(child);
    }

    public Person[] getParents() {
        return parents;
    }

    public Genotype getGenotype() {
        return genotype;
    }

    @Override
    public String toString() {
        return "Person{ "+this.age+": "+this.getGenotype()+" }";
    }
}
