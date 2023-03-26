package Model;

public abstract class CharacterModel {
    private static String name;
    private int health;
    private int level;

    public CharacterModel(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
    }

    public static String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract void attack(Character enemy);

    public abstract void heal();

    public abstract void levelUp();
}
