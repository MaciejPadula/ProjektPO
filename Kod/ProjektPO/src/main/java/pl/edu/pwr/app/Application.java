package pl.edu.pwr.app;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.app.arguments.ArgumentParser;
import pl.edu.pwr.simulation.Simulation;

import java.io.File;

public class Application extends ArgumentParser {
    public static void main(String[] args){
        Config baseConfig = ConfigFactory.load();
        Config config = ConfigFactory
                .parseFile(new File("application.json"))
                .withFallback(baseConfig);

        ApplicationArguments applicationArguments = new ApplicationArguments(config);
        Simulation simulation = new Simulation(applicationArguments);
        System.out.println(simulation.simulate());

        //System.out.println(simulation.getHeights());
    }
}
