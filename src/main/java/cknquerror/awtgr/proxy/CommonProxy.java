package ru.cknquerror.awtgr.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import cknquerror.awtgr.block.BlocksRegister;
import cknquerror.awtgr.register.ItemsRegister;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
    	BlocksRegister.register();
    	ItemsRegister.register();
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
