package Model;

import java.util.List;
import java.util.Random;

public class EnemyModel extends CharacterModel {
    private List<AttackModel> attacks;
    private WizardModel wizard;

    public EnemyModel(String name, int health, List<AttackModel> attacks, WizardModel wizard) {
        super(name, health);
        this.attacks = attacks;
        this.wizard = wizard;
    }

    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        System.out.println(this.getName() + " perd " + damage + " points de vie !");
    }

    @Override
    public void attack(String spellName, EnemyModel enemy) {
        Random random = new Random();
        int index = random.nextInt(attacks.size());
        AttackModel attack = attacks.get(index);
        System.out.println(getName() + " attaque avec " + attack.getName() + " pour " + attack.getDamage() + " points de dégâts !");
        wizard.takeDamage(attack.getDamage());
    }

    @Override
    public void attack(String spellName) {

    }

    @Override
    public void heal() {
        setHealth(getHealth() + 10);
    }
}
