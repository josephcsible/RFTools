package mcjty.rftools.blocks.generator;

import net.minecraftforge.common.config.Configuration;

public class CoalGeneratorConfiguration {

    public static final String CATEGORY_COALGEN = "coalgen";
    public static int MAXENERGY = 500000;
    public static int SENDPERTICK = 2000;
    public static int rfPerTick = 60;
    public static int ticksPerCoal = 600;

    public static void init(Configuration cfg) {
        rfPerTick = cfg.get(CATEGORY_COALGEN, "generatePerTick", rfPerTick, "Amount of RF generated per tick").getInt();
        ticksPerCoal = cfg.get(CATEGORY_COALGEN, "ticksPerCoal", ticksPerCoal, "Amount of ticks generated per coal").getInt();
        MAXENERGY = cfg.get(CATEGORY_COALGEN, "crafterMaxRF", MAXENERGY,
                "Maximum RF storage that the crafter can hold").getInt();
        SENDPERTICK = cfg.get(CATEGORY_COALGEN, "crafterRFPerTick", SENDPERTICK,
                "RF per tick that the crafter can send").getInt();
    }
}