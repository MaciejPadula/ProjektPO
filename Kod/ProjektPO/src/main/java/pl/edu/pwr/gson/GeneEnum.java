package pl.edu.pwr.gson;

public enum GeneEnum {
    Gender_0("Male"), Gender_1("Female"), Gender_2("Unknown"),
    SkinColor_0("White"), SkinColor_1("Black"), SkinColor_2("Asian"),
    EyeColor_0("Blue"), EyeColor_1("Brown"), EyeColor_2("Green"), EyeColor_3("Red"),
    HairColor_0("Blond"), HairColor_1("Brown"), HairColor_2("Auburn"), HairColor_3("White");

    private String value;

    GeneEnum(String value){
        this.value = value;
    }
    public static GeneEnum genderFromValue(int value){
        return GeneEnum.valueOf("Gender_"+value);
    }
    public static GeneEnum skinColorFromValue(int value){
        return GeneEnum.valueOf("SkinColor_"+value);
    }
    public static GeneEnum eyeColorFromValue(int value){
        return GeneEnum.valueOf("EyeColor_"+value);
    }
    public static GeneEnum hairColorFromValue(int value){
        return GeneEnum.valueOf("HairColor_"+value);
    }
    @Override
    public String toString() {
        return this.value;
    }
}
