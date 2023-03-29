package Model;

public abstract class CharacterModel {
    private static String name;
    private int health;

    public CharacterModel(String name, int health ) {
        CharacterModel.name = name;
        this.health = health;
    }

    public static String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        CharacterModel.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public abstract void attack(String spellName);

    public abstract void heal();

}
