package View;

public class CharacterView {
    public void displayCharacterDetails(String name, int health, String wand, String pet, int mana, int experience) {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Wand: " + wand);
        System.out.println("Pet: " + pet);
        System.out.println("Mana: " + mana);
        System.out.println("Experience: " + experience);
    }
}
