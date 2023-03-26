package Controller;

import Model.PetModel;
import Model.WizardModel;
import View.PetView;

public class PetController {
    private PetModel model;
    private PetView view;

    public PetController(PetModel model, PetView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        String name = model.getName();
        String species = model.getSpecies();
        PetView.display(name, species);
    }

    public static void choosePet(WizardModel wizardModel) {
        PetView.displayWelcome();

        int qualityChoice;
        do {
            PetView.displayQualityOptions();
            qualityChoice = PetView.getQualityChoice();
            if (qualityChoice < 1 || qualityChoice > 3) {
                PetView.displayInvalidQuality();
            }
        } while (qualityChoice < 1 || qualityChoice > 3);

        String species = null;
        if (qualityChoice == 1) {
            species = "hibou";
        } else if (qualityChoice == 2) {
            species = "chien";
        } else if (qualityChoice == 3) {
            species = "chat";
        }

        PetModel pet = new PetModel();
        pet.setSpecies(species);

        String name;
        do {
            PetView.displayAskName();
            name = PetView.getPetName();
        } while (name.isEmpty());
        pet.setName(name);

        PetController controller = new PetController(pet, new PetView());
        controller.updateView();
    }
}
