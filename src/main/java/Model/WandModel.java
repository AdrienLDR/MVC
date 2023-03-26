package Model;

import java.util.Random;

public class WandModel {
    private static String wood;
    private static String core;
    private static int length;

    public WandModel() {}

    public void setWand(String wood, String core, int length) {
        this.wood = wood;
        this.core = core;
        this.length = length;
    }

    public WandModel getWand() {
        return this;
    }

    public static String getWood() {
        return wood;
    }

    public static String getCore() {
        return core;
    }

    public static int getLength() {
        return length;
    }

    public static int generateLength() {
        Random rand = new Random();
        int length = (int) (rand.nextDouble() * 20 + 15.0);
        return length;
    }

}
