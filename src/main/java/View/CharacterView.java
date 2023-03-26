package View;

public class CharacterView {
    public void displayCharacter(String name, int health, int maxHealth, int level, int damage) {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health + "/" + maxHealth);
    }

    public void displayDamageDealt(String attackerName, String targetName, int damageDealt) {
        System.out.println(attackerName + " attacks " + targetName + " and deals " + damageDealt + " damage.");
    }

    public void displayDamageTaken(String characterName, int actualDamage) {
        System.out.println(characterName + " takes " + actualDamage + " damage.");
    }

    public void displayDefend(String characterName) {
        System.out.println(characterName + " prepares to defend.");
    }

    public void displayHeal(String characterName, int healAmount) {
        System.out.println(characterName + " uses a health potion and recovers " + healAmount + " health.");
    }
}
