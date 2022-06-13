package pl.edu.pwr.gson;


import pl.edu.pwr.gson.enums.EyeColorEnum;
import pl.edu.pwr.gson.enums.GenderEnum;
import pl.edu.pwr.gson.enums.HairColorEnum;
import pl.edu.pwr.gson.enums.SkinColorEnum;
import pl.edu.pwr.simulation.genetics.Genotype;

public class GeneDecoder {
    private final Genotype genotype;

    public GeneDecoder(Genotype genotype) {
        this.genotype = genotype;
    }
    public GenderEnum decodeGender(){
        return GenderEnum.values()[genotype.getGender().getGeneData()];
    }
    public SkinColorEnum decodeSkinColor(){
        return SkinColorEnum.values()[genotype.getSkinColor().getGeneData()];
    }
    public EyeColorEnum decodeEyeColor(){
        return EyeColorEnum.values()[genotype.getEyeColor().getGeneData()];
    }
    public HairColorEnum decodeHairColor(){
        return HairColorEnum.values()[genotype.getHairColor().getGeneData()];
    }
}
