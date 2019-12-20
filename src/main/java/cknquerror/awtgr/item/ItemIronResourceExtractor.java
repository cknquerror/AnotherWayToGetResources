package cknquerror.awtgr.item;

import java.util.List;

import javax.annotation.Nullable;

import cknquerror.awtgr.block.BlockEnchancedIronDirt;
import cknquerror.awtgr.block.BlockIronDirt;
import cknquerror.awtgr.utils.InstrumentLevel;
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

public class ItemIronResourceExtractor extends Extractor {

	public ItemIronResourceExtractor(ToolMaterial material, String name) {
		super(name, material);

		this.setMaxDamage(1500);
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);



        

		return EnumActionResult.SUCCESS;
    }
	


	@Override
	public InstrumentLevel getLevel() {
		return InstrumentLevel.IRON;
	}
}
