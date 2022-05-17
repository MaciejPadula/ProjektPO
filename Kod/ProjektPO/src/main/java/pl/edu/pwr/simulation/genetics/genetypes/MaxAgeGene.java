package pl.edu.pwr.simulation.genetics.genetypes;

import pl.edu.pwr.simulation.genetics.GeneData;
import pl.edu.pwr.simulation.genetics.IGene;

public class MaxAgeGene implements IGene {
    private GeneData geneData;

    public MaxAgeGene(GeneData geneData) {
        this.geneData = geneData;
    }

    @Override
    public String getGeneType() {
        return "maxAge";
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
    public String toString(){
        return this.getGeneType()+": "+this.getGeneData();
    }
}
