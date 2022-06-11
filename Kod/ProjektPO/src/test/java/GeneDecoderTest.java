import org.junit.jupiter.api.Test;
import pl.edu.pwr.gson.GeneDecoder;
import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneDecoderTest {
    GeneDecoder geneDecoder = new GeneDecoder();
    Genotype genotype =  new GenotypeBuilder()
            .withSkinColor(1)
            .withGender(0)
            .withHairColor(3)
            .withEyeColor(0)
            .build();
    @Test
    public void blackManWithWhiteHairAndBlueEyes(){
        String[] correctData = {"Black", "Male", "White", "Blue"};

    }

    @Test
    public void genderDecodeTest(){
        String correctGender = "Male";

        String decodedGender = geneDecoder.decodeGender(genotype.getGender().getGeneData());

        assertEquals(correctGender, decodedGender, "Gender Decoder Problem!");
    }
    @Test
    public void skinColorDecodeTest(){
        String correctSkinColor = "Black";

        String decodedSkinColor = geneDecoder.decodeSkinColor(genotype.getSkinColor().getGeneData());

        assertEquals(correctSkinColor, decodedSkinColor, "Gender Decoder Problem!");
    }
    @Test
    public void hairColorDecodeTest(){
        String correctHairColor = "White";

        String decodedHairColor = geneDecoder.decodeHairColor(genotype.getHairColor().getGeneData());

        assertEquals(correctHairColor, decodedHairColor, "Gender Decoder Problem!");
    }
    @Test
    public void eyeColorDecodeTest(){
        String correctEyeColor = "Blue";

        String decodedEyeColor = geneDecoder.decodeEyeColor(genotype.getEyeColor().getGeneData());

        assertEquals(correctEyeColor, decodedEyeColor, "Gender Decoder Problem!");
    }
}
