package Model;

import Controller.SpellController;
import View.SpellView;

import java.util.ArrayList;
import java.util.List;

public class WizardModel extends CharacterModel {
    private String wand;
    private String pet;
    private static int mana;
    private int experience;
    private final List<String> knownSpells;
    private final List<String> availableSpells;
    private final SpellView spellView;

    public WizardModel(String name, int health, int level, String wand, String pet, int mana, int experience, SpellView spellView) {
        super(name, health, level);
        this.wand = wand;
        this.pet = pet;
        this.mana = mana;
        this.experience = experience;
        this.knownSpells = new ArrayList<>();
        this.availableSpells = new ArrayList<>();
        this.spellView = spellView;
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
        this.mana = mana;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getKnownSpells() {
        return knownSpells;
    }

    public void addKnownSpell(String spell) {
        knownSpells.add(spell);
    }

    public List<String> getAvailableSpells() {
        return availableSpells;
    }

    public void addAvailableSpell(String spell) {
        availableSpells.add(spell);
    }

    public void learnSpell(String spell) {
        if (availableSpells.contains(spell)) {
            knownSpells.add(spell);
            availableSpells.remove(spell);
        }
    }

    public void updateAvailableSpells(List<String> allSpells) {
        for (String spell : allSpells) {
            if (!knownSpells.contains(spell) && !availableSpells.contains(spell)) {
                availableSpells.add(spell);
            }
        }
    }

    @Override
    public void attack(String spellName) {
        SpellController.askSpellAndCast();

    }

    @Override
    public void heal() {
        // implementation of healing for a wizard
        // for example: setHealth(getHealth() + 10);
    }

    @Override
    public void levelUp() {
        // implementation of level up for a wizard
        // for example: setLevel(getLevel() + 1);
    }
}
