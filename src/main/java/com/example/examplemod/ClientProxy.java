package com.example.examplemod;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
    // see https://minecraft-el.gamepedia.com/Key_codes for a list of what keys the numbers go with



    public static KeyBinding bindKey = new KeyBinding("Zoom Key", 44, "key.categories.misc");
    public static KeyBinding bindKeyIn = new KeyBinding("Zoom In Key", 33, "key.categories.misc");
    public static KeyBinding bindKeyOut = new KeyBinding("Zoom Out Key", 34, "key.categories.misc");

    public static float zoomAmmount = 4f;

    public ClientProxy() {

    }

    public void registerClientTicker() {
        if (!KeyHandler.isRegistered(bindKey)) {
            FMLCommonHandler.instance().bus().register(new KeyHandler(bindKey, false));
        }
        if (!KeyHandler.isRegistered(bindKeyIn)) {
            FMLCommonHandler.instance().bus().register(new KeyHandler(bindKeyIn, false));
        }
        if (!KeyHandler.isRegistered(bindKeyOut)) {
            FMLCommonHandler.instance().bus().register(new KeyHandler(bindKeyOut, false));
        }
    }
}
