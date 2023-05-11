package Model;

import Controller.SpellController;
import View.SpellView;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WizardModel extends CharacterModel {

    static String name;

    public enum House {
        GRYFFINDOR,
        HUFFLEPUFF,
        RAVENCLAW,
        SLYTHERIN
    }

    private House house;
    private String wand;
    private String core;

    private String pet;
    private int mana;
    private int level;
    private int experience;
    private List<SpellModel> knownSpells;
    private List<SpellModel> availableSpells;
    private SpellView spellView;
    private int visibilityUser;
    private List<String> inventory;

    public WizardModel(String name, int health, int level, String wand, String pet, int mana, int experience, List<SpellModel> knownSpells, List<SpellModel> availableSpells, List<String> inventory) {
        super(name, health);
        this.level = level;
        this.wand = wand;
        this.pet = pet;
        this.mana = mana;
        this.experience = experience;
        this.knownSpells = knownSpells;
        this.availableSpells = availableSpells;
        this.inventory = inventory;
    }


    public String getWandWood() {
        return WandModel.getWood();
    }

    public String getWandCore() {
        return WandModel.getCore();
    }

    public int getWandLength() {
        return WandModel.getLength();
    }

    public void setInvisible(boolean b) {
    }

    public String getCore() {
        return core;
    }

    public void learnSpell(SpellModel spell) {
        for (SpellModel availableSpell : availableSpells) {
            if (availableSpell.getName().equals(spell)) {
                knownSpells.add(availableSpell);
                availableSpells.remove(availableSpell);
                updateAvailableSpells(spell);
                break;
            }
        }
    }

    public void updateAvailableSpells(SpellModel spell) {
        boolean spellAlreadyKnown = false;
        for (SpellModel knownSpell : knownSpells) {
            if (knownSpell.getName().equals(spell.getName())) {
                spellAlreadyKnown = true;
                break;
            }
        }
        if (!spellAlreadyKnown) {
            availableSpells.add(spell);
        }
    }

    public void gainExperience(int i) {
        int currentExp = getExperience();
        int newExp = currentExp + i;
        setExperience(newExp);
    }

    public void addHealth(int healthReward) {
        int currentHealth = getHealth();
        int newHealth = currentHealth + healthReward;
        setHealth(newHealth);
    }

    public void addMana(int manaReward) {
        int currentMana = getMana();
        int newMana = currentMana + manaReward;
        setMana(newMana);
    }

    @Override
    public void attack(String spellName, EnemyModel enemy) {
        SpellController spellController = new SpellController(this, knownSpells, spellView);
        spellController.askSpellAndCast(enemy);
    }

    @Override
    public void attack(String spellName) {

    }

    @Override
    public void heal() {
        setHealth(getHealth() + 10);
    }

    public House getHouse() {
        return house;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void removeFromInventory(String item) {
        inventory.remove(item);
    }
}