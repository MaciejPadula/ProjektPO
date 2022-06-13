package pl.edu.pwr.simulation.events;

import pl.edu.pwr.simulation.genetics.Gender;
import pl.edu.pwr.simulation.agents.PersonBuilder;
import pl.edu.pwr.simulation.genetics.GenotypeMerge;
import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.ArrayList;
import java.util.List;

public class Pregnancy implements IEvent{
    private GenotypeMerge genotypeMerge;
    int percentageOfPregnancy;

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
        if(person.is(Gender.unknown) || person.getPartner().is(Gender.unknown)){
            return false;
        }
        Person female = person;
        if(!person.is(person.getPartner().getGender())){
            if(female.is(Gender.male)) {
                female = person.getPartner();
            }
            if(female.isYoungAdult()){
                return Probability.getOutcome(this.percentageOfPregnancy);
            }else if(female.isMiddleAged()){
                return Probability.getOutcome((this.percentageOfPregnancy)/2);
            }else if(female.isElderlyAged()){
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
