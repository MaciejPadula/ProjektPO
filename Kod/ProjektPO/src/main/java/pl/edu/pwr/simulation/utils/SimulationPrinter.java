package pl.edu.pwr.simulation.utils;

public class SimulationPrinter {
    private final boolean verbose;

    public SimulationPrinter(boolean verbose) {
        this.verbose = verbose;
    }
    public void print(int epochIndex, int personListSize){
        if(this.verbose){
            System.out.println(epochIndex+1+" => "+personListSize);
        }
    }
}
