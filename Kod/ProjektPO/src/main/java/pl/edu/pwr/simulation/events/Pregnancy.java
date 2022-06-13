package pl.edu.pwr.simulation.events;

import pl.edu.pwr.simulation.genetics.Gender;
import pl.edu.pwr.simulation.agents.PersonBuilder;
import pl.edu.pwr.simulation.genetics.GenotypeMerge;
import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.ArrayList;
import java.util.List;

public class Pregnancy {
    private GenotypeMerge genotypeMerge;
    int percentageOfPregnancy = 0;

    public Pregnancy(int percentageOfPregnancy, int percentageOfGeneDegradation) {
        this.genotypeMerge = new GenotypeMerge(percentageOfGeneDegradation);
        this.percentageOfPregnancy = percentageOfPregnancy;
    }
    public List<Person> happen(List<Person> personList){
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
        personList.addAll(newborn);
        return personList;
    }
    private boolean pregnancyChance(Person person)
    {
        if(person.getGender()==Gender.unknown || person.getPartner().getGender()== Gender.unknown){
            return false;
        }
        Person female;
        if(person.getGender()!=person.getPartner().getGender()){
            if(person.getGender()==Gender.female) {
                female = person;
            }
            else{
                female = person.getPartner();
            }
            if(female.isAdult() && female.getAge()<35){
                return Probability.getOutcome(this.percentageOfPregnancy);
            }else if( female.getAge()>=35 && female.getAge()<40){
                return Probability.getOutcome((this.percentageOfPregnancy)/2);
            }else if(female.getAge()>=40 && female.getAge()<50){
                return Probability.getOutcome((this.percentageOfPregnancy)/5);
            }
        }
        return false;
    }
    private Person pregnancy(Person person){
        return new PersonBuilder().withGenotype(
            this.genotypeMerge.mergeGenotype(
                person.getGenotype(),
                person.getPartner().getGenotype()
            )
        ).build();
    }
}
