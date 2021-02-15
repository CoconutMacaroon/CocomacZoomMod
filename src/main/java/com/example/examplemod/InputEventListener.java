package com.example.examplemod;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.MouseInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
public abstract class InputEventListener {
    private static HashMap<KeyBinding, InputEventListener> instances = new HashMap();
    protected KeyBinding keyBinding;
    protected boolean isKeyDown;
    protected boolean allowRepeats;

    public InputEventListener(KeyBinding keyBinding, boolean allowRepeats) {
        this.keyBinding = keyBinding;
        this.allowRepeats = allowRepeats;
        this.isKeyDown = false;
        instances.put(keyBinding, this);
        ClientRegistry.registerKeyBinding(keyBinding);
    }

    public KeyBinding getKeyBinding() {
        return this.keyBinding;
    }

    @SubscribeEvent
    public void onKeyInputEvent(KeyInputEvent event) {
        this.onInputEvent(event);
    }

    @SubscribeEvent
    public void onMouseInputEvent(MouseInputEvent event) {
        this.onInputEvent(event);
    }

    private void onInputEvent(InputEvent event) {
        int keyCode = KeyBindingHelper.getKeyCode(this.keyBinding);
        boolean state = keyCode < 0 ? Mouse.isButtonDown(keyCode + 100) : Keyboard.isKeyDown(keyCode);
        if (state != this.isKeyDown || state && this.allowRepeats) {
            if (state) {
                this.keyDown(this.keyBinding, state == this.isKeyDown);
            } else {
                this.keyUp(this.keyBinding);
            }

            this.isKeyDown = state;
        }
   //     System.out.println("Key Input Event");
    }

    public abstract void keyDown(KeyBinding var1, boolean var2);

    public abstract void keyUp(KeyBinding var1);

    public static boolean isRegistered(KeyBinding kb) {
        return instances.containsKey(kb);
    }

    public static void unRegister(KeyBinding kb) {
        if (isRegistered(kb)) {
            FMLCommonHandler.instance().bus().unregister(instances.get(kb));
            instances.remove(kb);
        }

    }
}
