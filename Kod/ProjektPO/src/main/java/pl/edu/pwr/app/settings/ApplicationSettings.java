package pl.edu.pwr.app.settings;

import com.typesafe.config.Config;

public class ApplicationSettings {
    private final int numberOfEpoch;
    private final int numberOfPeople;
    private final String outputFile;
    private final int percentageOfDeath;
    private final int percentageOfMatch;
    private final int percentageOfGeneDegradation;
    private final int percentageOfPregnancy;
    public ApplicationSettings(Config config) {
        this.numberOfEpoch = config.getInt("numberOfEpoch");
        this.numberOfPeople = config.getInt("numberOfPeople");
        this.outputFile = config.getString("outputFile");
        this.percentageOfDeath = config.getInt("percentageOfDeath");
        this.percentageOfMatch = config.getInt("percentageOfMatch");
        this.percentageOfGeneDegradation = config.getInt("percentageOfGeneDegradation");
        this.percentageOfPregnancy = config.getInt("percentageOfPregnancy");
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
    public int getPercentageOfPregnancy() {
        return percentageOfPregnancy;
    }
}
