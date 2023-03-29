package Model;

import Controller.SpellController;
import View.SpellView;

import java.util.ArrayList;
import java.util.List;

public class WizardModel extends CharacterModel {
    private String wand;
    private String pet;
    private static int mana;

    private int level;
    private int experience;
    private List<SpellModel> knownSpells;
    private List<SpellModel> availableSpells;
    private SpellView spellView;

    public WizardModel(String name, int health, int level, String wand, String pet, int mana, int experience) {
        super(name, health);
        this.level = level;
        this.wand = wand;
        this.pet = pet;
        WizardModel.mana = mana;
        this.experience = experience;
        this.knownSpells = new ArrayList<SpellModel>();
        this.availableSpells = new ArrayList<SpellModel>();
    }

    public String getWand() {
        return wand;
    }

    public void setWand(String wand) {
        this.wand = wand;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public static int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        WizardModel.mana = mana;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<SpellModel> getKnownSpells() {
        return knownSpells;
    }

    public void learnSpell(String spell) {
        for (SpellModel availableSpell : availableSpells) {
            if (availableSpell.getName().equals(spell)) {
                knownSpells.add(availableSpell);
                availableSpells.remove(availableSpell);
                break;
            }
        }
    }

    public void updateAvailableSpells(List<String> allSpells) {
        for (String spellName : allSpells) {
            boolean spellAlreadyKnown = false;
            for (SpellModel knownSpell : knownSpells) {
                if (knownSpell.getName().equals(spellName)) {
                    spellAlreadyKnown = true;
                    break;
                }
            }
            if (!spellAlreadyKnown) {
                SpellModel newSpell = new SpellModel(spellName, "Unknown effect", 0, 0);
                availableSpells.add(newSpell);

            }
        }
    }

    @Override
    public void attack(String spellName) {
        SpellController spellController = new SpellController(this, knownSpells, new SpellView());
        spellController.askSpellAndCast();
    }

    @Override
    public void heal() {
        setHealth(getHealth() + 10);
    }
    public void levelUp() {
        setLevel(getLevel() + 1);
    }

    public int getVisibility() {
        return 2;
    }
}