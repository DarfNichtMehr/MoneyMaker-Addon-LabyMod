package de.darfnichtmehr.settings;

import de.darfnichtmehr.Moneymaker;

public class Config {
    public static void setupConfig() {
        Moneymaker.hideGold = (Moneymaker.getInstance().getConfig().has("hideGold") && Moneymaker.getInstance().getConfig().get("hideGold").getAsBoolean());
        Moneymaker.confirmMessage = (Moneymaker.getInstance().getConfig().has("confirmMessage") && Moneymaker.getInstance().getConfig().get("confirmMessage").getAsBoolean());
        Moneymaker.confirmSound = (Moneymaker.getInstance().getConfig().has("confirmSound") && Moneymaker.getInstance().getConfig().get("confirmSound").getAsBoolean());
        Moneymaker.confirmMineStart = (Moneymaker.getInstance().getConfig().has("confirmMineStart") && Moneymaker.getInstance().getConfig().get("confirmMineStart").getAsBoolean());
        Moneymaker.confirmMineEnd = (Moneymaker.getInstance().getConfig().has("confirmMineEnd") && Moneymaker.getInstance().getConfig().get("confirmMineEnd").getAsBoolean());
        Moneymaker.confirmCave = (Moneymaker.getInstance().getConfig().has("confirmCave") && Moneymaker.getInstance().getConfig().get("confirmCave").getAsBoolean());
        Moneymaker.confirmHome = (Moneymaker.getInstance().getConfig().has("confirmHome") && Moneymaker.getInstance().getConfig().get("confirmHome").getAsBoolean());
    }
}
