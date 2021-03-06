package mcjty.rftools.crafting;

import mcjty.rftools.GeneralConfiguration;
import mcjty.rftools.blocks.ModBlocks;
import mcjty.rftools.blocks.blockprotector.BlockProtectorSetup;
import mcjty.rftools.blocks.booster.BoosterSetup;
import mcjty.rftools.blocks.builder.BuilderSetup;
import mcjty.rftools.blocks.crafter.CrafterSetup;
import mcjty.rftools.blocks.elevator.ElevatorSetup;
import mcjty.rftools.blocks.endergen.EndergenicSetup;
import mcjty.rftools.blocks.environmental.EnvironmentalSetup;
import mcjty.rftools.blocks.generator.CoalGeneratorSetup;
import mcjty.rftools.blocks.infuser.MachineInfuserSetup;
import mcjty.rftools.blocks.itemfilter.ItemFilterSetup;
import mcjty.rftools.blocks.logic.LogicBlockSetup;
import mcjty.rftools.blocks.monitor.MonitorSetup;
import mcjty.rftools.blocks.powercell.PowerCellSetup;
import mcjty.rftools.blocks.relay.RelaySetup;
import mcjty.rftools.blocks.screens.ScreenSetup;
import mcjty.rftools.blocks.security.SecuritySetup;
import mcjty.rftools.blocks.shield.ShieldSetup;
import mcjty.rftools.blocks.spawner.SpawnerSetup;
import mcjty.rftools.blocks.storage.ModularStorageSetup;
import mcjty.rftools.blocks.storagemonitor.StorageScannerSetup;
import mcjty.rftools.blocks.teleporter.TeleporterSetup;
import mcjty.rftools.items.ModItems;
import mcjty.rftools.items.SyringeItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;

public final class ModCrafting {
    static {
        RecipeSorter.register("rftools:shapedpreserving", PreservingShapedRecipe.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
        RecipeSorter.register("rftools:shapedorepreserving", PreservingShapedOreRecipe.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
        RecipeSorter.register("rftools:containeranditem", ContainerAndItemRecipe.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
        RecipeSorter.register("rftools:containertoitem", ContainerToItemRecipe.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
        RecipeSorter.register("rftools:nbtmatchingrecipe", NBTMatchingRecipe.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
    }

    public static void init() {
        initBaseCrafting();

        CoalGeneratorSetup.initCrafting();
        CrafterSetup.initCrafting();
        ModularStorageSetup.initCrafting();
        TeleporterSetup.initCrafting();
        ScreenSetup.initCrafting();
        LogicBlockSetup.initCrafting();
        MachineInfuserSetup.initCrafting();
        BuilderSetup.initCrafting();
        PowerCellSetup.initCrafting();
        RelaySetup.initCrafting();
        MonitorSetup.initCrafting();
        ShieldSetup.initCrafting();
        EnvironmentalSetup.initCrafting();
        SpawnerSetup.initCrafting();
        BlockProtectorSetup.initCrafting();
        ItemFilterSetup.initCrafting();
        SecuritySetup.initCrafting();
        EndergenicSetup.initCrafting();
        StorageScannerSetup.initCrafting();
        ElevatorSetup.initCrafting();
        BoosterSetup.initCrafting();
    }

    private static void initBaseCrafting() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.machineFrame), "ili", "g g", "ili", 'i', Items.IRON_INGOT, 'g', Items.GOLD_NUGGET, 'l', "dyeBlue"));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.machineBase), "   ", "ggg", "sss", 'g', Items.GOLD_NUGGET, 's', Blocks.STONE);

        GameRegistry.addRecipe(new ItemStack(ModItems.rfToolsManualItem), " r ", "rbr", " r ", 'r', Items.REDSTONE, 'b', Items.BOOK);
        GameRegistry.addRecipe(new ItemStack(ModItems.rfToolsShapeManualItem), " B ", "rbr", " r ", 'r', Items.REDSTONE, 'b', Items.BOOK, 'B', Items.BRICK);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.smartWrenchItem), "  i", " l ", "l  ", 'i', Items.IRON_INGOT, 'l', "dyeBlue"));
        GameRegistry.addRecipe(new ItemStack(ModItems.infusedDiamond), "sss", "sds", "sss", 's', ModItems.dimensionalShardItem, 'd', Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(ModItems.infusedEnderpearl), "sss", "sds", "sss", 's', ModItems.dimensionalShardItem, 'd', Items.ENDER_PEARL);

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.networkMonitorItem), "rlr", "iri", "rlr", 'r', Items.REDSTONE, 'i', Items.IRON_INGOT, 'l', "dyeBlack"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.modifierItem), "bpr", "rpr", "rpb", 'r', Items.REDSTONE, 'p', Items.PAPER, 'b', Items.BRICK));

        GameRegistry.addRecipe(new ItemStack(ModItems.syringeItem), "i  ", " i ", "  b", 'i', Items.IRON_INGOT, 'b', Items.GLASS_BOTTLE);

        String[] syringeMatcher = new String[] { "level", "mobId" };

        GameRegistry.addRecipe(new NBTMatchingRecipe(3, 3,
                                                     new ItemStack[]{SyringeItem.createMobSyringe(EntityIronGolem.class), SyringeItem.createMobSyringe(EntityEnderman.class), SyringeItem.createMobSyringe(EntitySnowman.class),
                                                             SyringeItem.createMobSyringe(EntityBat.class), SyringeItem.createMobSyringe(EntityOcelot.class), SyringeItem.createMobSyringe(EntityGuardian.class),
                                                             SyringeItem.createMobSyringe(EntityWolf.class), SyringeItem.createMobSyringe(EntityPigZombie.class), SyringeItem.createMobSyringe(EntityMooshroom.class)},
                                                     new String[][]{syringeMatcher, syringeMatcher, syringeMatcher, syringeMatcher, syringeMatcher, syringeMatcher, syringeMatcher, syringeMatcher, syringeMatcher},
                                                     new ItemStack(ModItems.peaceEssenceItem)));

        int dimShardCraftability;
        if (Loader.isModLoaded("rftoolsdim")) {
            dimShardCraftability = GeneralConfiguration.dimensionalShardRecipeWithDimensions;
        } else {
            dimShardCraftability = GeneralConfiguration.dimensionalShardRecipeWithoutDimensions;
        }

        switch (dimShardCraftability) {
            case GeneralConfiguration.CRAFT_NONE:
                break;
            case GeneralConfiguration.CRAFT_EASY:
                GameRegistry.addRecipe(new ItemStack(ModItems.dimensionalShardItem, 8), " d ", "irg", " q ", 'd', Items.DIAMOND, 'g', Items.GOLD_INGOT,
                                       'i', Items.IRON_INGOT, 'q', Items.QUARTZ);
                break;
            case GeneralConfiguration.CRAFT_HARD:
                GameRegistry.addRecipe(new ItemStack(ModItems.dimensionalShardItem, 8), "deg", "irG", "qcL", 'd', Items.DIAMOND, 'e', Items.EMERALD, 'g', Items.GOLD_INGOT,
                                       'i', Items.IRON_INGOT, 'r', Items.REDSTONE, 'G', Items.GLOWSTONE_DUST, 'q', Items.QUARTZ, 'c', Items.PRISMARINE_SHARD, 'L', Blocks.GLASS);
                break;
        }
    }
}
