package Controller;

import Model.*;
import View.WizardView;
import lombok.Data;
import lombok.Getter;
import java.util.Scanner;

import lombok.Setter;

@Setter
@Getter
@Data
public class WizardController {
    private WizardModel wizardModel;
    private final WizardView wizardView;
    private final HouseModel houseModel;
    private final PetModel petModel;
    private final SpellController spellController;
    private final HouseController houseController;

    private static Scanner scanner;

    public WizardController(WizardModel wizardModel, WizardView wizardView, HouseModel houseModel, PetModel petModel, SpellController spellController, HouseController houseController) {
        this.wizardModel = wizardModel;
        this.wizardView = wizardView;
        this.houseModel = houseModel;
        this.petModel = petModel;
        this.spellController = spellController;
        this.houseController = houseController;
        scanner = new Scanner(System.in); // Initialisation de la variable scanner

    }

    public void updateView() {
        String name = wizardModel.getName();
        int health = wizardModel.getHealth();
        String houseName = houseModel.getHouseName();
        String petName = PetModel.getName();
        String petSpecies = PetModel.getSpecies();
        String wandWood = wizardModel.getWandWood(); // Utilisation de la méthode getWandWood de WizardModel
        String wandCore = wizardModel.getWandCore(); // Utilisation de la méthode getWandCore de WizardModel
        int wandLength = wizardModel.getWandLength(); // Utilisation de la méthode getWandLength de WizardModel

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

    public void chooseHouse() {
        String chosenHouse = houseController.chooseHouse().toString();
        houseModel.setHouseName(chosenHouse);
    }

    public void choosePet(String name, String species) {
        petModel.setName(name);
        petModel.setSpecies(species);
    }

    public void learnSpell(SpellModel spell) {
        wizardModel.learnSpell(spell);
        updateView();
    }

    public void castSpell(String spellName) {
        wizardModel.attack(spellName);
    }
}
