package Controller;

import Model.WizardModel;
import view.CharacterView;

public class CharacterController {
    private WizardModel wizard;
    private CharacterView view;

    public CharacterController(WizardModel wizard, CharacterView view) {
        this.wizard = wizard;
        this.view = view;
    }

    public void updateView() {
        view.displayCharacterDetails(wizard.getName(), wizard.getHealth(), wizard.getWand(), wizard.getPet(), wizard.getMana(), wizard.getExperience());
    }

    public void setName(String name) {
        wizard.setName(name);
    }

    public void setHealth(int health) {
        wizard.setHealth(health);
    }

    public void setWand(String wand) {
        wizard.setWand(wand);
    }

    public void setPet(String pet) {
        wizard.setPet(pet);
    }

    public void setMana(int mana) {
        wizard.setMana(mana);
    }

    public void setExperience(int experience) {
        wizard.setExperience(experience);
    }
}
