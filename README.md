# MechaMine 🎮

Fun Minecraft mods built by Paxton and Dad!

## Features

### 🟣 Bounce Pad
A magenta block that launches you high into the sky — like a giant trampoline!
- Crouch (Shift) while landing to cancel the bounce.
- **Recipe:** 8 Slime Balls surrounding a Honey Block → 4 Bounce Pads

### 🔵 Speed Pad
A cyan block that gives you super speed when you step on it.
- Great for building race tracks and parkour courses!
- **Recipe:** Iron Ingots and Gold Ingots in a ring → 4 Speed Pads

### 🍬 Glow Candy
A magical candy that lights you up and lets you see in the dark for 60 seconds.
- Gives Night Vision, Glowing, and Jump Boost III.
- You can eat it even when you're full!
- **Recipe (shapeless):** Sugar + Glowstone Dust + Golden Carrot → 3 Glow Candy

All three items can be found in the **MechaMine** tab in Creative mode.

---

## Setup (First Time)

### Requirements
- Java 17 (download from [Adoptium](https://adoptium.net/))
- Minecraft Java Edition 1.20.1
- [Forge 47.2.0 MDK](https://files.minecraftforge.net/net/minecraftforge/forge/index_1.20.1.html)

### Steps

1. **Download the Forge MDK** for Minecraft 1.20.1 (version 47.2.0) and extract it to a folder.
2. **Copy the Gradle wrapper** from the MDK into this repository:
   ```
   cp <mdk-folder>/gradle/wrapper/gradle-wrapper.jar gradle/wrapper/
   ```
3. **Build the mod:**
   ```bash
   ./gradlew build
   ```
   On Windows:
   ```cmd
   gradlew.bat build
   ```
4. Find the built `.jar` file in `build/libs/`.
5. Copy it to your Minecraft `mods/` folder and launch Minecraft with Forge 47.2.0.

### Run in Development (Optional)
```bash
./gradlew runClient
```

---

## Project Structure

```
src/main/java/com/hbgwhite/mechamods/
├── MechaMods.java        ← Mod entry point
├── ModBlocks.java        ← Block registration
├── ModItems.java         ← Item registration
├── ModCreativeTab.java   ← Creative mode tab
├── BounceBlock.java      ← Bounce Pad logic
└── SpeedBlock.java       ← Speed Pad logic
```

---

Happy modding! 🚀
