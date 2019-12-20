package cknquerror.awtgr.item;

import java.util.List;

import javax.annotation.Nullable;

import cknquerror.awtgr.block.BlockIronDirt;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIronResourceExtractor extends ItemSpade {

	public ItemIronResourceExtractor(ToolMaterial material, String name) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setMaxDamage(1500);
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(worldIn.getBlockState(pos).getBlock() instanceof BlockIronDirt && !player.isSneaking()) {
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
						player.addItemStackToInventory(new ItemStack(Blocks.DIRT));
					} else if(res == 14) {
						player.addItemStackToInventory(new ItemStack(Items.IRON_NUGGET, 7));
						nbt.setInteger("clicks", 0);
					}  
				} else {
					player.sendMessage(new TextComponentString(I18n.translateToLocal("awtgr.messages.modechanges.wrong")));
				}
			}
		}
		if(worldIn.getBlockState(pos).getBlock() instanceof BlockPlanks && !player.isSneaking()) {
			ItemStack item = player.getHeldItem(hand);
			
			if(!item.hasTagCompound()) {
				NBTTagCompound nbbbt = new NBTTagCompound();
				nbbbt.setInteger("clicks", 0);
				nbbbt.setInteger("mode", 0);
				item.setTagCompound(nbbbt);
			} else {
				item.damageItem(5, player);
				NBTTagCompound nbt = item.getTagCompound();
				if(nbt.getInteger("mode") == 0) {
					Integer res = nbt.getInteger("clicks");
					if(res < 14) {
						nbt.setInteger("clicks", res + 1);
						player.addItemStackToInventory(new ItemStack(Blocks.DIRT));
					} else if(res == 14) {
						player.addItemStackToInventory(new ItemStack(Items.IRON_NUGGET, 1));
						nbt.setInteger("clicks", 0);
					}  
			} else {
				player.sendMessage(new TextComponentString(I18n.translateToLocal("awtgr.messages.modechanges.wrong")));
			}
		}
			}
		if(worldIn.getBlockState(pos).getBlock() instanceof BlockEnchancedIronDirt && !player.isSneaking()) {
            ItemStack item = player.getHeldItem(hand);
			
			if(!item.hasTagCompound()) {
				NBTTagCompound nbbbt = new NBTTagCompound();
				nbbbt.setInteger("clicks", 0);
				nbbbt.setInteger("mode", 1);
				item.setTagCompound(nbbbt);
			} else {
				NBTTagCompound nbt = item.getTagCompound();
				if(nbt.getInteger("mode") == 1) {
					item.damageItem(1, player);
						Integer res = nbt.getInteger("clicks");
						if(res < 14) {
							nbt.setInteger("clicks", res + 1);
							player.addItemStackToInventory(new ItemStack(Blocks.COBBLESTONE));
						} else if(res == 14) {
							player.addItemStackToInventory(new ItemStack(Items.IRON_NUGGET, 14 ));
							nbt.setInteger("clicks", 0);
						}
				  
			} else {
				player.sendMessage(new TextComponentString(I18n.translateToLocal("awtgr.messages.modechanges.wrong")));
			}
		}
		}
		if(player.isSneaking()) {
			ItemStack item = player.getHeldItem(hand);
			if(!item.hasTagCompound()) {
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setInteger("clicks", 0);
				nbt.setInteger("clicks", 0);
		} else {
			Integer mode = item.getTagCompound().getInteger("mode");
			if(mode == 0) {
				item.getTagCompound().setInteger("mode", 1);
				item.getTagCompound().setInteger("clicks", 0);
				player.sendMessage(new TextComponentString(I18n.translateToLocal("awtgr.messages.modechanges.ironfromirdirt")));
			} else {
			item.getTagCompound().setInteger("mode", 0);
			item.getTagCompound().setInteger("clicks", 0);
			player.sendMessage(new TextComponentString(I18n.translateToLocal("awtgr.messages.modechanges.ironfromoak")));
			}
		}
        
    }
		return EnumActionResult.SUCCESS;
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
	    if(!stack.hasTagCompound()){
		    NBTTagCompound nbbt = new NBTTagCompound();
		    nbbt.setInteger("mode", 0);
		    nbbt.setInteger("clicks", 0);
		    stack.setTagCompound(nbbt);
		}
			NBTTagCompound nbt = stack.getTagCompound();
			Integer res = nbt.getInteger("clicks");
			tooltip.add(I18n.translateToLocal("awtgr.lores.clicksleft") + ": " + (15 - res));
			if(nbt.getInteger("mode") == 0) {
				tooltip.add(I18n.translateToLocal("awtgr.lores.itemmode") + " " + I18n.translateToLocal("awtgr.modes.extract.iron.fromoak"));
			} else if(nbt.getInteger("mode") == 1) {
				tooltip.add(I18n.translateToLocal("awtgr.lores.itemmode") + " " + I18n.translateToLocal("awtgr.modes.extract.iron.fromirondirt"));
			}
		}

}
