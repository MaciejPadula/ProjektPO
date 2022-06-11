package pl.edu.pwr.app;

import pl.edu.pwr.simulation.Simulation;
import pl.edu.pwr.simulation.SimulationConfigurer;


public class Application {
    public static void main(String[] args){
        Simulation simulation = SimulationConfigurer.configure();
        simulation.simulate();
        simulation.dumpData();
    }
}
