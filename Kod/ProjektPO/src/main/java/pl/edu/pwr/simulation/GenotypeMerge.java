package pl.edu.pwr.simulation;

import pl.edu.pwr.simulation.genetics.GeneData;
import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

public class GenotypeMerge {
    public Genotype mergeGenotype(Genotype genotype1, Genotype genotype2) {
        return new GenotypeBuilder()
                .withMaxAge(genotype1.getGeneByType("maxAge"))
                .withEyeColor(genotype1.getGeneByType("eyeColor"))
                .withGender(GeneData.randomGeneData(0,1))
                .build();
    }
    public int coverage(Genotype genotype1, Genotype genotype2){
        double[] coverPercentage={0,0};
        genotype1
                .getGenotype()
                .forEach(gen -> {
                    if(gen.getGeneType()!="gender") {
                        if (gen.getGeneData().getGeneValue() == genotype2.getGeneByType(gen.getGeneType()).getGeneValue()) {
                            coverPercentage[0] += 1;
                        }
                        coverPercentage[1]+=1;
                    }
                });
        return (int)(coverPercentage[0]/coverPercentage[1]*100);
    }
}
