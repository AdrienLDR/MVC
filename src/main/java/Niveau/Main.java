package Niveau;

import Controller.*;
import Model.*;
import View.*;

import static Controller.SpellController.knownSpells;
import static Controller.SpellController.wizard;


public class Main {
    public static void main(String[] args) {

        // create wizard
        WizardModel wizardModel = new WizardModel(null, 100,1, null,null,0, 0);
        WizardView wizardView = new WizardView();
        PetModel petModel = new PetModel();
        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());
        WizardController wizardController = new WizardController(wizardModel, wizardView, null, petModel, spellController);

        SpellController.askSpellAndCast();
        // choose wizard name
        String wizardName = WizardView.askForName();
        wizardController.chooseName(wizardName);

        // create house
        HouseModel houseModel = new HouseModel();
        HouseView houseView = new HouseView();
        HouseController houseController = new HouseController(houseModel, houseView);

        // choose wizard house
        String chosenHouse = HouseController.chooseHouse(wizardName);
        HouseModel.setHouse(chosenHouse);

        // create wand
        WandModel wandModel = new WandModel();
        WandView wandView = new WandView();
        WandController wandController = new WandController(wandModel, wandView);
        wandController.createWand(wizardName);
        wizardModel.setWand(WandModel.getWood() + " " + WandModel.getLength());

        // choose pet
        PetView petView = new PetView();
        PetController petController = new PetController(petModel, petView);
        PetController.choosePet(wizardModel);

        // display wizard info
        wizardController.updateView();
    }
}
