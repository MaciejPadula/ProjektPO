package pl.edu.pwr.simulation.events;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.utils.Probability;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that removes agents from the simulation
 */
public class Killer implements IEvent{
    private final int percentageOfDeath;

    /**
     * Killer constructor
     * @param percentageOfDeath Percentage change of random death
     */
    public Killer(int percentageOfDeath) {
        this.percentageOfDeath = percentageOfDeath;
    }

    public List<Person> happen(List<Person> personList){
        List<Person> newPersonList = new ArrayList<>();
        personList.forEach(person -> {
            if(person.getAge() <= person
                    .getGenotype()
                    .getMaxAge()
                    .getGeneData() || Probability.getOutcome(this.percentageOfDeath)){
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
