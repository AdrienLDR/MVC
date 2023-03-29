package Model;

import Controller.SpellController;
import View.SpellView;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class WizardModel extends CharacterModel {
    
    private String wand;
    private String pet;
    private int mana;
    private int level;
    private int experience;
    private List<SpellModel> knownSpells;
    private List<SpellModel> availableSpells;
    private SpellView spellView;
    private int visibilityUser;


    public WizardModel(String name, int health, int level, String wand, String pet, int mana, int experience) {
        super(name, health);
        this.level = level;
        this.wand = wand;
        this.pet = pet;
        this.mana = mana;
        this.experience = experience;
        this.knownSpells = new ArrayList<SpellModel>();
        this.availableSpells = new ArrayList<SpellModel>();
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

    public int getVisibility() {
        visibilityUser = 2;
        return visibilityUser;
    }

}