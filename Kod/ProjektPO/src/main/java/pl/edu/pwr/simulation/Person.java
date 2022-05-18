package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

public class Person {
    private int age=0;
    private Genotype genotype;
    private Person partner = null;
    public Person(){
        this.genotype = new GenotypeBuilder().build();
    }
    public Person(Genotype genotype) {
        this.genotype = genotype;
    }
    public void increaseAge(){
        ++age;
    }

    public int getAge() {
        return age;
    }

    public void setPartner(Person person){
        this.partner = person;
    }

    public Genotype getGenotype() {
        return genotype;
    }

    @Override
    public String toString() {
        return "Person{ "+this.age+": "+this.getGenotype()+" }";
    }
}
