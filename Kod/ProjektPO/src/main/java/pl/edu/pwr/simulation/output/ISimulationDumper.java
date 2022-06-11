package pl.edu.pwr.simulation.output;

import pl.edu.pwr.simulation.Person;

import java.util.List;

public interface ISimulationDumper {
    void dumpData(List<Person> personList);
}
