package pl.edu.pwr.simulation.output;

import pl.edu.pwr.gson.GenotypeObjectToJsonStringConverter;
import pl.edu.pwr.simulation.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileDumper implements ISimulationDumper {
    private final String fileName;

    public FileDumper(String fileName) {
        this.fileName = fileName;
    }
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
