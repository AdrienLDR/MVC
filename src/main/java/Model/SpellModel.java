package Model;
import java.util.ArrayList;
import java.util.List;

public class SpellModel {
    private String name;
    private String effect;
    private int damage;
    private int manaCost;

    public SpellModel(String name, String effect, int damage, int manaCost) {
        this.name = name;
        this.effect = effect;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public static List<SpellModel> getAvailableSpells() {
        List<SpellModel> availableSpells = new ArrayList<>();
        // Ajouter les sorts disponibles
        availableSpells.add(new SpellModel("Avada Kedavra", "Sortilège de Mort", 100, 100));
        availableSpells.add(new SpellModel("Expelliarmus", "Sortilège de désarmement", 20, 10));
        availableSpells.add(new SpellModel("Expecto Patronum", "Sortilège du Patronus", 50, 40));
        availableSpells.add(new SpellModel("Wingardium Leviosa", "Sortilège de lévitation", 10, 5));
        availableSpells.add(new SpellModel("Accio", "Sortilège d'Attraction", 30, 20));
        availableSpells.add(new SpellModel("Incendio", "Sortilège de Feu", 40, 30));
        availableSpells.add(new SpellModel("Petrificus Totalus", "Sortilège de Pétrification", 30, 20));
        availableSpells.add(new SpellModel("Lumos", "Sortilège d'éclairage", 5, 2));
        availableSpells.add(new SpellModel("Nox", "Sortilège d'extinction de la lumière", 5, 2));
        availableSpells.add(new SpellModel("Sectumsempra", "Sortilège de mutilation", 80, 70));
        availableSpells.add(new SpellModel("Protego", "Sortilège de bouclier", 10, 5));
        availableSpells.add(new SpellModel("Stupefy", "Sortilège de stupéfaction", 30, 20));
        // ...
        return availableSpells;
    }

    public static List<SpellModel> getKnownSpells() {
        List<SpellModel> knownSpells = new ArrayList<>();
        // Ajouter les sorts connus
        knownSpells.add(new SpellModel("Lumos", "Sortilège d'éclairage", 5, 2));
        knownSpells.add(new SpellModel("Expelliarmus", "Sortilège de désarmement", 20, 10));
        knownSpells.add(new SpellModel("Wingardium Leviosa", "Sortilège de lévitation", 10, 5));

        // ...
        return knownSpells;
    }
}
