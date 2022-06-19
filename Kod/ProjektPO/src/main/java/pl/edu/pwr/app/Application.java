package pl.edu.pwr.app;

import pl.edu.pwr.simulation.Simulation;
import pl.edu.pwr.simulation.SimulationConfigurer;

public class Application {
    /**
     * This static method runs whole application
     * @param args Application arguments
     */
    public static void main(String[] args){
        Simulation simulation = SimulationConfigurer.configure();
        simulation.simulate();
        simulation.dumpData();
    }
}
