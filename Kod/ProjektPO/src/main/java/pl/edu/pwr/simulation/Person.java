package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.Genotype;

public class Person {
    private int age;
    private Genotype genotype;
    private Person partner = null;

    public Person(int age, Genotype genotype){
        this.age = age;
        this.genotype = genotype;
    }
    public boolean isAdult(){
        return this.age>=18;
    }
    public void increaseAge(){
        this.age++;
    }
    public int getAge() {
        return this.age;
    }
    public boolean hasPartner(){
        return this.partner!=null;
    }
    public Person getPartner() {
        return this.partner;
    }
    public void setPartner(Person person){
        this.partner = person;
    }
    public Genotype getGenotype() {
        return this.genotype;
    }
    public int getGender(){
        return this.genotype.getGender().getGeneData();
    }
}
