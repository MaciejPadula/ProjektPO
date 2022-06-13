package pl.edu.pwr.simulation.agents;

import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

import java.util.Random;

public class PersonBuilder {
    private int age;
    private Genotype genotype;

    public PersonBuilder() {
        this.age = 0;
        this.genotype = new GenotypeBuilder().build();
    }
    public PersonBuilder withAge(int age){
        this.age = age;
        return this;
    }
    public PersonBuilder withRandomAge(){
        this.age = new Random().nextInt(40);
        return this;
    }
    public PersonBuilder withGenotype(Genotype genotype){
        this.genotype = genotype;
        return this;
    }
    public Person build(){
        return new Person(this.age, this.genotype);
    }
}
