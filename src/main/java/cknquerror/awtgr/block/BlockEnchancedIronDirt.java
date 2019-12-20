package cknquerror.awtgr.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockEnchancedIronDirt extends Block{

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

}
