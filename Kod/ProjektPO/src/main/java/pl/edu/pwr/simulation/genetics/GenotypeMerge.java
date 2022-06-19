package pl.edu.pwr.simulation.genetics;

import pl.edu.pwr.simulation.utils.Probability;

import java.util.Random;
/**
 * Class that merges genotypes and checks coverage of genotypes
 */
public class GenotypeMerge {
    private final int percentageOfGeneDegradation;

    public GenotypeMerge(int percentageOfGeneDegradation) {
        this.percentageOfGeneDegradation = percentageOfGeneDegradation;
    }
    /**
     * This method allows to merge genotypes of two agents
     * @param genotype1 genotype of first agent
     * @param genotype2 genotype of second agent
     * @return new genotype being a mix of two given genotypes
     */
    public Genotype mergeGenotype(Genotype genotype1, Genotype genotype2) {
        int eyeColorGene, genderGene, hairColorGene, heightGene, maxAgeGene, skinColorGene;

        eyeColorGene = randomGene(genotype1.getEyeColor(), genotype2.getEyeColor());
        hairColorGene = randomGene(genotype1.getHairColor(), genotype2.getHairColor());
        heightGene = randomGene(genotype1.getHeight(), genotype2.getHeight());
        skinColorGene = randomGene(genotype1.getSkinColor(), genotype2.getSkinColor());
        genderGene = randomGene(genotype1.getGender(), genotype2.getGender());

        int minAge = genotype1.getMaxAge().getGeneData(), maxAge = genotype2.getMaxAge().getGeneData();
        if(minAge>maxAge){
            int age = minAge;
            minAge = maxAge;
            maxAge = age;
        }
        maxAgeGene = minAge+(new Random().nextInt(
                maxAge-minAge+1
        ));

        if(coverage(genotype1, genotype2)>= this.percentageOfGeneDegradation){
            genderGene = Gender.unknown;
        }
        return new GenotypeBuilder()
                .withGender(genderGene)
                .withHeight(heightGene)
                .withEyeColor(eyeColorGene)
                .withHairColor(hairColorGene)
                .withMaxAge(maxAgeGene)
                .withSkinColor(skinColorGene)
                .build();
    }
    /**
     * This method checks the similarity of two genotypes
     * @param genotype1 genotype of first agent
     * @param genotype2 genotype of second agent
     * @return coverage of genotypes in percents
     */
    public int coverage(Genotype genotype1, Genotype genotype2){
        int[] coverPercentage={0,0};

        if(genotype1.getEyeColor().getGeneData() == genotype2.getEyeColor().getGeneData()){
            coverPercentage[0]+=1;
        }
        coverPercentage[1]+=1;

        if(genotype1.getHairColor().getGeneData() == genotype2.getHairColor().getGeneData()){
            coverPercentage[0]+=1;
        }
        coverPercentage[1]+=1;

        if(genotype1.getHeight().getGeneData() == genotype2.getHeight().getGeneData()){
            coverPercentage[0]+=1;
        }
        coverPercentage[1]+=1;

        if(genotype1.getMaxAge().getGeneData() == genotype2.getMaxAge().getGeneData()){
            coverPercentage[0]+=1;
        }
        coverPercentage[1]+=1;
        return (int)(coverPercentage[0]/coverPercentage[1]*100);
    }
    private int randomGene(Gene gene1, Gene gene2) {
        if (Probability.getOutcome(50)) {
            return gene1.getGeneData();
        }
        return gene2.getGeneData();
    }
}
