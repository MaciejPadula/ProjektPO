package pl.edu.pwr.simulation.output;

import pl.edu.pwr.gson.GenotypeJsonObject;
import pl.edu.pwr.simulation.Person;

import java.util.List;

public class ConsoleOutput implements ISimulationOutput{
    @Override
    public void dumpData(List<Person> personList) {
        personList.forEach(person -> {
            System.out.println(
                    gson.toJson(
                            new GenotypeJsonObject(person)
                    )
            );
        });
    }
}
