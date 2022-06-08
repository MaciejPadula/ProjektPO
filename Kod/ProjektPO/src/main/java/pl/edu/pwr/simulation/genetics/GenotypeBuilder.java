package pl.edu.pwr.simulation.genetics;

public class GenotypeBuilder {
    private Gene gender = Gene.randomGender();
    private Gene skinColor = Gene.randomSkinColor();
    private Gene eyeColor = Gene.randomEyeColor();
    private Gene hairColor = Gene.randomHairColor();
    private Gene maxAge = Gene.randomMaxAge();
    private Gene height = Gene.randomHeight();

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
        return new Genotype(gender, skinColor, eyeColor, hairColor,height, maxAge);
    }
}
