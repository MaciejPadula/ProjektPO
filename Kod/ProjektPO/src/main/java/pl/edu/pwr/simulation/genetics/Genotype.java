package pl.edu.pwr.simulation.genetics;

import pl.edu.pwr.simulation.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Genotype {
    private List<IGene> genotype;

    public Genotype(List<IGene> genotype) {
        this.genotype = genotype;
    }
    public List<IGene> getGenotype(){
        return genotype;
    }
    public GeneData getGeneByType(String geneType){
        return this.genotype
                .stream()
                .filter(gene -> gene.getGeneType() == geneType)
                .collect(Collectors.toList())
                .get(0)
                .getGeneData();
    }

    @Override
    public String toString() {
        return "Genotype" + genotype;
    }
}
