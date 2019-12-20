package cknquerror.awtgr.item;

import net.minecraft.item.Item;

public class BaseItem extends Item {
    public BaseItem(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }
}
