package Controller;

import Model.InventaireModel;
import View.InventaireView;

public class InventaireController {
    private final InventaireModel model;
    private final InventaireView view;

    public InventaireController(InventaireModel model, InventaireView view) {
        this.model = model;
        this.view = view;
    }

    public void addItem(String item) {
        model.addItem(item);
        view.displayItems(model.getItems());
    }

    public void removeItem(String item) {
        model.removeItem(item);
        view.displayRemovedItem(item);
        view.displayItems(model.getItems());
    }

    public void displayItems() {
        view.displayItems(model.getItems());
    }
}
