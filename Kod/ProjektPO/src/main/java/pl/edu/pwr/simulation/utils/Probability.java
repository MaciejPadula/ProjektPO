package pl.edu.pwr.simulation.utils;

import java.util.Random;

public class Probability {
    public static boolean getOutcome(int chance) {
        return new Random().nextInt(101)<=chance;
    }
}
