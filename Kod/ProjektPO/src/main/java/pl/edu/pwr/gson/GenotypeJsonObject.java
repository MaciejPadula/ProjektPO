package pl.edu.pwr.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.edu.pwr.simulation.Person;
import pl.edu.pwr.simulation.genetics.Genotype;

public class GenotypeJsonObject {


    private final int age;
    private final String gender;
    private final String skinColor;
    private final String hairColor;
    private final String eyeColor;
    private final int heigh;
    private final int maxAge;
    public GenotypeJsonObject(Person person){
        Genotype genotype = person.getGenotype();
        GeneDecoder geneDecoder = new GeneDecoder();
        gender = geneDecoder.decodeGender(genotype.getGender().getGeneData());
        skinColor = geneDecoder.decodeSkinColor(genotype.getSkinColor().getGeneData());
        hairColor = geneDecoder.decodeHairColor(genotype.getHairColor().getGeneData());
        eyeColor = geneDecoder.decodeEyeColor(genotype.getEyeColor().getGeneData());
        heigh = genotype.getHeight().getGeneData();
        maxAge = genotype.getMaxAge().getGeneData();
        age = person.getAge();
    }
}
