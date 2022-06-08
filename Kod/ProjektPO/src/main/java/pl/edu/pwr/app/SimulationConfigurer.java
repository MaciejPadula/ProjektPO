package pl.edu.pwr.app;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.simulation.Simulation;
import pl.edu.pwr.simulation.output.ConsoleOutput;
import pl.edu.pwr.simulation.output.FileOutput;
import pl.edu.pwr.simulation.output.ISimulationOutput;

import java.io.File;

public class SimulationConfigurer {
    public Simulation configure(){
        Config baseConfig = ConfigFactory.load();
        Config config = ConfigFactory
                .parseFile(new File("application.json"))
                .withFallback(baseConfig);
        ApplicationArguments applicationArguments = new ApplicationArguments(config);
        ISimulationOutput simulationOutput;
        if(config.getBoolean("fileOutputEnabled")){
            simulationOutput = new FileOutput(applicationArguments.getOutputFile());
        }
        else{
            simulationOutput = new ConsoleOutput();
        }
        Simulation simulation = new Simulation(applicationArguments, simulationOutput);
        return simulation;
    }
}
