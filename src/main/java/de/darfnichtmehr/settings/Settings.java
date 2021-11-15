package de.darfnichtmehr.settings;


import de.darfnichtmehr.Moneymaker;
import net.labymod.settings.elements.*;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

import java.util.List;

public class Settings {

    public static void fillSettings(final List<SettingsElement> settings) {

        final HeaderElement HeaderVisual = new HeaderElement("Visual");
        final HeaderElement HeaderTeleport = new HeaderElement("Confirm Teleportation");

        final BooleanElement HideGold = new BooleanElement("Hide other gold trails", new ControlElement.IconData(Material.GOLD_INGOT), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean HideGold) {
                Moneymaker.hideGold = HideGold;
                Moneymaker.getInstance().getConfig().addProperty("hideGold", HideGold);
                Moneymaker.getInstance().saveConfig();
            }
        }, Moneymaker.hideGold);

        final BooleanElement ConfirmMessage = new BooleanElement("Show Confirm-Message in Chat", new ControlElement.IconData(Material.SIGN), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean ConfirmMessage) {
                Moneymaker.confirmMessage = ConfirmMessage;
                Moneymaker.getInstance().getConfig().addProperty("confirmMessage", ConfirmMessage);
                Moneymaker.getInstance().saveConfig();
            }
        }, Moneymaker.confirmMessage);

        final BooleanElement ConfirmSound = new BooleanElement("Play Confirm-Sound", new ControlElement.IconData(Material.NOTE_BLOCK), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean ConfirmSound) {
                Moneymaker.confirmSound = ConfirmSound;
                Moneymaker.getInstance().getConfig().addProperty("confirmSound", ConfirmSound);
                Moneymaker.getInstance().saveConfig();
            }
        }, Moneymaker.confirmSound);

        final BooleanElement ConfirmMineStart = new BooleanElement("Confirm Mine-Entrance teleport", new ControlElement.IconData(Material.MINECART), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean ConfirmMineStart) {
                Moneymaker.confirmMineStart = ConfirmMineStart;
                Moneymaker.getInstance().getConfig().addProperty("confirmMineStart", ConfirmMineStart);
                Moneymaker.getInstance().saveConfig();
            }
        }, Moneymaker.confirmMineStart);

        final BooleanElement ConfirmMineEnd = new BooleanElement("Confirm Mine-End teleport", new ControlElement.IconData(Material.MINECART), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean ConfirmMineEnd) {
                Moneymaker.confirmMineEnd = ConfirmMineEnd;
                Moneymaker.getInstance().getConfig().addProperty("confirmMineEnd", ConfirmMineEnd);
                Moneymaker.getInstance().saveConfig();
            }
        }, Moneymaker.confirmMineEnd);

        final BooleanElement ConfirmCave = new BooleanElement("Confirm Cave-Entrance teleport", new ControlElement.IconData(Material.IRON_PICKAXE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean ConfirmCave) {
                Moneymaker.confirmCave = ConfirmCave;
                Moneymaker.getInstance().getConfig().addProperty("confirmCave", ConfirmCave);
                Moneymaker.getInstance().saveConfig();
            }
        }, Moneymaker.confirmCave);

        final BooleanElement ConfirmHome = new BooleanElement("Confirm Back-to-Mine teleport", new ControlElement.IconData(Material.STORAGE_MINECART), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean ConfirmHome) {
                Moneymaker.confirmHome = ConfirmHome;
                Moneymaker.getInstance().getConfig().addProperty("confirmHome", ConfirmHome);
                Moneymaker.getInstance().saveConfig();
            }
        }, Moneymaker.confirmHome);

        settings.add(HeaderVisual);
        settings.add(HideGold);

        settings.add(HeaderTeleport);
        settings.add(ConfirmMessage);
        settings.add(ConfirmSound);
        settings.add(ConfirmMineStart);
        settings.add(ConfirmMineEnd);
        settings.add(ConfirmCave);
        settings.add(ConfirmHome);

    }
}
