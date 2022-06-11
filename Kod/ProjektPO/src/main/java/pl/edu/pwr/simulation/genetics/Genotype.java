package pl.edu.pwr.simulation.genetics;

public class Genotype {
    private final Gene gender;
    private final Gene skinColor;
    private final Gene eyeColor;
    private final Gene hairColor;
    private final Gene height;
    private final Gene maxAge;

    public Genotype(Gene gender, Gene skinColor, Gene eyeColor, Gene hairColor, Gene height, Gene maxAge) {
        this.gender = gender;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.height = height;
        this.maxAge = maxAge;
    }

    public Gene getGender() {
        return gender;
    }

    public Gene getSkinColor() {
        return skinColor;
    }

    public Gene getEyeColor() {
        return eyeColor;
    }

    public Gene getHairColor() {
        return hairColor;
    }

    public Gene getHeight() {
        return height;
    }

    public Gene getMaxAge() {
        return maxAge;
    }
}
