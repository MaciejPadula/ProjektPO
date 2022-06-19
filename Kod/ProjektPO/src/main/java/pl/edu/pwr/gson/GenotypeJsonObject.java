package pl.edu.pwr.gson;

import pl.edu.pwr.gson.enums.EyeColorEnum;
import pl.edu.pwr.gson.enums.GenderEnum;
import pl.edu.pwr.gson.enums.HairColorEnum;
import pl.edu.pwr.gson.enums.SkinColorEnum;
import pl.edu.pwr.simulation.agents.Person;
import pl.edu.pwr.simulation.genetics.Genotype;

/**
 * This class contains data of a genotype that will be converter to JSON data.
 */

public class GenotypeJsonObject {
    private final int age;
    private final GenderEnum gender;
    private final SkinColorEnum skinColor;
    private final HairColorEnum hairColor;
    private final EyeColorEnum eyeColor;
    private final int height;
    private final int maxAge;
    /**
     * GenotypeJsonObject constructor
     * @param person Person genotype data will be stored in this object.
     */
    public GenotypeJsonObject(Person person){
        Genotype genotype = person.getGenotype();
        GeneDecoder geneDecoder = new GeneDecoder(genotype);

        this.gender = geneDecoder.decodeGender();
        this.skinColor = geneDecoder.decodeSkinColor();
        this.hairColor = geneDecoder.decodeHairColor();
        this.eyeColor = geneDecoder.decodeEyeColor();
        this.height = genotype.getHeight().getGeneData();
        this.maxAge = genotype.getMaxAge().getGeneData();
        this.age = person.getAge();
    }
}
