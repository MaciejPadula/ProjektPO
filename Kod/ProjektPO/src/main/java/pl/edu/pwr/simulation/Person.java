package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.Genotype;

public class Person extends Genotype {
    private int age=0;
    private Genotype genotype;
    private Person partner = null;
    public Person(Genotype genotype) {
        this.genotype = genotype;
    }
    public void increseAge(){
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
