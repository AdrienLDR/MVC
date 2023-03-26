package Niveau;

import Controller.HouseController;
import Controller.PetController;
import Controller.WandController;
import Controller.WizardController;
import Model.HouseModel;
import Model.PetModel;
import Model.WandModel;
import Model.WizardModel;
import View.HouseView;
import View.PetView;
import View.WandView;
import View.WizardView;

public class Main {
    public static void main(String[] args) {
        // create wizard
        WizardModel wizardModel = new WizardModel(null, 100,null, null,50,0);
        WizardView wizardView = new WizardView();
        PetModel petModel = new PetModel();
        WizardController wizardController = new WizardController(wizardModel, wizardView, null, petModel);

        // choose wizard name
        String wizardName = WizardView.askForName();
        wizardController.chooseName(wizardName);

        // create house
        HouseModel houseModel = new HouseModel();
        HouseView houseView = new HouseView();
        HouseController houseController = new HouseController(houseModel, houseView);

        // choose wizard house
        String chosenHouse = houseController.chooseHouse(wizardName);
        houseModel.setHouse(chosenHouse);

        // create wand
        WandModel wandModel = new WandModel();
        WandView wandView = new WandView();
        WandController wandController = new WandController(wandModel, wandView);
        wandController.createWand(wizardName);
        wizardModel.setWand(wandModel.getWood() + " " + wandModel.getLength());

        // choose pet
        PetView petView = new PetView();
        PetController petController = new PetController(petModel, petView);
        petController.choosePet(wizardModel);

        // display wizard info
        wizardController.updateView();
    }
}
