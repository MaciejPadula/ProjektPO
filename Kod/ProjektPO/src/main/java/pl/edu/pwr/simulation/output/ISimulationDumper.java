package pl.edu.pwr.simulation.output;

import pl.edu.pwr.simulation.agents.Person;

import java.util.List;

/**
 * This interface will handle dumping data
 */
public interface ISimulationDumper {
    /**
     * This method will dump data depending on selected class
     * @param personList List of people
     */
    void dumpData(List<Person> personList);
}
