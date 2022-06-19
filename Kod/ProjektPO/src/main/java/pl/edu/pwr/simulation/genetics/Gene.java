package pl.edu.pwr.simulation.genetics;

/**
 * Class that contains data about specified genes
 */
public class Gene {
    private final int geneData;

    public Gene(int geneData) {
        this.geneData = geneData;
    }
    public int getGeneData(){
        return this.geneData;
    }
}
