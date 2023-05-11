import Controller.*;
import Model.*;
import Model.Enemy.*;
import Niveau.*;
import View.*;

public class Main {
    public static void main(String[] args) {
        WizardModel wizard = new WizardModel(null, 500, 1, null, null, 200, 1, null, null, null);


        Level0.level0(wizard);

        TrollModel troll = new TrollModel("Troll", 120, AttackModel.getTrollAttacks(), wizard);
        Level1 level1 = new Level1();
        level1.level1(wizard, troll);

        BasiliskModel basilisk = new BasiliskModel("Basilisk", 200, AttackModel.getBasiliskAttacks(), wizard);
        Level2 level2 = new Level2();
        level2.level2(wizard, basilisk);

        EnemyModel dementor = new EnemyModel("Dementor", 150, AttackModel.getDementorAttacks(), wizard);
        Level3 level3 = new Level3();
        level3.level3(wizard, dementor);

        VoldemortModel voldemort1 = new VoldemortModel("Voldemort", 400, AttackModel.getVoldemortAttacks(), wizard, "en Plume de Phoenix");
        PeterPettigrewModel pettigrew = new PeterPettigrewModel("Peter Pettigrew", 120, AttackModel.getPettigrewAttacks(), wizard);
        Level4 level4 = new Level4();
        level4.level4(wizard, voldemort1, pettigrew);

        DoloresOmbrageModel ombrage = new DoloresOmbrageModel("Dolores Ombrage", 250, AttackModel.getOmbrageAttacks(), wizard);
        Level5 level5 = new Level5();
        level5.level5(wizard, ombrage);

        MangemortModel mangemort = new MangemortModel("Mangemort", 150, AttackModel.getDeathEaterAttacks(), wizard);
        Level6 level6 = new Level6();
        level6.level6(wizard, mangemort);

        VoldemortModel voldemort2 = new VoldemortModel("Voldemort", 300, AttackModel.getVoldemortAttacks(), wizard, "en Plume de Phoenix");
        BellatrixLestrangeModel bellatrix = new BellatrixLestrangeModel("Bellatrix Lestrange", 200, AttackModel.getBellatrixAttacks(), wizard);
        Level7 level7 = new Level7();
        level7.level7(wizard, voldemort2, bellatrix);
    }
}
