package pl.edu.pwr.simulation.events;

import pl.edu.pwr.app.settings.ApplicationSettings;
import pl.edu.pwr.simulation.Person;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.List;

public class Matchmaker {
    ApplicationSettings applicationSettings;

    public Matchmaker(ApplicationSettings applicationArguments) {
        this.applicationSettings = applicationArguments;
    }
    public void matchAll(List<Person> personList){
        personList.forEach(person1 -> {
            personList.forEach(person2 -> {
                if(person1.getPartner() == null && person2.getPartner() == null && person1!=person2){
                    match(person1, person2);
                }
            });
        });
    }
    private void match(Person person1, Person person2){
        if(Probability.getOutcome(applicationSettings.getPercentageOfMatch())){
            if(person1.getAge()>=18 && person2.getAge()>=18){
                person1.setPartner(person2);
                person2.setPartner(person1);
            }
        }
    }
}
