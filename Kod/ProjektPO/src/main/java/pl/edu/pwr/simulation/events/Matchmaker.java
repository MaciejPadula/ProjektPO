package pl.edu.pwr.simulation.events;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.List;

public class Matchmaker implements IEvent{
    private final int percentageOfMatch;

    public Matchmaker(int percentageOfMatch) {
        this.percentageOfMatch = percentageOfMatch;
    }
    public List<Person> happen(List<Person> personList){
        personList.forEach(person1 -> {
            personList.forEach(person2 -> {
                if(!person1.hasPartner() && !person2.hasPartner() && person1!=person2){
                    match(person1, person2);
                }
            });
        });
        return personList;
    }
    private void match(Person person1, Person person2){
        if(Probability.getOutcome(this.percentageOfMatch)){
            if(person1.isAdult() && person2.isAdult()){
                person1.setPartner(person2);
                person2.setPartner(person1);
            }
        }
    }
}
