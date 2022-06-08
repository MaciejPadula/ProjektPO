package pl.edu.pwr.simulation.output;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.edu.pwr.simulation.Person;

import java.util.List;

public interface ISimulationOutput {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    void dumpData(List<Person> personList);
}
