package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class PeterPettigrewModel extends EnemyModel {
    public PeterPettigrewModel(String name, int health, List<AttackModel> peterPettigrewAttacks, WizardModel wizard) {
        super("Peter Pettigrew", health, AttackModel.getPettigrewAttacks(),wizard);
    }
}
