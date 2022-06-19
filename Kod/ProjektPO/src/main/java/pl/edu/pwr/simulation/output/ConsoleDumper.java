package pl.edu.pwr.simulation.output;

import pl.edu.pwr.gson.GenotypeObjectToJsonStringConverter;
import pl.edu.pwr.simulation.agents.Person;

import java.util.List;

public class ConsoleDumper implements ISimulationDumper {
    @Override
    public void dumpData(List<Person> personList) {
        GenotypeObjectToJsonStringConverter genotypeObjectRepository = new GenotypeObjectToJsonStringConverter();
        System.out.println(genotypeObjectRepository.getJsonString(personList));
    }
}
