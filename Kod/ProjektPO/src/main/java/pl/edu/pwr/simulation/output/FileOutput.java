package pl.edu.pwr.simulation.output;

import pl.edu.pwr.gson.GenotypeObjectRepository;
import pl.edu.pwr.simulation.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOutput implements ISimulationOutput{
    private final String fileName;

    public FileOutput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void dumpData(List<Person> personList){
        GenotypeObjectRepository genotypeObjectRepository = new GenotypeObjectRepository();
        genotypeObjectRepository.loadRepository(personList);

        try {
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(genotypeObjectRepository.getJsonString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Problem with saving to the file");
        }
    }
}
