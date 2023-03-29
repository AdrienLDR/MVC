package Controller;

import java.util.List;

import Model.SpellModel;
import Model.WizardModel;
import View.SpellView;

public class SpellController {
    private WizardModel wizard;
    private List<SpellModel> knownSpells;
    private SpellView view;

    public SpellController(WizardModel wizard, List<SpellModel> knownSpells, SpellView view) {
        this.wizard = wizard;
        this.knownSpells = knownSpells;
        this.view = view;
    }

    public void displaySpells() {
        SpellView.displaySpells();
    }

    public void castSpell(String spellName) {
        SpellModel spell = getSpell(spellName);
        if (spell == null) {
            view.displayInvalidSpell();
            return;
        }

        if (spell.getManaCost() > wizard.getMana()) {
            view.displayInsufficientMana();
            return;
        }
        int damage = spell.getDamage();
        wizard.setMana(wizard.getMana() - spell.getManaCost());
        view.displayCastSpell(spell.getName(), damage);
    }

    public void askSpellAndCast() {
        SpellView.displayKnownSpells(knownSpells);
        String spellName = view.askSpell(knownSpells);
        if (spellName == null) {
            view.displayInvalidSpell();
            return;
        }
        castSpell(spellName);
    }

    private SpellModel getSpell(String spellName) {
        for (SpellModel spell : knownSpells) {
            if (spell.getName().equalsIgnoreCase(spellName)) {
                return spell;
            }
        }
        return null;
    }
}
