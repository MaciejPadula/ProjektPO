package pl.edu.pwr.simulation.utils;

import java.util.Random;

/**
 * This class provides probability methods
 */
public class Probability {
    private Probability(){}
    /**
     * This static method determines if event happened or not
     * @param chance Chance of event happening (0-100)
     * @return Boolean happening of event (True, False)
     */
    public static boolean getOutcome(int chance) {
        return new Random().nextInt(101)<=(chance+1);
    }
}
