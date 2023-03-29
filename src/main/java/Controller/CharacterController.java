package Controller;

import Model.WizardModel;
import View.CharacterView;

public class CharacterController {
    private final WizardModel wizard;
    private final CharacterView view;

    public CharacterController(WizardModel wizard, CharacterView view) {
        this.wizard = wizard;
        this.view = view;
    }

    public void setName(String name) {
        wizard.setName(name);
    }

    public void setHealth(int health) {
        wizard.setHealth(health);
    }

    public void setMana(int mana) {
        wizard.setMana(mana);
    }

    public void setExperience(int experience) {
        wizard.setExperience(experience);
    }
}
