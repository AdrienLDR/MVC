package View;

import java.util.List;

public class InventaireView {
    public void displayItems(List<String> items) {
        if (items.isEmpty()) {
            System.out.println("L'inventaire est vide.");
        } else {
            System.out.println("Contenu de l'inventaire :");
            for (String item : items) {
                System.out.println("- " + item);
            }
        }
    }

    public void displayRemovedItem(String item) {
        System.out.println(item + " a été retiré de l'inventaire.");
    }
}
