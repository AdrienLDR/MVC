package Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class CharacterModel {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int health;

    public CharacterModel(String name, int health ) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage) {
        if(this instanceof WizardModel){
            WizardModel wizard = (WizardModel) this;
            wizard.setHealth(wizard.getHealth() - damage);
            System.out.println(wizard.getName() + " perd " + damage + " points de vie !");
        } else if(this instanceof EnemyModel){
            this.health -= damage;
            if (this.health < 0) {
                this.health = 0;
            }
            System.out.println(getName() + " perd " + damage + " points de vie !");
        }
    }

    public abstract void attack(String spellName, EnemyModel enemy);

    public abstract void attack(String spellName);

    public abstract void heal();
    public void setHealth(int health) {
        this.health = health;
    }
}