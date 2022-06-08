package pl.edu.pwr.simulation.genetics;

import java.util.Random;

public class Gene {
    private final int geneData;

    public Gene(int geneData) {
        this.geneData = geneData;
    }

    public int getGeneData(){
        return geneData;
    }

    public static Gene randomGender(){
        return new Gene(new Random().nextInt(2));
    }
    public static Gene randomEyeColor(){
        return new Gene(new Random().nextInt(3));
    }
    public static Gene randomHairColor(){
        return new Gene(new Random().nextInt(2));
    }
    public static Gene randomSkinColor(){
        return new Gene(new Random().nextInt(3));
    }
    public static Gene randomMaxAge(){
        return new Gene(new Random().nextInt(100));
    }
    public static Gene randomHeight(){
        return new Gene(120+new Random().nextInt(100));
    }
}
