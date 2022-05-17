package pl.edu.pwr.simulation.genetics.genetypes;

import pl.edu.pwr.simulation.GeneDecoder;
import pl.edu.pwr.simulation.genetics.GeneData;
import pl.edu.pwr.simulation.genetics.IGene;

public class SkinColorGene implements IGene {
    private GeneData geneData;

    public SkinColorGene(GeneData geneData) {
        this.geneData = geneData;
    }

    @Override
    public String getGeneType() {
        return "skinColor";
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
        return this.getGeneType()+": "+new GeneDecoder().decodeSkinColor(this);
    }
}