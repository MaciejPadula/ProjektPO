package pl.edu.pwr.app;

public class ApplicationArguments {

    int numberOfEpoch;
    int numberOfPeople;
    String outputFile;
    int percentageOfDeath;
    public ApplicationArguments(int numberOfEpoch, int numberOfPeople, String outputFile)
    {
        this.numberOfEpoch=numberOfEpoch;
        this.numberOfPeople=numberOfPeople;
        this.outputFile=outputFile;
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
}
