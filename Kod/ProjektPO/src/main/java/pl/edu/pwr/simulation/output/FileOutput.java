package pl.edu.pwr.simulation.output;

import pl.edu.pwr.simulation.Person;

import java.util.List;

public class FileOutput implements ISimulationOutput{
    private final String filename;

    public FileOutput(String filename) {
        this.filename = filename;
    }

    @Override
    public void dumpData(List<Person> personList) {

    }
}
