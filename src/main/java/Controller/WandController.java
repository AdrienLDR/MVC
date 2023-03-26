package Controller;

import Model.WandModel;
import View.WandView;

public class WandController {
    private WandModel wandModel;
    private WandView wandView;

    public WandController(WandModel wandModel, WandView wandView) {
        this.wandModel = wandModel;
        this.wandView = wandView;
    }

    public void createWand(String wizardName) {
        String wood = WandView.chooseWood();
        String core = WandView.chooseCore();
        int length = WandModel.generateLength();
        wandModel.setWand(wood, core, length);
        wandView.displayWandInfo(wizardName, wandModel.getWand());
    }

}

