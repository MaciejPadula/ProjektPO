package pl.edu.pwr.simulation.output;

import pl.edu.pwr.gson.GenotypeObjectToJsonStringConverter;
import pl.edu.pwr.simulation.agents.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 * This class handle dumping data to file
 */
public class FileDumper implements ISimulationDumper {
    private final String fileName;
    /**
     * @param fileName Name of file to which data will be written
     */
    public FileDumper(String fileName) {
        this.fileName = fileName;
    }
    /**
     * This method dumps data to file of injected filename
     * @param personList List of people
     */
    @Override
    public void dumpData(List<Person> personList){
        GenotypeObjectToJsonStringConverter genotypeObjectRepository = new GenotypeObjectToJsonStringConverter();
        try {
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(genotypeObjectRepository.getJsonString(personList));
            writer.close();
        } catch (IOException e) {
            System.out.println("Problem with saving to the file");
        }
    }
}
