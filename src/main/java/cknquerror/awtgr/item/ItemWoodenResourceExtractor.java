package cknquerror.awtgr.item;

import java.util.List;

import javax.annotation.Nullable;

import cknquerror.awtgr.block.BlockIronDirt;
import cknquerror.awtgr.block.IExtractable;
import cknquerror.awtgr.register.ItemsRegister;
import cknquerror.awtgr.utils.InstrumentLevel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Int;

public class ItemWoodenResourceExtractor extends Extractor {
	
	
	public ItemWoodenResourceExtractor(ToolMaterial material, String name) {
		super(name, material);

		this.setMaxDamage(750);
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);



		return EnumActionResult.SUCCESS;
    }
	


	@Override
	public InstrumentLevel getLevel() {
		return InstrumentLevel.WOOD;
	}
}
	


