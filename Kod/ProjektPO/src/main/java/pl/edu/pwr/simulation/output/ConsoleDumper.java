package pl.edu.pwr.simulation.output;

import pl.edu.pwr.gson.GenotypeObjectToJsonStringConverter;
import pl.edu.pwr.simulation.agents.Person;

import java.util.List;
/**
 * This class handle dumping data to console
 */
public class ConsoleDumper implements ISimulationDumper {
    /**
     * This method dumps data to console screen
     * @param personList List of people
     */
    @Override
    public void dumpData(List<Person> personList) {
        GenotypeObjectToJsonStringConverter genotypeObjectRepository = new GenotypeObjectToJsonStringConverter();
        System.out.println(genotypeObjectRepository.getJsonString(personList));
    }
}
