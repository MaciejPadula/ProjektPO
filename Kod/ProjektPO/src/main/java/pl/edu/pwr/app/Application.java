package pl.edu.pwr.app;

import com.typesafe.config.ConfigFactory;
import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.app.arguments.ArgumentParser;
import pl.edu.pwr.simulation.Simulation;

public class Application extends ArgumentParser {
    public static void main(String[] args){
        ApplicationArguments applicationArguments = new ApplicationArguments(ConfigFactory.load());
        Simulation simulation = new Simulation(applicationArguments);
        System.out.println(simulation.simulate());
    }
}
