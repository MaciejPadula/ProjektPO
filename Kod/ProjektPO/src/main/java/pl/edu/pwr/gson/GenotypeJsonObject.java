package pl.edu.pwr.gson;

import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.genetics.Genotype;

public class GenotypeJsonObject {
    private final int age;
    private final String gender;
    private final String skinColor;
    private final String hairColor;
    private final String eyeColor;
    private final int height;
    private final int maxAge;
    public GenotypeJsonObject(Person person){
        Genotype genotype = person.getGenotype();
        GeneDecoder geneDecoder = new GeneDecoder();
        this.gender = GeneEnum.genderFromValue(genotype.getGender().getGeneData()).toString();
        this.skinColor = GeneEnum.skinColorFromValue(genotype.getSkinColor().getGeneData()).toString();
        this.hairColor = GeneEnum.eyeColorFromValue(genotype.getHairColor().getGeneData()).toString();
        this.eyeColor = GeneEnum.hairColorFromValue(genotype.getEyeColor().getGeneData()).toString();
        this.height = genotype.getHeight().getGeneData();
        this.maxAge = genotype.getMaxAge().getGeneData();
        this.age = person.getAge();
    }
}
