package ru.cknquerror.awtgr;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class CraftingRegister {

	 public static void register()
	    {
	        registerRecipes("woodirt_shovel");
	        registerRecipes("wooden_resource_extractor");
	        registerRecipes("iron_nugget_from_bit");
	        registerRecipes("basic_dirt_upgrade");
	        registerRecipes("iron_dirt");
	        registerRecipes("enchanced_dirt_upgrade");
	        registerRecipes("enchanced_iron_dirt");
	    }

	    private static void registerRecipes(String name)
	    {
	        CraftingHelper.register(new ResourceLocation("awtgr", name), (IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
	    }
	
}
