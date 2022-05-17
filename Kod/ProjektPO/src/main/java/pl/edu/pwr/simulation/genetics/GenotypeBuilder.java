package pl.edu.pwr.simulation.genetics;

import pl.edu.pwr.simulation.genetics.genetypes.EyeColorGene;
import pl.edu.pwr.simulation.genetics.genetypes.GenderGene;
import pl.edu.pwr.simulation.genetics.genetypes.HairColorGene;
import pl.edu.pwr.simulation.genetics.genetypes.SkinColorGene;

import java.util.HashMap;
import java.util.Map;

public class GenotypeBuilder {
    private Map<String, IGene> genotype;

    public GenotypeBuilder() {
        this.genotype = new HashMap<>();
        this.genotype.put("gender", new GenderGene(GeneData.randomGeneData(0,1)));
        this.genotype.put("hairColor", new HairColorGene(GeneData.randomGeneData(0,3)));
        this.genotype.put("eyeColor", new EyeColorGene(GeneData.randomGeneData(0,3)));
        this.genotype.put("skinColor", new SkinColorGene(GeneData.randomGeneData(0,2)));
    }

    public GenotypeBuilder withGender(GeneData geneData){
        this.genotype.get("gender").setGeneData(geneData);
        return this;
    }

    public GenotypeBuilder withHairColor(GeneData geneData){
        this.genotype.get("hairColor").setGeneData(geneData);
        return this;
    }

    public GenotypeBuilder withEyeColor(GeneData geneData){
        this.genotype.get("eyeColor").setGeneData(geneData);
        return this;
    }

    public GenotypeBuilder withSkinColor(GeneData geneData){
        this.genotype.get("skinColor").setGeneData(geneData);
        return this;
    }

    public Genotype build(){
        return new Genotype(genotype.values().stream().toList());
    }
}
