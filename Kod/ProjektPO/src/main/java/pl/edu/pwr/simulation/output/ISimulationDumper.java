package pl.edu.pwr.simulation.output;

import pl.edu.pwr.simulation.agents.Person;

import java.util.List;

public interface ISimulationDumper {
    void dumpData(List<Person> personList);
}
