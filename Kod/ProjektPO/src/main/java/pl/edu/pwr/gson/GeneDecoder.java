package pl.edu.pwr.gson;


import pl.edu.pwr.gson.enums.EyeColorEnum;
import pl.edu.pwr.gson.enums.GenderEnum;
import pl.edu.pwr.gson.enums.HairColorEnum;
import pl.edu.pwr.gson.enums.SkinColorEnum;
import pl.edu.pwr.simulation.genetics.Genotype;

/**
 * This class decodes gene int values to specific enums
 */
public class GeneDecoder {
    private final Genotype genotype;
    /**
     * GeneDecoder constructor
     * @param genotype Genotype that wil be decoded
     */
    public GeneDecoder(Genotype genotype) {
        this.genotype = genotype;
    }

    /**
     * This method decodes gender
     * @return GenderEnum based on integer value of gender gene from genotype
     */
    public GenderEnum decodeGender(){
        return GenderEnum.values()[genotype.getGender().getGeneData()];
    }/**
     * This method decodes skin color
     * @return GenderEnum based on integer value of skin color gene from genotype
     */
    public SkinColorEnum decodeSkinColor(){
        return SkinColorEnum.values()[genotype.getSkinColor().getGeneData()];
    }/**
     * This method decodes eye color
     * @return GenderEnum based on integer value of eye color gene from genotype
     */
    public EyeColorEnum decodeEyeColor(){
        return EyeColorEnum.values()[genotype.getEyeColor().getGeneData()];
    }/**
     * This method decodes hair color
     * @return GenderEnum based on integer value of hair color gene from genotype
     */
    public HairColorEnum decodeHairColor(){
        return HairColorEnum.values()[genotype.getHairColor().getGeneData()];
    }
}
