package Niveau;

import Controller.*;
import Model.*;
import View.*;

import java.util.List;


public class level0 {
    public static void main(String[] args) {

        // create wizard
        WizardModel wizardModel = new WizardModel(null, 100,1, null,null,50, 0);
        WizardView wizardView = new WizardView();
        PetModel petModel = new PetModel();
        List<SpellModel> knownSpells = SpellModel.getAvailableSpells();
        SpellController spellController = new SpellController(wizardModel,knownSpells, new SpellView());
        WizardController wizardController = new WizardController(wizardModel, wizardView, null, petModel, spellController);

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
        new level1();
        level1.level1();
    }
}