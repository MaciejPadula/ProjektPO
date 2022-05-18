package pl.edu.pwr.app;

public class ApplicationArguments {
    private final int numberOfEpoch;
    private final int numberOfPeople;
    private final String outputFile;
    private final int percentageOfDeath;
    private final int percentageOfMatch;
    public ApplicationArguments(int numberOfEpoch, int numberOfPeople,
                                String outputFile,int percentageOfDeath,
                                int percentageOfMatch) {
        this.numberOfEpoch=numberOfEpoch;
        this.numberOfPeople=numberOfPeople;
        this.outputFile=outputFile;
        this.percentageOfDeath = percentageOfDeath;
        this.percentageOfMatch = percentageOfMatch;
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
}
