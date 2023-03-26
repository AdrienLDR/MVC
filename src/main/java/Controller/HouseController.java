package Controller;
import Model.WizardModel;
import Model.HouseModel;
import View.HouseView;

public class HouseController {
    private HouseModel model;
    private HouseView view;

    public HouseController(HouseModel model, HouseView view) {
        this.model = model;
        this.view = view;
    }

    public void setName(String name) {
        HouseModel.setHouse(name);
    }

    public String getName() {
        return WizardModel.getName();
    }

    public static String chooseHouse(String name) {
        int choice = HouseView.getHouseChoice();
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
        HouseModel.setHouse(house);
        HouseView.displayHouse(HouseModel.getHouse());
        return house;
    }
}
