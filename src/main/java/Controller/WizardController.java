package Controller;

import Model.*;
import View.WizardView;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class WizardController {
    private final WizardModel wizardModel;
    private final WizardView wizardView;
    private final HouseModel houseModel;
    private final PetModel petModel;
    private final SpellController spellController;
    private final HouseController houseController; // Ajout de l'attribut

    public WizardController(WizardModel wizardModel, WizardView wizardView, HouseModel houseModel, PetModel petModel, SpellController spellController, HouseController houseController) {
        this.wizardModel = wizardModel;
        this.wizardView = wizardView;
        this.houseModel = houseModel;
        this.petModel = petModel;
        this.spellController = spellController;
        this.houseController = houseController; // Initialisation de l'attribut
    }

    public void updateView() {
        String name = wizardModel.getName(); // Correction de l'appel
        int health = wizardModel.getHealth();
        String houseName = houseModel.getHouse(); // Correction de l'appel
        String petName = petModel.getName();
        String petSpecies = petModel.getSpecies();
        String wandWood = WandModel.getWood();
        String wandCore = WandModel.getCore();
        int wandLength = WandModel.getLength();

        int mana = wizardModel.getMana();
        int experience = wizardModel.getExperience();
        WizardView.display(name, health, mana, experience, houseName, petName, petSpecies, wandWood, wandCore, wandLength);
        wizardModel.getKnownSpells();
    }

    public void setWizardHealth(int health) {
        wizardModel.setHealth(health);
    }

    public void setWizardMana(int mana) {
        wizardModel.setMana(mana);
    }

    public void chooseName(String name) {
        wizardModel.setName(name);
    }

    public void chooseHouse() {
        String chosenHouse = houseController.chooseHouse(wizardModel.getName());
        houseModel.setHouse(chosenHouse);
    }

    public void choosePet(String name, String species) {
        petModel.setName(name);
        petModel.setSpecies(species);
    }
    public void learnSpell(String spell) {
        wizardModel.learnSpell(spell);
        updateView();
    }


    public void castSpell(String spellName) {
        wizardModel.attack(spellName);
    }
}
