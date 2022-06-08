package pl.edu.pwr.gson;


class GeneDecoder {
    String[] genderGenes = {"Male", "Female", "Unknown"};
    String[] skinColorGenes = {"White", "Black", "Asian"};
    String[] eyeColorGenes = {"Blue", "Brown", "Green", "Red"};
    String[] hairColorGenes = {"Blond", "Brown", "Auburn", "White"};
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
