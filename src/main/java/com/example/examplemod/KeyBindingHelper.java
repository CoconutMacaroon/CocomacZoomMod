package com.example.examplemod;

import net.minecraft.client.settings.KeyBinding;

public class KeyBindingHelper {
    public KeyBindingHelper() {
    }

    public static int getKeyCode(KeyBinding kb) {
       // return kb.func_151463_i();
        return kb.getKeyCode();
    }


}
