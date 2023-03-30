package Model;

public class RewardModel {
    private int healthReward;
    private int manaReward;

    public RewardModel(int healthReward, int manaReward) {
        this.healthReward = healthReward;
        this.manaReward = manaReward;
    }

    public int getHealthReward() {
        return healthReward;
    }

    public int getManaReward() {
        return manaReward;
    }
}
