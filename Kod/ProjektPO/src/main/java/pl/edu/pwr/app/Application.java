package pl.edu.pwr.app;

import pl.edu.pwr.simulation.Simulation;

public class Application extends ArgumentParser {
    public static void main(String[] args){
        ApplicationArguments applicationArguments = new ArgumentParser().parse(args);
        Simulation simulation = new Simulation(applicationArguments);
        System.out.println(simulation.simulate());
    }
}
