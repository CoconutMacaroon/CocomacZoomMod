package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.MouseFilter;

public class KeyHandler extends InputEventListener {
    public static float originalFOV;
    private MouseFilter y = new MouseFilter();
    private MouseFilter z = new MouseFilter();

    //private final KeyBinding scriptGUI;

    // this controls how much it zooms in
    // 2f would be 2x zoom


    public KeyHandler(KeyBinding keyBinding, boolean allowRepeats) {
        super(keyBinding, allowRepeats);
    }

    public void keyDown(KeyBinding kb, boolean isRepeat) {
        /*
        System.out.println("!!! A key was pressed !!!");
        System.out.println(kb.getKeyDescription());

        if(kb.getKeyCode() == 33) {
            System.out.println("The Zoom In key was pressed");
        }

        if (!isRepeat) {
            // this controls if the camera 'drifts' when zoom is on
            //Minecraft.getMinecraft().gameSettings.smoothCamera = true;
            Minecraft.getMinecraft().gameSettings.smoothCamera = false;
            Minecraft.getMinecraft().gameSettings.hideGUI = true;
        }

        Minecraft.getMinecraft().gameSettings.fovSetting = 8.0F;
        this.y = new MouseFilter();
        this.z = new MouseFilter();

        // DEBUG


        */

        // if the key is the Zoom key
        System.out.println("!!!!! ZM NUM DEBUG:");
        System.out.println(ClientProxy.zoomAmmount);
        if(kb.getKeyCode() == 44) {
            if (!isRepeat) {
                // this controls if the camera 'drifts' when zoom is on
                //Minecraft.getMinecraft().gameSettings.smoothCamera = true;
                Minecraft.getMinecraft().gameSettings.smoothCamera = false;
                Minecraft.getMinecraft().gameSettings.hideGUI = true;
            }

            Minecraft.getMinecraft().gameSettings.fovSetting = ClientProxy.zoomAmmount;
            this.y = new MouseFilter();
            this.z = new MouseFilter();
        }
        if(kb.getKeyCode() == 33) {
            float val = ClientProxy.zoomAmmount;
            val = val + 1f;
            ClientProxy.zoomAmmount = mapFOV(fixVal(val));

        }
        if(kb.getKeyCode() == 34) {
            float val = ClientProxy.zoomAmmount;
            val = val - 1;
            ClientProxy.zoomAmmount = mapFOV(fixVal(val));

        }
    }
    public float mapFOV(float FOV) {
        // this creates a more 'logical' zoom for the player
        //return 8f - FOV;
        return FOV;
    }
    public float fixVal(float inputNumber) {
        if(inputNumber < 2) {
            return 2f;
        }
        if(inputNumber > 8) {
            return 8f;
        }
        return inputNumber;
    }
    public void keyUp(KeyBinding kb) {
        Minecraft.getMinecraft().gameSettings.hideGUI = false;
        Minecraft.getMinecraft().gameSettings.smoothCamera = false;
        Minecraft.getMinecraft().gameSettings.fovSetting = originalFOV;
    }

    static {
        originalFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
    }
}
