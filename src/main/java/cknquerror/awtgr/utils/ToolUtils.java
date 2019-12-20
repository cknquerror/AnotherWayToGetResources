package cknquerror.awtgr.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

public class ToolUtils {
    public static void rightClick(EntityPlayer player, EnumHand hand, ItemStack ordinaryItem, ItemStack specialItem){
        ItemStack item = player.getHeldItem(hand);
        item.damageItem(1, player);
        if(!item.hasTagCompound()){
            NBTTagCompound nbbt = new NBTTagCompound();
            nbbt.setInteger("clicks", 1);
            nbbt.setInteger("mode", 1);
            item.setTagCompound(nbbt);
        }else{
            NBTTagCompound nbt = item.getTagCompound();
            if(nbt.getInteger("mode") == 1) {
                Integer res = nbt.getInteger("clicks");
                if(res < 14) {
                    nbt.setInteger("clicks", res + 1);
                    player.addItemStackToInventory(ordinaryItem);
                } else if(res == 14) {
                    player.addItemStackToInventory(specialItem);
                    nbt.setInteger("clicks", 0);
                }
            } else {
                player.sendMessage(new TextComponentString(I18n.translateToLocal("awtgr.messages.modechanges.wrong")));
            }
        }
    }
}
