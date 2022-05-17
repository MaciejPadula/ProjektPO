import org.junit.jupiter.api.Test;
import pl.edu.pwr.simulation.GenotypeMerge;
import pl.edu.pwr.simulation.genetics.GeneData;
import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenotypeMergeTest {
    @Test
    public void coverageTest(){
        Genotype genotype1 = new GenotypeBuilder()
                .withEyeColor(new GeneData(1))
                .withHairColor(new GeneData(2))
                .withSkinColor(new GeneData(0))
                .withHeight(new GeneData(100))
                .withMaxAge(new GeneData(90))
                .build();
        Genotype genotype2 = new GenotypeBuilder()
                .withEyeColor(new GeneData(1))
                .withHairColor(new GeneData(2))
                .withSkinColor(new GeneData(0))
                .withHeight(new GeneData(100))
                .withMaxAge(new GeneData(90))
                .build();

        int coverage = new GenotypeMerge().coverage(genotype1, genotype2);

        assertTrue(coverage==100, "Problem with coverage");
    }
}
