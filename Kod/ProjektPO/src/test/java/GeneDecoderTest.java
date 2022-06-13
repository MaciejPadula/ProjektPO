import org.junit.jupiter.api.Test;
import pl.edu.pwr.gson.GeneDecoder;
import pl.edu.pwr.gson.enums.EyeColorEnum;
import pl.edu.pwr.gson.enums.GenderEnum;
import pl.edu.pwr.gson.enums.HairColorEnum;
import pl.edu.pwr.gson.enums.SkinColorEnum;
import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneDecoderTest {
    Genotype genotype =  new GenotypeBuilder()
            .withSkinColor(1)
            .withGender(0)
            .withHairColor(3)
            .withEyeColor(0)
            .build();
    GeneDecoder geneDecoder = new GeneDecoder(genotype);
    @Test
    public void genderDecodeTest(){
        GenderEnum decodedGender = geneDecoder.decodeGender();

        assertEquals(GenderEnum.Male, decodedGender, "Gender Decoder Problem!");
    }
    @Test
    public void skinColorDecodeTest(){
        SkinColorEnum decodedSkinColor = geneDecoder.decodeSkinColor();

        assertEquals(SkinColorEnum.Black, decodedSkinColor, "Skin Color Decoder Problem!");
    }
    @Test
    public void hairColorDecodeTest(){
        HairColorEnum decodedHairColor = geneDecoder.decodeHairColor();

        assertEquals(HairColorEnum.White, decodedHairColor, "Hair Color Decoder Problem!");
    }
    @Test
    public void eyeColorDecodeTest(){
        EyeColorEnum decodedEyeColor = geneDecoder.decodeEyeColor();

        assertEquals(EyeColorEnum.Blue, decodedEyeColor, "Eye Color Decoder Problem!");
    }
}
