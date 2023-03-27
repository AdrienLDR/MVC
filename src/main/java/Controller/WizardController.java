package Controller;

import Model.*;
import View.PetView;
import View.WizardView;

public class WizardController {
    private final WizardModel wizardModel;
    private final WizardView wizardView;
    private final HouseModel houseModel;
    private final PetModel petModel;
    private PetView petView;

    public WizardController(WizardModel wizardModel, WizardView wizardView, HouseModel houseModel, PetModel petModel) {
        this.wizardModel = wizardModel;
        this.wizardView = wizardView;
        this.houseModel = houseModel;
        this.petModel = petModel;
    }

    public void updateView() {
        String name = CharacterModel.getName();
        int health = wizardModel.getHealth();
        String houseName = HouseModel.getHouse();
        String petName = PetModel.getName();
        String petSpecies = PetModel.getSpecies();
        String wandWood = WandModel.getWood();
        String wandCore =WandModel.getCore();
        int wandLength = WandModel.getLength();

        int mana = wizardModel.getMana();
        int experience = wizardModel.getExperience();
        WizardView.display(name, health, mana, experience, houseName, petName, petSpecies, wandWood, wandCore, wandLength);
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
        String chosenHouse = HouseController.chooseHouse(CharacterModel.getName());
        HouseModel.setHouse(chosenHouse);
    }

    public void choosePet(String name, String species) {
        petModel.setName(name);
        petModel.setSpecies(species);
    }

    public void gainExperience(int amount) {
        int currentExp = wizardModel.getExperience();
        int newExp = currentExp + amount;
        wizardModel.setExperience(newExp);
        updateView();
    }
}