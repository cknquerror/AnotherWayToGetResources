package cknquerror.awtgr.block;

import cknquerror.awtgr.utils.InstrumentLevel;
import cknquerror.awtgr.utils.ToolUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

public class BlockEnchancedIronDirt extends Block implements IExtractable{

	public BlockEnchancedIronDirt(Material materialIn, String name) {
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
        return InstrumentLevel.IRON;
    }

    @Override
    public void extract(EntityPlayer player, EnumHand hand) {
        ToolUtils.rightClick(player,hand,new ItemStack(Blocks.COBBLESTONE),new ItemStack(Items.IRON_NUGGET,14));

    }
}
