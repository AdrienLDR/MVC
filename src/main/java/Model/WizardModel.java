package Model;

public class WizardModel extends CharacterModel {
    private String wand;
    private String pet;
    private int mana;
    private int experience;

    public WizardModel(String name, int health, int level, String wand, String pet, int mana, int experience) {
        super(name, health, level);
        this.wand = wand;
        this.pet = pet;
        this.mana = mana;
        this.experience = experience;
    }

    public String getWand() {
        return wand;
    }

    public void setWand(String wand) {
        this.wand = wand;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void attack(Character enemy) {
        // implémentation de l'attaque pour un sorcier
        // par exemple : enemy.setHealth(enemy.getHealth() - 10);
    }

    @Override
    public void heal() {
        // implémentation de la guérison pour un sorcier
        // par exemple : setHealth(getHealth() + 10);
    }

    @Override
    public void levelUp() {
        // implémentation de la montée de niveau pour un sorcier
        // par exemple : setLevel(getLevel() + 1);
    }
}
