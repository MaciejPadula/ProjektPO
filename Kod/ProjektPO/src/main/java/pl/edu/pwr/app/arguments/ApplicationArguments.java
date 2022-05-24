package pl.edu.pwr.app.arguments;

import com.typesafe.config.Config;

public class ApplicationArguments {
    private final int numberOfEpoch;
    private final int numberOfPeople;
    private final String outputFile;
    private final int percentageOfDeath;
    private final int percentageOfMatch;
    private final int percentageOfGeneDegradation;
    public ApplicationArguments(Config config) {
        this.numberOfEpoch = config.getInt("numberOfEpoch");
        this.numberOfPeople = config.getInt("numberOfPeople");
        this.outputFile = config.getString("outputFile");
        this.percentageOfDeath = config.getInt("percentageOfDeath");
        this.percentageOfMatch = config.getInt("percentageOfMatch");
        this.percentageOfGeneDegradation = config.getInt("percentageOfGeneDegradation");
    }

    public int getNumberOfEpoch() {
    return numberOfEpoch;
    }
    public int getNumberOfPeople() {
    return numberOfPeople;
    }
    public String getOutputFile(){
        return outputFile;
    }
    public int getPercentageOfDeath(){
        return percentageOfDeath;
    }
    public int getPercentageOfMatch(){
        return percentageOfMatch;
    }
    public int getPercentageOfGeneDegradation() {
        return percentageOfGeneDegradation;
    }
}
