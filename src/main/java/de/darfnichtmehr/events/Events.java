package de.darfnichtmehr.events;

import de.darfnichtmehr.Moneymaker;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.api.events.RenderEntityEvent;
import net.labymod.api.events.TabListEvent;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.lwjgl.Sys;

import java.util.Timer;
import java.util.TimerTask;

public class Events {

    private Boolean mineStart = false;
    private Boolean mineEnd = false;
    private Boolean cave = false;
    private Boolean home = false;
    private Boolean tMSR = false;
    private Boolean tMSR2 = false;
    private Boolean tMER = false;
    private Boolean tMER2 = false;
    private Boolean tCR = false;
    private Boolean tCR2 = false;
    private Boolean tHR = false;
    private Boolean tHR2 = false;

    public void labyEvents() {

        Moneymaker.getInstance().getApi().getEventManager().register(new RenderEntityEvent() {
            @Override
            public void onRender(final Entity e, double v, double v1, double v2, float v3) {
                if (Moneymaker.hideGold && Moneymaker.inMoneyMaker && e instanceof EntityItem && ((EntityItem) e).getEntityItem().getItem() == Item.getItemById(266) && e.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) >= 3.5) {
                    e.renderDistanceWeight = 0;
                }
            }
        });

        Moneymaker.getInstance().getApi().getEventManager().register(new TabListEvent() {
            @Override
            public void onUpdate(Type type, String s, String s1) {
                if (type == Type.HEADER) {
                    Moneymaker.inMoneyMaker = s1.contains("GommeHD.net") && s1.contains("MoneyMaker");
                }
            }
        });

        Moneymaker.getInstance().getApi().getEventManager().register(new MessageSendEvent() {
            @Override
            public boolean onSend(String s) {
                if (s.equalsIgnoreCase("/test")) {
                    System.out.println("Moin");
                    return true;
                }
                return false;
            }
        });
    }

    @SubscribeEvent
    public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent e) {
        Moneymaker.inMoneyMaker = false;
    }

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent e) {
        if (Moneymaker.inMoneyMaker && e.entity instanceof EntityPlayer && ((EntityPlayer) e.entity).getHeldItem() != null) {
            final String itemname = EnumChatFormatting.getTextWithoutFormattingCodes(((EntityPlayer) e.entity).getHeldItem().getDisplayName());
            if (itemname.equals("Zum Minengang-Anfang (Rechtsklick)") | itemname.equalsIgnoreCase("Zum Minengang-Ende (Rechtsklick)") | itemname.equalsIgnoreCase("Zum H\u00f6hlen-Anfang (Rechtsklick)") | itemname.equalsIgnoreCase("Zur Mine (Rechtsklick)")) {

                if (itemname.equals("Zum Minengang-Anfang (Rechtsklick)")) {
                    if (Moneymaker.confirmMineStart) {
                        if (!mineStart) {
                            e.setCanceled(true);
                            Timer tMS = new Timer();
                            if (!tMSR) {
                                if (Moneymaker.confirmMessage) {
                                    LabyMod.getInstance().displayMessageInChat("\u00a77[\u00a76MoneyMakerAddon\u00a77] \u00a7aYou now have 3s to confirm the teleportation.");
                                }
                                if (Moneymaker.confirmSound) {
                                    Minecraft.getMinecraft().thePlayer.playSound("note.bass", 1, 1);
                                }
                                tMSR = true;
                                tMS.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        mineStart = true;
                                        tMSR = false;
                                    }
                                }, 500);
                            }
                            Timer tMS2 = new Timer();
                            if (!tMSR2) {
                                tMSR2 = true;
                                tMS2.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        mineStart = false;
                                        tMSR2 = false;
                                    }
                                }, 3000);
                            }
                        } else {
                            mineStart = false;
                        }
                    }
                }
                if (itemname.equals("Zum Minengang-Ende (Rechtsklick)")) {
                    if (Moneymaker.confirmMineEnd) {
                        if (!mineEnd) {
                            e.setCanceled(true);
                            Timer tME = new Timer();
                            if (!tMER) {
                                if (Moneymaker.confirmMessage) {
                                    LabyMod.getInstance().displayMessageInChat("\u00a77[\u00a76MoneyMakerAddon\u00a77] \u00a7aYou now have 3s to confirm the teleportation.");
                                }
                                if (Moneymaker.confirmSound) {
                                    Minecraft.getMinecraft().thePlayer.playSound("note.bass", 1, 1);
                                }
                                tMER = true;
                                tME.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        mineEnd = true;
                                        tMER = false;
                                    }
                                }, 500);
                            }
                            Timer tME2 = new Timer();
                            if (!tMER2) {
                                tMER2 = true;
                                tME2.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        mineEnd = false;
                                        tMER2 = false;
                                    }
                                }, 3000);
                            }
                        } else {
                            mineEnd = false;
                        }
                    }
                }
                if (itemname.equals("Zum H\u00f6hlen-Anfang (Rechtsklick)")) {
                    if (Moneymaker.confirmCave) {
                        if (!cave) {
                            e.setCanceled(true);
                            Timer tC = new Timer();
                            if (!tCR) {
                                if (Moneymaker.confirmMessage) {
                                    LabyMod.getInstance().displayMessageInChat("\u00a77[\u00a76MoneyMakerAddon\u00a77] \u00a7aYou now have 3s to confirm the teleportation.");
                                }
                                if (Moneymaker.confirmSound) {
                                    Minecraft.getMinecraft().thePlayer.playSound("note.bass", 1, 1);
                                }
                                tCR = true;
                                tC.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        cave = true;
                                        tCR = false;
                                    }
                                }, 500);
                            }
                            Timer tC2 = new Timer();
                            if (!tCR2) {
                                tCR2 = true;
                                tC2.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        cave = false;
                                        tCR2 = false;
                                    }
                                }, 3000);
                            }
                        } else {
                            cave = false;
                        }
                    }
                }
                if (itemname.equals("Zur Mine (Rechtsklick)")) {
                    if (Moneymaker.confirmHome) {
                        if (!home) {
                            e.setCanceled(true);
                            Timer tH = new Timer();
                            if (!tHR) {
                                if (Moneymaker.confirmMessage) {
                                    LabyMod.getInstance().displayMessageInChat("\u00a77[\u00a76MoneyMakerAddon\u00a77] \u00a7aYou now have 3s to confirm the teleportation.");
                                }
                                if (Moneymaker.confirmSound) {
                                    Minecraft.getMinecraft().thePlayer.playSound("note.bass", 1, 1);
                                }
                                tHR = true;
                                tH.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        home = true;
                                        tHR = false;
                                    }
                                }, 500);
                            }
                            Timer tH2 = new Timer();
                            if (!tHR2) {
                                tHR2 = true;
                                tH2.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        home = false;
                                        tHR2 = false;
                                    }
                                }, 3000);
                            }
                        } else {
                            home = false;
                        }
                    }
                }
            }
        }
    }
}

