package pl.edu.pwr.gson;


class GeneDecoder {
    private String[] genderGenes = {"Male", "Female", "Unknown"};
    private String[] skinColorGenes = {"White", "Black", "Asian"};
    private String[] eyeColorGenes = {"Blue", "Brown", "Green", "Red"};
    private String[] hairColorGenes = {"Blond", "Brown", "Auburn", "White"};
    public String decodeGender(int val){
        return genderGenes[val];
    }
    public String decodeSkinColor(int val){
        return skinColorGenes[val];
    }
    public String decodeEyeColor(int val){
        return eyeColorGenes[val];
    }
    public String decodeHairColor(int val){
        return hairColorGenes[val];
    }
}
