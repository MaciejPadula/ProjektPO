package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

public class PersonBuilder {
    private Person[] parents;
    private Genotype genotype = new GenotypeBuilder().build();

    public PersonBuilder withGenotype(Genotype genotype){
        this.genotype = genotype;
        return this;
    }
    public PersonBuilder withParents(Person[] parents){
        this.parents = parents;
        return this;
    }

    public Person build(){
        return new Person(genotype, parents);
    }
}
