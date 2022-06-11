import com.typesafe.config.*;
import org.junit.jupiter.api.Test;
import pl.edu.pwr.app.settings.ApplicationSettings;
import pl.edu.pwr.simulation.genetics.GenotypeMerge;
import pl.edu.pwr.simulation.genetics.Genotype;
import pl.edu.pwr.simulation.genetics.GenotypeBuilder;
import pl.edu.pwr.simulation.utils.Probability;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenotypeMergeTest {
    Probability probability = new Probability();
    ApplicationSettings applicationArguments = new ApplicationSettings(ConfigFactory.load());
    GenotypeMerge genotypeMerge = new GenotypeMerge(applicationArguments);
    @Test
    public void coverageTest(){
        Genotype genotype1 = new GenotypeBuilder()
                .withEyeColor(1)
                .withHairColor(2)
                .withSkinColor(0)
                .withHeight(100)
                .withMaxAge(90)
                .build();
        Genotype genotype2 = new GenotypeBuilder()
                .withEyeColor(1)
                .withHairColor(2)
                .withSkinColor(0)
                .withHeight(100)
                .withMaxAge(90)
                .build();

        int coverage = genotypeMerge.coverage(genotype1, genotype2);
        assertTrue(coverage==100, "Problem with coverage");
    }
    @Test
    public void mergeTest(){
        Genotype genotype1 = new GenotypeBuilder()
                .withEyeColor(1)
                .withHairColor(2)
                .withSkinColor(0)
                .withHeight(100)
                .withMaxAge(90)
                .build();
        Genotype genotype2 = new GenotypeBuilder()
                .withEyeColor(1)
                .withHairColor(2)
                .withSkinColor(0)
                .withHeight(100)
                .withMaxAge(90)
                .build();

        Genotype mergedGenotype = genotypeMerge.mergeGenotype(genotype1, genotype2);
        assertTrue(mergedGenotype.getGender().getGeneData()==2, "Merge and coverage issue");
    }
}
