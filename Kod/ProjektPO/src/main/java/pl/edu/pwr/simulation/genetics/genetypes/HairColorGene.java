package pl.edu.pwr.simulation.genetics.genetypes;

import pl.edu.pwr.simulation.GeneDecoder;
import pl.edu.pwr.simulation.genetics.GeneData;
import pl.edu.pwr.simulation.genetics.IGene;

import java.util.Random;

public class HairColorGene implements IGene {
    private GeneData geneData;

    public HairColorGene(GeneData geneData) {
        this.geneData = geneData;
    }

    @Override
    public String getGeneType(){
        return "hairColor";
    }

    @Override
    public void setGeneData(GeneData geneData){
        this.geneData = geneData;
    }

    @Override
    public GeneData getGeneData(){
        return geneData;
    }

    @Override
    public String toString() {
        return this.getGeneType()+": "+new GeneDecoder().decodeHairColor(this);
    }
}
