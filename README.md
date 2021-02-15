# Cocomac's Zoom Mod

This is my mod for Minecraft 1.7.10 for zooming in, like how Optifine does. <kbd>Z</kbd> activates zoom. <kbd>F</kbd> and <kbd>G</kbd> adjust the zoom level. Note that the zoom level can only be adjusted while zoom is off (e.g. when <kbd>Z</kbd> is not being pressed). The keys can be customized in the Minecraft settings.

## Setting it up

If you want to build this mod yourself, here is how I did it

### My envoirnment

First, I installed OpenJDK 8 from AdoptOpenJDK. When I installed the JDK, I told the installer to set `JAVA_HOME` to the correct value. This is important. If you do not have `JAVA_HOME` set in the installer, go back and reinstall the JDK, and tell the installer to set `JAVA_HOME`. I am using Windows 10.

### Setting up the mod

Clone the repo. To do this, open PowerShell, and type in `git clone https://github.com/CoconutMacaroon/CocomacZoomMod`. Then do `cd CocomacZoomMod`. Now you are in the directory to build the mod. To run the mod, do `.\gradlew runClient`. This will build the mod from the `*.java` files and launch Minecraft with the mod. To build a `JAR` file from the mod, run `.\gradlew build`.

### Changing the mod

I made the mod in Intellij Idea, but you could use another editor (even Notepad, although I don't advise it). The Java files for the mod are in `src/main/java/com/example/examplemod`. The code has comments explaining what it does, but if you have questions or errors, feel free to raise an issue.

## Helpful Resources

These were resources that helped me make this mod:

- How to compile the mod into a `jar` file <https://forums.minecraftforge.net/topic/15037-tutorial-compiling-mod/>
- The key codes that Minecraft uses <https://minecraft-el.gamepedia.com/Key_codes>
- A chart with the de-obfuscated versions of assorted properties <https://github.com/KevyPorter/Minecraft-Forge-Utils/blob/master/fields.csv>
- Documentation for the Forge API <https://skmedix.github.io/ForgeJavaDocs/>
- The basis for this mod (in other words, this mod is based on ZoomMod) <https://www.curseforge.com/minecraft/mc-mods/zoommod>