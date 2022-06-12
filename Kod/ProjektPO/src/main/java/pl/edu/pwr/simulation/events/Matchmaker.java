package pl.edu.pwr.simulation.events;

import pl.edu.pwr.app.settings.ApplicationSettings;
import pl.edu.pwr.simulation.Person;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.List;

public class Matchmaker {
    int percentageOfMatch = 0;
    public Matchmaker(int percentageOfMatch) {
        this.percentageOfMatch = percentageOfMatch;
    }
    public void matchAll(List<Person> personList){
        personList.forEach(person1 -> {
            personList.forEach(person2 -> {
                if(!person1.hasPartner() && !person2.hasPartner() && person1!=person2){
                    match(person1, person2);
                }
            });
        });
    }
    private void match(Person person1, Person person2){
        if(Probability.getOutcome(percentageOfMatch)){
            if(person1.isAdult() && person2.isAdult()){
                person1.setPartner(person2);
                person2.setPartner(person1);
            }
        }
    }
}
