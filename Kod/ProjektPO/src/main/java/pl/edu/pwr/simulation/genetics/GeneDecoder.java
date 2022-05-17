package pl.edu.pwr.simulation.genetics;

import pl.edu.pwr.simulation.genetics.genetypes.EyeColorGene;
import pl.edu.pwr.simulation.genetics.genetypes.GenderGene;
import pl.edu.pwr.simulation.genetics.genetypes.HairColorGene;
import pl.edu.pwr.simulation.genetics.genetypes.SkinColorGene;

public class GeneDecoder {
    String[] genderGenes = {"Male", "Female"};
    String[] skinColorGenes = {"White", "Black", "Asian"};
    String[] eyeColorGenes = {"Blue", "Brown", "Green", "Red"};
    String[] hairColorGenes = {"Blond", "Brown", "Auburn", "White"};
    public String decodeGender(GenderGene genderGene){
        return genderGenes[genderGene.getGeneData().getGeneValue()];
    }
    public String decodeSkinColor(SkinColorGene skinColorGene){
        return skinColorGenes[skinColorGene.getGeneData().getGeneValue()];
    }
    public String decodeEyeColor(EyeColorGene eyeColorGene){
        return eyeColorGenes[eyeColorGene.getGeneData().getGeneValue()];
    }
    public String decodeHairColor(HairColorGene hairColorGene){
        return hairColorGenes[hairColorGene.getGeneData().getGeneValue()];
    }
}
