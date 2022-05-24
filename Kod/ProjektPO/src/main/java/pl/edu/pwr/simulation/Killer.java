package pl.edu.pwr.simulation;

import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.simulation.probability.Probability;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Killer {
    ApplicationArguments applicationArguments;
    Probability probability;
    public Killer(ApplicationArguments applicationArguments, Probability probability) {
        this.applicationArguments = applicationArguments;
        this.probability = probability;
    }

    public List<Person> survivors(List<Person> personList){
        List<Person> newPersonList = new ArrayList<>();
        personList.forEach(person -> {
            if(person.getAge() <= person
                    .getGenotype()
                    .getGeneByType("maxAge")
                    .getGeneValue() || this.probability.percentage(applicationArguments.getPercentageOfDeath())){
                newPersonList.add(person);
            }
            else{
                if(person.getPartner()!=null)
                    person.getPartner().setPartner(null);
            }
        });
        return newPersonList;
    }
}
