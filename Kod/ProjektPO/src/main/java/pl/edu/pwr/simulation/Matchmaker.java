package pl.edu.pwr.simulation;

import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.simulation.probability.Probability;

import java.util.List;

public class Matchmaker {
    ApplicationArguments applicationArguments;
    Probability probability;

    public Matchmaker(ApplicationArguments applicationArguments, Probability probability) {
        this.applicationArguments = applicationArguments;
        this.probability = probability;
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
    public void match(Person person1, Person person2){
        if(probability.percentage(applicationArguments.getPercentageOfMatch())){
            if(person1.getAge()>=18 && person2.getAge()>=18){
                person1.setPartner(person2);
                person2.setPartner(person1);
            }
        }
    }
}
