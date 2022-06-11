package pl.edu.pwr.simulation.events;


import pl.edu.pwr.app.settings.ApplicationSettings;
import pl.edu.pwr.simulation.genetics.GenotypeMerge;
import pl.edu.pwr.simulation.Person;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.ArrayList;
import java.util.List;

public class Pregnancy {
    private GenotypeMerge genotypeMerge;
    private ApplicationSettings applicationSettings;
    public Pregnancy(ApplicationSettings applicationSettings) {
        this.applicationSettings = applicationSettings;
        genotypeMerge = new GenotypeMerge(applicationSettings);
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
                return Probability.getOutcome(applicationSettings.getPercentageOfPregnancy());
            }else if( female.getAge()>=35 && female.getAge()<40){
                return Probability.getOutcome((applicationSettings.getPercentageOfPregnancy())/2);
            }else if(female.getAge()>=40 && female.getAge()<50){
                return Probability.getOutcome((applicationSettings.getPercentageOfPregnancy())/5);
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
