import Controller.*;
import Model.*;
import Model.Enemy.*;
import Niveau.*;
import View.*;

public class Main {
    static WizardModel wizard = new WizardModel(null, 500, 1, null, null, 200,1,null,null,null);

    public static void main(String[] args) {

        Level0 level0 = new Level0();
        level0.level0(wizard);

        Level1 level1 = new Level1();
        level1.level1(wizard, new TrollModel("Troll", 120, AttackModel.getTrollAttacks(), wizard));

        Level2 level2 = new Level2();
        level2.level2(wizard,new BasiliskModel("Basilisk", 200, AttackModel.getBasiliskAttacks(), wizard));

        Level3 level3 = new Level3();
        level3.level3(wizard, new EnemyModel("Dementor", 150, AttackModel.getDementorAttacks(), wizard));

        Level4 level4 = new Level4();
        level4.level4(wizard, new VoldemortModel("Voldemort", 400, AttackModel.getVoldemortAttacks(), wizard,"en Plume de Phoenix"),
                new PeterPettigrewModel("Peter Pettigrew", 120, AttackModel.getPettigrewAttacks(), wizard));

        Level5 level5 = new Level5();
        level5.level5(wizard,new DoloresOmbrageModel("Dolores Ombrage", 250, AttackModel.getOmbrageAttacks(), wizard));

        Level6 level6 = new Level6();
        level6.level6(wizard, new MangemortModel("Mangemort", 150, AttackModel.getDeathEaterAttacks(), wizard));

        Level7 level7 = new Level7();
        level7.level7(wizard,new VoldemortModel("Voldemort", 300, AttackModel.getVoldemortAttacks(), wizard,"en Plume de Phoenix"),
                new BellatrixLestrangeModel("Bellatrix Lestrange", 200, AttackModel.getBellatrixAttacks(), wizard));
    }
}
