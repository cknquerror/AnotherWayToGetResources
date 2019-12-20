package ru.cknquerror.awtgr;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlocksRegister {

	public static Block IRON_DIRT = new BlockIronDirt(Material.GROUND, "iron_dirt");
	public static Block ENCHANCED_IRON_DIRT = new BlockEnchancedIronDirt(Material.GROUND, "enchanced_iron_dirt");

    public static void register()
    {
        setRegister(IRON_DIRT);
        setRegister(ENCHANCED_IRON_DIRT);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        setRender(IRON_DIRT);
        setRender(ENCHANCED_IRON_DIRT);
    }

    private static void setRegister(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block block)
    {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
	
}
