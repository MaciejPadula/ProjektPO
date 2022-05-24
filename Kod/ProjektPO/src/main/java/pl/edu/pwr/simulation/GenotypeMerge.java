package pl.edu.pwr.simulation;

import pl.edu.pwr.app.arguments.ApplicationArguments;
import pl.edu.pwr.simulation.genetics.GeneData;
import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;
import pl.edu.pwr.simulation.genetics.IGene;
import pl.edu.pwr.simulation.genetics.genetypes.*;
import pl.edu.pwr.simulation.probability.Probability;

import java.lang.reflect.Type;
import java.util.Random;

public class GenotypeMerge {
    ApplicationArguments applicationArguments;
    Probability probability;
    public GenotypeMerge(ApplicationArguments applicationArguments, Probability probability) {
        this.probability = probability;
        this.applicationArguments = applicationArguments;
    }

    public Genotype mergeGenotype(Genotype genotype1, Genotype genotype2) {
        GeneData eyeColorGene, genderGene, hairColorGene, heightGene, maxAgeGene, skinColorGene;

        eyeColorGene = randomGene(genotype1, genotype2, "eyeColor");
        hairColorGene = randomGene(genotype1, genotype2, "hairColor");
        heightGene = randomGene(genotype1, genotype2, "height");
        skinColorGene = randomGene(genotype1, genotype2, "skinColor");
        genderGene = randomGene(genotype1, genotype2, "gender");
        int minAge = genotype1.getGeneByType("maxAge").getGeneValue()
                , maxAge = genotype2.getGeneByType("maxAge").getGeneValue();
        if(minAge>maxAge){
            int age = minAge;
            minAge = maxAge;
            maxAge = age;
        }
        maxAgeGene = new GeneData(
                new Random().nextInt(
                        minAge,
                        maxAge+1
                )
        );

        if(coverage(genotype1, genotype2)>=applicationArguments.getPercentageOfGeneDegradation()){
            genderGene = new GeneData(2);
        }
        return new GenotypeBuilder()
                .withMaxAge(maxAgeGene)
                .withEyeColor(eyeColorGene)
                .withGender(genderGene)
                .withHeight(heightGene)
                .withSkinColor(skinColorGene)
                .withHairColor(hairColorGene)
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

    public GeneData randomGene(Genotype genotype1, Genotype genotype2, String name) {
        GeneData geneData;
        if (probability.percentage(50)) {
            geneData = genotype1.getGeneByType(name);
        } else {
            geneData = genotype2.getGeneByType(name);
        }
        return geneData;
    }
}
