package pl.edu.pwr.simulation.genetics;

public interface IGene {
    String getGeneType();
    void setGeneData(GeneData geneData);
    GeneData getGeneData();
}
