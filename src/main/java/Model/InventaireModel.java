package Model;

import java.util.ArrayList;
import java.util.List;

public class InventaireModel {
    private List<String> items;

    public InventaireModel() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public List<String> getItems() {
        return items;
    }
}
