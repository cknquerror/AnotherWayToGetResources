package ru.cknquerror.awtgr;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsRegister {

	public static Item WOODIRT_SHOVEL = new ItemWoodirtShovel(ToolMaterial.WOOD, "woodirt_shovel");
	public static Item WOODEN_EXTRACTOR = new ItemWoodenResourceExtractor(ToolMaterial.WOOD, "wooden_resource_extractor");
	public static Item BIT_OF_IRON = new ItemBitOfIron("bit_of_iron");
	public static Item BASIC_DIRT_UPGRADE = new ItemBasicDirtUpgrade("basic_dirt_upgrade");
	public static Item ENCHANCED_DIRT_UPGRADE = new ItemEnchancedDirtUpgrade("enchanced_dirt_upgrade");
	public static Item IRON_EXTRACTOR = new ItemIronResourceExtractor(ToolMaterial.IRON, "iron_resource_extractor");

    public static void register()
    {
        setRegister(WOODIRT_SHOVEL);
        setRegister(WOODEN_EXTRACTOR);
        setRegister(BIT_OF_IRON);
        setRegister(BASIC_DIRT_UPGRADE);
        setRegister(ENCHANCED_DIRT_UPGRADE);
        setRegister(IRON_EXTRACTOR);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        setRender(WOODIRT_SHOVEL);
        setRender(WOODEN_EXTRACTOR);
        setRender(BIT_OF_IRON);
        setRender(BASIC_DIRT_UPGRADE);
        setRender(ENCHANCED_DIRT_UPGRADE);
        setRender(IRON_EXTRACTOR);
    }

    private static void setRegister(Item item)
    {
        ForgeRegistries.ITEMS.register(item);
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Item item)
    {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
	
}
