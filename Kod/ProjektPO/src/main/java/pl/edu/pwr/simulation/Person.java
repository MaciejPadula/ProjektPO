package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

import java.util.Random;

public class Person {
    private int age;
    private Genotype genotype;
    private Person partner = null;
    public Person(int age, Genotype genotype){
        this.age = age;
        this.genotype = genotype;
    }
    public void increaseAge(){
        ++age;
    }

    public int getAge() {
        return age;
    }

    public Person getPartner() {return partner;}

    public void setPartner(Person person){
        this.partner = person;
    }

    public Genotype getGenotype() {
        return genotype;
    }

    public int getGender(){
        return this.genotype.getGender().getGeneData();
    }

    public boolean isAdult(){
        return this.age>=18;
    }

    public boolean hasPartner(){
        return this.partner!=null;
    }
}
