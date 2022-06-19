package pl.edu.pwr.simulation;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import pl.edu.pwr.app.settings.ApplicationSettings;
import pl.edu.pwr.simulation.events.Killer;
import pl.edu.pwr.simulation.events.Matchmaker;
import pl.edu.pwr.simulation.events.Pregnancy;
import pl.edu.pwr.simulation.output.ConsoleDumper;
import pl.edu.pwr.simulation.output.FileDumper;
import pl.edu.pwr.simulation.output.ISimulationDumper;

import java.io.File;
import java.util.Arrays;
public class SimulationConfigurer {
    private SimulationConfigurer(){}
    public static Simulation configure(){
        Config baseConfig = ConfigFactory.load();
        Config config = ConfigFactory
                .parseFile(new File("application.json"))
                .withFallback(baseConfig);

        ApplicationSettings applicationSettings = new ApplicationSettings(config);
        ISimulationDumper simulationDumper;

        if(config.getBoolean("fileOutputEnabled")){
            simulationDumper = new FileDumper(applicationSettings.getOutputFile());
        }
        else{
            simulationDumper = new ConsoleDumper();
        }

        return new Simulation(simulationDumper,
                Arrays.asList(
                        new Killer(applicationSettings.getPercentageOfDeath()),
                        new Matchmaker(applicationSettings.getPercentageOfMatch()),
                        new Pregnancy(applicationSettings.getPercentageOfPregnancy(),
                                applicationSettings.getPercentageOfGeneDegradation()
                        )
                ),
                applicationSettings.getNumberOfPeople(),
                applicationSettings.getNumberOfEpoch()
        );
    }
}
