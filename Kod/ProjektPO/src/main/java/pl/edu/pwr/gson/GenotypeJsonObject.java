package pl.edu.pwr.gson;

import pl.edu.pwr.simulation.Person;
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
        this.gender = geneDecoder.decodeGender(genotype.getGender().getGeneData());
        this.skinColor = geneDecoder.decodeSkinColor(genotype.getSkinColor().getGeneData());
        this.hairColor = geneDecoder.decodeHairColor(genotype.getHairColor().getGeneData());
        this.eyeColor = geneDecoder.decodeEyeColor(genotype.getEyeColor().getGeneData());
        this.height = genotype.getHeight().getGeneData();
        this.maxAge = genotype.getMaxAge().getGeneData();
        this.age = person.getAge();
    }
}
