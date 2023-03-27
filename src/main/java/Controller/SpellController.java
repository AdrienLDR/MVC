package Controller;

import java.util.List;

import Model.SpellModel;
import Model.WizardModel;
import View.SpellView;

public class SpellController {

    private static WizardModel wizard = null;
    private  List<SpellModel> knownSpells;
    private static  List<SpellModel> availableSpells = null;
    private static SpellView view = null;

    public SpellController(WizardModel wizard, List<SpellModel> knownSpells, List<SpellModel> availableSpells, SpellView view) {
        this.wizard = wizard;
        this.knownSpells = knownSpells;
        this.availableSpells = availableSpells;
        this.view = view;
    }

    public void displaySpells() {
        view.displaySpells();
    }

    public static void castSpell(String spellName) {
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
        wizard.attack(spellName);
        view.displayCastSpell(spell.getName(), damage);
    }

    private static SpellModel getSpell(String spellName) {
        for (SpellModel spell : availableSpells) {
            if (spell.getName().equalsIgnoreCase(spellName)) {
                return spell;
            }
        }
        return null;
    }

    public static void askSpellAndCast() {
        view.displaySpells();
        String spellName = view.askSpell();
        castSpell(spellName);
    }
}
