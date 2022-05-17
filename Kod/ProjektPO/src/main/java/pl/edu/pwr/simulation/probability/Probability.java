package pl.edu.pwr.simulation.probability;

import java.util.Random;

public class Probability {
    public boolean percentage(int chance) {
        return new Random().nextInt(0,101)<=chance;
    }
}
