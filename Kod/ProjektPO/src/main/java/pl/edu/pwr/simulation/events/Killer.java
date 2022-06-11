package pl.edu.pwr.simulation.events;

import pl.edu.pwr.app.settings.ApplicationSettings;
import pl.edu.pwr.simulation.Person;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.ArrayList;
import java.util.List;

public class Killer {
    ApplicationSettings applicationSettings;
    public Killer(ApplicationSettings applicationArguments) {
        this.applicationSettings = applicationArguments;
    }

    public List<Person> survivors(List<Person> personList){
        List<Person> newPersonList = new ArrayList<>();
        personList.forEach(person -> {
            if(person.getAge() <= person
                    .getGenotype()
                    .getMaxAge()
                    .getGeneData() || Probability.getOutcome(applicationSettings.getPercentageOfDeath())){
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
