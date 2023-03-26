package Controller;
import Model.CharacterModel;
import View.CharacterView;
import Model.PotionModel;

public class CharacterController {private CharacterModel model;
    private CharacterView view;

    public CharacterController(CharacterModel model, CharacterView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.displayCharacter(model.getName(), model.getHealth(), model.getMaxHealth(), model.getLevel(), model.getDamage());
    }

    public void setCharacterName(String name) {
        model.setName(name);
    }

    public void setCharacterHealth(int health) {
        model.setHealth(health);
    }

    public void setCharacterMaxHealth(int maxHealth) {
        model.setMaxHealth(maxHealth);
    }

    public void setCharacterLevel(int level) {
        model.setLevel(level);
    }

    public void setCharacterDamage(int damage) {
        model.setDamage(damage);
    }

    public void usePotion(PotionModel Potion) {
        model.usePotion(Potion);
    }

    public void attack(CharacterModel target) {
        model.attack(target);
    }

    public void defend() {
        model.defend();
    }

}
