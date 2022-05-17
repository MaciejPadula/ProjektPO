package pl.edu.pwr.simulation.genetics;

import java.util.Random;

public class GeneData {
    private int geneValue;

    public GeneData(int geneValue) {
        this.geneValue = geneValue;
    }

    public void setGeneValue(int value){
        this.geneValue = geneValue;
    }
    public int getGeneValue() {
        return geneValue;
    }

    @Override
    public String toString() {
        return String.valueOf(getGeneValue());
    }

    public static GeneData randomGeneData(int min, int max){
        return new GeneData(new Random().nextInt(min, max-min+1));
    }
    public static GeneData brokenGene = null;
}
