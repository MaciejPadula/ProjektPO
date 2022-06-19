package pl.edu.pwr.simulation.agents;

import pl.edu.pwr.simulation.genetics.Genotype;
/**
 * This class contains data of each person.
 */
public class Person {
    private int age;
    private final Genotype genotype;
    private Person partner = null;
    /**
     * @param age Age of person
     * @param genotype Genotype of person
     */
    public Person(int age, Genotype genotype) {
        this.age = age;
        this.genotype = genotype;
    }
    /**
     * This method determines persons age stage
     * @return If persons age is greater or equal to 18
     */
    public boolean isAdult(){
        return this.age>=18;
    }
    /**
     * This method determines persons age stage
     * @return If persons age is between 18 and 35 years
     */
    public boolean isYoungAdult(){
        return this.isAdult() && this.age<35;
    }
    /**
     * This method determines persons age stage
     * @return If persons age is between 35 and 40 years
     */
    public boolean isMiddleAged(){
        return this.age>=35 && this. age<40;
    }
    /**
     * This method determines persons age stage
     * @return If persons age is between 40 and 50 years
     */
    public boolean isElderlyAged(){
        return this.age>=40 && this.age<50;
    }
    /**
     * This method increases persons age
     */
    public void increaseAge(){
        this.age++;
    }
    /**
     * This method determines persons age
     * @return Persons age
     */
    public int getAge() {
        return this.age;
    }
    /**
     * Determines if person has a partner
     * @return True if persons partner exists
     */
    public boolean hasPartner(){
        return this.partner!=null;
    }
    /**
     * This method determines persons partner existence
     * @return Persons partner
     */
    public Person getPartner() {
        return this.partner;
    }
    /**
     * This method assigns new partner for this object
     * @param person New partner
     */
    public void setPartner(Person person){
        this.partner = person;
    }
    /**
     * This method determines persons genotype
     * @return Persons genotype
     */
    public Genotype getGenotype() {
        return this.genotype;
    }
    /**
     * This method determines persons gender
     * @return Persons gender gene value
     */
    public int getGender(){
        return this.genotype.getGender().getGeneData();
    }
    /**
     * This method determines gender
     * @param genderValue Value of gender gene to test
     * @return True if genderValue matches persons gender
     */
    public boolean is(int genderValue){
        return this.getGender() == genderValue;
    }
}
