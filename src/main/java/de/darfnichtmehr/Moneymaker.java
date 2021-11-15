package de.darfnichtmehr;

import de.darfnichtmehr.events.Events;
import de.darfnichtmehr.settings.Config;
import de.darfnichtmehr.settings.Settings;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;

public class Moneymaker extends LabyModAddon {

    public static Moneymaker addon;
    public static Boolean inMoneyMaker = false;
    public static Boolean hideGold = false;
    public static Boolean confirmMessage = false;
    public static Boolean confirmSound = false;
    public static Boolean confirmMineStart = false;
    public static Boolean confirmMineEnd = false;
    public static Boolean confirmCave = false;
    public static Boolean confirmHome = false;

    @Override
    public void onEnable() {
        addon = this;
        System.out.println("\n [MoneyMaker] Enabled \n");
        new Events().labyEvents();
        this.getApi().registerForgeListener(new Events());
    }

    @Override
    public void loadConfig() {
        Config.setupConfig();
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        Settings.fillSettings(list);
    }

    public static Moneymaker getInstance() {
        return Moneymaker.addon;
    }

}
