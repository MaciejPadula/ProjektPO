package pl.edu.pwr.simulation.genetics;

import pl.edu.pwr.simulation.utils.GeneUtils;

/**
 * Class that builds specific genotype (set of traits)
 */
public class GenotypeBuilder {
    private Gene gender = GeneUtils.randomGender();
    private Gene skinColor = GeneUtils.randomSkinColor();
    private Gene eyeColor = GeneUtils.randomEyeColor();
    private Gene hairColor = GeneUtils.randomHairColor();
    private Gene maxAge = GeneUtils.randomMaxAge();
    private Gene height = GeneUtils.randomHeight();

    public GenotypeBuilder withGender(int geneData){
        this.gender = new Gene(geneData);
        return this;
    }
    public GenotypeBuilder withHairColor(int geneData){
        this.hairColor = new Gene(geneData);
        return this;
    }
    public GenotypeBuilder withEyeColor(int geneData){
        this.eyeColor = new Gene(geneData);
        return this;
    }
    public GenotypeBuilder withSkinColor(int geneData){
        this.skinColor = new Gene(geneData);
        return this;
    }
    public GenotypeBuilder withMaxAge(int geneData){
        this.maxAge = new Gene(geneData);
        return this;
    }
    public GenotypeBuilder withHeight(int geneData){
        this.height = new Gene(geneData);
        return this;
    }
    public Genotype build(){
        return new Genotype(
                this.gender,
                this.skinColor,
                this.eyeColor,
                this.hairColor,
                this.height,
                this.maxAge
        );
    }
}
