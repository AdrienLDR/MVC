package Model;

import java.util.ArrayList;
import java.util.List;
public class AttackModel {
    private String name;
    private int damage;
    public AttackModel(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public static List<AttackModel> getTrollAttacks() {

        List<AttackModel> trollAttacks = new ArrayList<>();
            trollAttacks.add(new AttackModel("Frappe puissante", 20));
            trollAttacks.add(new AttackModel("Jet de pierre", 10));
            trollAttacks.add(new AttackModel("Charge", 15));
        return trollAttacks;
    }
    public static List<AttackModel> getBasiliskAttacks() {

            List<AttackModel> basiliskAttacks = new ArrayList<>();
            basiliskAttacks.add(new AttackModel("Morsure venimeuse", 30));
            basiliskAttacks.add(new AttackModel("Regard pétrifiant", 40));
            basiliskAttacks.add(new AttackModel("Constriction", 20));
        return basiliskAttacks;
    }
    public static List<AttackModel> getDementorAttacks() {

        List<AttackModel> dementorAttacks = new ArrayList<>();
            dementorAttacks.add(new AttackModel("Emprise de terreur", 15));
            dementorAttacks.add(new AttackModel("Baiser du Détraqueur", 30));
            dementorAttacks.add(new AttackModel("Aspiration d'âme", 25));
        return dementorAttacks;
    }
    public static List<AttackModel> getVoldemortAttacks() {

        List<AttackModel> voldemortAttacks = new ArrayList<>();
            voldemortAttacks.add(new AttackModel("Avada Kedavra", 500));
            voldemortAttacks.add(new AttackModel("Imperium", 25));
            voldemortAttacks.add(new AttackModel("Crucio", 35));
        return voldemortAttacks;
    }
    public static List<AttackModel> getPettigrewAttacks() {

        List<AttackModel> pettigrewAttacks = new ArrayList<>();
            pettigrewAttacks.add(new AttackModel("Transformisme", 10));
            pettigrewAttacks.add(new AttackModel("Réducto", 20));
            pettigrewAttacks.add(new AttackModel("Métamorphose", 15));
        return pettigrewAttacks;
    }
    public static List<AttackModel> getOmbrageAttacks() {

        List<AttackModel> ombrageAttacks = new ArrayList<>();
            ombrageAttacks.add(new AttackModel("Sortilège du fouet", 15));
            ombrageAttacks.add(new AttackModel("Imperium", 20));
            ombrageAttacks.add(new AttackModel("Sortilège de douleur", 25));
        return ombrageAttacks;
    }
    public static List<AttackModel> getDeathEaterAttacks() {

        List<AttackModel> deathEaterAttacks = new ArrayList<>();
            deathEaterAttacks.add(new AttackModel("Sortilège de mort", 40));
            deathEaterAttacks.add(new AttackModel("Sortilège de torture", 30));
            deathEaterAttacks.add(new AttackModel("Sortilège d'incarcération", 20));
            return deathEaterAttacks;
    }
    public static List<AttackModel> getBellatrixAttacks() {

        List<AttackModel> bellatrixAttacks = new ArrayList<>();
            bellatrixAttacks.add(new AttackModel("Sortilège de mort", 35));
            bellatrixAttacks.add(new AttackModel("Crucio", 30));
            bellatrixAttacks.add(new AttackModel("Sortilège de désillusion", 20));
            return bellatrixAttacks;
    }
}

