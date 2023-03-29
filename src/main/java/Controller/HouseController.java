package Controller;

import Model.WizardModel;
import Model.HouseModel;
import View.HouseView;

public class HouseController {
    private final HouseModel model;
    private final HouseView view;

    public HouseController(HouseModel model, HouseView view) {
        this.model = model;
        this.view = view;
    }

    public void setName(String name) {
        model.setHouse(name);
    }

    public String getName() {
        return model.getHouse();
    }

    public String chooseHouse(String name) {
        int choice = view.getHouseChoice();
        String house = null;
        switch (choice) {
            case 1:
                house = "Gryffindor";
                break;
            case 2:
                house = "Hufflepuff";
                break;
            case 3:
                house = "Ravenclaw";
                break;
            case 4:
                house = "Slytherin";
                break;
        }
        model.setHouse(house);
        view.displayHouse(model.getHouse());
        return house;
    }
}
