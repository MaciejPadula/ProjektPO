package pl.edu.pwr.app;

import pl.edu.pwr.app.arguments.ArgumentParser;
import pl.edu.pwr.simulation.Simulation;


public class Application extends ArgumentParser {
    public static void main(String[] args){
        Simulation simulation = new SimulationConfigurer().configure();
        simulation.simulate();
        simulation.dumpData();
    }
}
