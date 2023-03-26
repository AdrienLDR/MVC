package Model;

public class PotionModel {
    private String potionName;
    private String type;
    private String effect;

    public PotionModel(String potionName, String type, String effect) {
        this.potionName = potionName;
        this.type = type;
        this.effect = effect;
    }

    public String getPotionName() {
        return potionName;
    }

    public void setPotionName(String potionName) {
        this.potionName = potionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
