package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

import java.util.Random;

public class PersonCreator {
    public static Person createRandom(){
        return new Person(
                new Random().nextInt(40),
                new GenotypeBuilder().build()
        );
    }
}
