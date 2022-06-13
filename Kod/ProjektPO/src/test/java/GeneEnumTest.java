import org.junit.jupiter.api.Test;
import pl.edu.pwr.gson.GeneEnum;
import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneEnumTest {
    Genotype genotype =  new GenotypeBuilder()
            .withSkinColor(1)
            .withGender(0)
            .withHairColor(3)
            .withEyeColor(0)
            .build();

    @Test
    public void genderDecodeTest(){
        String correctGender = "Male";

        String decodedGender = GeneEnum.genderFromValue(genotype.getGender().getGeneData()).toString();

        assertEquals(correctGender, decodedGender, "Gender Decoder Problem!");
    }
    @Test
    public void skinColorDecodeTest(){
        String correctSkinColor = "Black";

        String decodedSkinColor = GeneEnum.skinColorFromValue(genotype.getSkinColor().getGeneData()).toString();

        assertEquals(correctSkinColor, decodedSkinColor, "Gender Decoder Problem!");
    }
    @Test
    public void hairColorDecodeTest(){
        String correctHairColor = "White";

        String decodedHairColor = GeneEnum.hairColorFromValue(genotype.getHairColor().getGeneData()).toString();

        assertEquals(correctHairColor, decodedHairColor, "Gender Decoder Problem!");
    }
    @Test
    public void eyeColorDecodeTest(){
        String correctEyeColor = "Blue";

        String decodedEyeColor = GeneEnum.eyeColorFromValue(genotype.getEyeColor().getGeneData()).toString();

        assertEquals(correctEyeColor, decodedEyeColor, "Gender Decoder Problem!");
    }
}
