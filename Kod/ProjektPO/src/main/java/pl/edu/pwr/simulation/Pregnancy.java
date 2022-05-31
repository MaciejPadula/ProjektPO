package pl.edu.pwr.simulation;


import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.probability.Probability;

import java.util.ArrayList;
import java.util.List;

public class Pregnancy {
    private GenotypeMerge genotypeMerge;
    private ApplicationArguments applicationArguments;
    private Probability probability;
    public Pregnancy(ApplicationArguments applicationArguments, GenotypeMerge genotypeMerge, Probability probability) {
        this.genotypeMerge = genotypeMerge;
        this.applicationArguments = applicationArguments;
        this.probability = probability;
    }
    public List<Person> getNewborn(List<Person> personList){
        List<Person> people = new ArrayList<>();
        personList.forEach(person -> {
            if(person.getPartner()!=null){
                if(!people.contains(person.getPartner())){
                    people.add(person);
                }
            }
        });
        List<Person> newborn = new ArrayList<>();
        people.forEach(person -> {
            if(pregnancyChance(person)){
                newborn.add(pregnancy(person));
            }
            people.remove(person.getPartner());
        });
        return newborn;
    }
    private boolean pregnancyChance(Person person)
    {
        if(person.getGender()==2 || person.getPartner().getGender()==2){
            return false;
        }
        Person female;
        if(person.getGender()!=person.getPartner().getGender()){
            if(person.getGender()==1) {
                female = person;
            }
            else{
                female = person.getPartner();
            }
            if(female.getAge()>=18 && female.getAge()<35){
                return probability.percentage(applicationArguments.getPercentageOfPregnancy());
            }else if( female.getAge()>=35 && female.getAge()<40){
                return probability.percentage((applicationArguments.getPercentageOfPregnancy())/2);
            }else if(female.getAge()>=40 && female.getAge()<50){
                return probability.percentage((applicationArguments.getPercentageOfPregnancy())/5);
            }
        }
        return false;
    }
    private Person pregnancy(Person person){
        return new Person(genotypeMerge.mergeGenotype(
                person.getGenotype(),
                person.getPartner().getGenotype())
        );
    }
}
