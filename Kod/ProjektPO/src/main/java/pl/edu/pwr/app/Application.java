package pl.edu.pwr.app;

import pl.edu.pwr.simulation.Simulation;

public class Application extends ArgumentParser {
    public static void main(String[] args){
        Simulation simulation = new Simulation(50, 10);
        System.out.println(simulation.simulate());
    }
}
