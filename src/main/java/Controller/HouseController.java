package Controller;

import Model.HouseModel;
import Model.WizardModel;
import View.HouseView;

public class HouseController {
    private final HouseModel model;
    private final HouseView view;

    public HouseController(HouseModel model, HouseView view) {
        this.model = model;
        this.view = view;
    }

    public void setHouseName(String houseName) {
        model.setHouseName(houseName);
    }

    public String getHouseName() {
        return model.getHouseName();
    }

    public WizardModel.House chooseHouse() {
        int choice = view.getHouseChoice();
        WizardModel.House house = null;
        switch (choice) {
            case 1:
                house = WizardModel.House.GRYFFINDOR;
                break;
            case 2:
                house = WizardModel.House.HUFFLEPUFF;
                break;
            case 3:
                house = WizardModel.House.RAVENCLAW;
                break;
            case 4:
                house = WizardModel.House.SLYTHERIN;
                break;
        }
        model.setHouseName(house.toString());
        view.displayHouse(model.getHouseName());
        return house;
    }
}

