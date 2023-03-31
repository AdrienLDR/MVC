package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.BasiliskModel;
import Model.Enemy.TrollModel;
import View.*;

import java.util.List;

public class Level0 {
    public static void main(String[] args) {

        // create wizard
        WizardModel wizardModel = new WizardModel(null, 100, 1, null, null, 50, 1);
        WizardView wizardView = new WizardView();
        PetModel petModel = new PetModel();
        List<SpellModel> knownSpells = SpellModel.getAvailableSpells();
        SpellController spellController = new SpellController(wizardModel, knownSpells, new SpellView());

        HouseModel houseModel = new HouseModel();
        HouseView houseView = new HouseView(wizardModel);
        HouseController houseController = new HouseController(houseModel, houseView);

        WizardController wizardController = new WizardController(wizardModel, wizardView, houseModel, petModel, spellController,houseController);

        // choose wizard name
        String wizardName = wizardView.askForName();
        wizardController.chooseName(wizardName);

        // choose wizard house
        WizardModel.House chosenHouse = houseController.chooseHouse();
        houseModel.setHouseName(chosenHouse.toString());


        // create wand
        WandModel wandModel = new WandModel();
        WandView wandView = new WandView();
        WandController wandController = new WandController(wandModel, wandView);
        wandController.createWand(wizardName);
        wizardModel.setWand(WandModel.getWood() + " " + WandModel.getLength());

        // choose pet
        PetView petView = new PetView();
        PetController petController = new PetController(petModel, petView);
        petController.choosePet(wizardModel);

        // display wizard info
        wizardController.updateView();
        RewardController.giveRewardToWizard(wizardController.getWizardModel());



        Level2.level2(wizardModel,new BasiliskModel("Basilisk", 200, AttackModel.getBasiliskAttacks(), wizardModel));

    }
}
