package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraft.client.settings.GameSettings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

/////////////////////
//import net.minecraft.client.settings;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.GameSettings.Options;


@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    @SidedProxy(
            clientSide = "com.example.examplemod.ClientProxy",
            serverSide = "com.example.examplemod.CommonProxy"
    )
    public static CommonProxy proxy;
    public static final String MODID = "ExampleMod";
    public static final String VERSION = "1.2";

    public ExampleMod() {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerClientTicker();
        System.out.println("ZoomMod init");
    }
}
