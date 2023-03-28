package Controller;

import java.util.List;

import Model.SpellModel;
import Model.WizardModel;
import View.SpellView;

public class SpellController {
    private static WizardModel wizard;
    private static List<SpellModel> knownSpells;
    private static SpellView view;

    public SpellController(WizardModel wizard, List<SpellModel> knownSpells, SpellView view) {
        SpellController.wizard = wizard;
        SpellController.knownSpells = knownSpells;
        SpellController.view = view;
    }

    public void displaySpells() {
        SpellView.displaySpells();
    }

    public static void castSpell(String spellName) {
        SpellModel spell = getSpell(spellName);
        if (spell == null) {
            view.displayInvalidSpell();
            return;
        }
        int damage = spell.getDamage();
        int manaCost = spell.getManaCost();
        if (manaCost > wizard.getMana()) {
            view.displayInsufficientMana();
            return;
        }
        wizard.setMana(wizard.getMana() - manaCost);
        wizard.attack(spellName);
        view.displayCastSpell(spell.getName(), damage);
    }

    public static void askSpellAndCast() {
        SpellView.displayKnownSpells(knownSpells);
        String spellName = view.askSpell(knownSpells);
        castSpell(spellName);
    }

    private static SpellModel getSpell(String spellName) {
        if (knownSpells == null) {
            return null;
        }
        for (SpellModel spell : knownSpells) {
            if (spell.getName().equalsIgnoreCase(spellName)) {
                return spell;
            }
        }
        return null;
    }
}
