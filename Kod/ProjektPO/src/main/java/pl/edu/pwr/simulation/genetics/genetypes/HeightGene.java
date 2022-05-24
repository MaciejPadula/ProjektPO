package pl.edu.pwr.simulation.genetics.genetypes;

import pl.edu.pwr.simulation.genetics.GeneData;
import pl.edu.pwr.simulation.genetics.GeneDecoder;
import pl.edu.pwr.simulation.genetics.IGene;

public class HeightGene implements IGene {
    private GeneData geneData;

    public HeightGene(GeneData geneData) {
        this.geneData = geneData;
    }

    @Override
    public String getGeneType() {
        return "height";
    }

    @Override
    public void setGeneData(GeneData geneData) {
        this.geneData = geneData;
    }

    @Override
    public GeneData getGeneData() {
        return geneData;
    }
    @Override
    public String toString() {
        return this.getGeneType() + ": " + getGeneData();
    }
}
