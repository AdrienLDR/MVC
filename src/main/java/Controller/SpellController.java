package Controller;

import java.util.List;

import Model.Enemy.PeterPettigrewModel;
import Model.Enemy.VoldemortModel;
import Model.EnemyModel;
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
        SpellView.displayKnownSpells(knownSpells);
    }


    public void castSpell(String spellName, EnemyModel enemy) {
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
        enemy.takeDamage(damage);
        view.displayCastSpell(spell.getName(), damage);
        checkLumosSpell(spell);
        checkAccioSpell(spell,enemy);
    }


    public void askSpellAndCast(EnemyModel enemy) {
        SpellView.displayKnownSpells(knownSpells);
        String spellName = view.askSpell(knownSpells);
        if (spellName == null) {
            view.displayInvalidSpell();
            return;
        }
        castSpell(spellName, enemy); // Pass the enemy object to the castSpell method
    }


    public SpellModel getSpell(String spellName) {
        for (SpellModel spell : knownSpells) {
            if (spell.getName().equalsIgnoreCase(spellName)) {
                return spell;
            }
        }
        return null;
    }

    private void checkLumosSpell(SpellModel spell) {
        if (spell != null && spell.getName().equalsIgnoreCase("Lumos")) {
            Model.Enemy.TrollModel.setVisibility(2);
            System.out.println("Vous pouvez voir distinctement le troll.");
        }
    }

    private void checkAccioSpell(SpellModel spell, EnemyModel enemy) {
        if (spell != null && spell.getName().equalsIgnoreCase("Accio")) {
            System.out.println("Vous avez utilisé le sort Accio !");
            // Vérifier si l'ennemi est Peter Pettigrew ou Voldemort
            if (enemy instanceof PeterPettigrewModel) {
                System.out.println("Vous avez attiré le Portolion à vous, mais Peter Pettigrew essaie de vous en empêcher !");
                spell.setDamage(0);
            } else if (enemy instanceof VoldemortModel) {
                System.out.println("Vous avez attiré le Portolion à vous, mais Voldemort essaie de vous en empêcher !");
                spell.setDamage(0);
            }
        }
    }

}
