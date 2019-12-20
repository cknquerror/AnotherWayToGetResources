package cknquerror.awtgr.block;

import java.util.Random;

import cknquerror.awtgr.utils.InstrumentLevel;
import cknquerror.awtgr.utils.ToolUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class BlockIronDirt extends Block implements IExtractable{

	public BlockIronDirt(Material materialIn, String name) {
		super(materialIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public InstrumentLevel getNeededLevel() {
        return InstrumentLevel.WOOD;
    }

    @Override
    public void extract(EntityPlayer player, EnumHand hand) {
        ToolUtils.rightClick(player,hand,new ItemStack(Blocks.DIRT),new ItemStack(Items.IRON_NUGGET));
    }

}
