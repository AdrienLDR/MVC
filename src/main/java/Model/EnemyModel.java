package Model;

import java.util.List;
import java.util.Random;

public class EnemyModel extends CharacterModel {
    private List<AttackModel> attacks;

    public EnemyModel(String name, int health, List<AttackModel> attacks) {
        super(name, health);
        this.attacks = attacks;
    }

    public List<AttackModel> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<AttackModel> attacks) {
        this.attacks = attacks;
    }

    @Override
    public void attack(String spellName) {
        Random random = new Random();
        int index = random.nextInt(attacks.size());
        AttackModel attack = attacks.get(index);
        System.out.println(getName() + " attaque avec " + attack.getName() + " pour " + attack.getDamage() + " points de dégâts !");
    }

    @Override
    public void heal() {
        setHealth(getHealth() + 10);
    }
}
