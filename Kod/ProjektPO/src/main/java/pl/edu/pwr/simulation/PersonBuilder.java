package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

public class PersonBuilder extends Person {
    Genotype genotype;

    public PersonBuilder() {
        this.genotype = new GenotypeBuilder().build();
    }

    public PersonBuilder withGenotype(Genotype genotype){
        this.genotype = genotype;
        return this;
    }

    public Person build(){
        return new Person(genotype);
    }
}
