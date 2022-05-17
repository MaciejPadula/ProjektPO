package pl.edu.pwr.app;

import pl.edu.pwr.simulation.Simulation;

public class Application extends ArgumentParser {
    public static void main(String[] args){
        ArgumentParser argumentsParser= new ArgumentParser();
        Simulation simulation = new Simulation(50, 10);
        System.out.println(simulation.simulate());

    }
}
