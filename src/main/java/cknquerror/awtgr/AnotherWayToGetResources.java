package cknquerror.awtgr;

import cknquerror.awtgr.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = "awtgr", name = "AnotherWayToGetResources", version = "1.0")

public class AnotherWayToGetResources {
	
	@SidedProxy(clientSide = "ru.cknquerror.awtgr.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
        System.out.println("\u001B[32m" + "[AWTRG POST-INIT]" + "\u001B[0m");
    }
	
}
