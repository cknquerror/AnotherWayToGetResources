package cknquerror.awtgr.item;

import cknquerror.awtgr.block.IExtractable;
import cknquerror.awtgr.register.ItemsRegister;
import cknquerror.awtgr.utils.InstrumentLevel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

import javax.annotation.Nullable;
import java.util.List;

public abstract class Extractor extends ItemSpade {
    public abstract InstrumentLevel getLevel();
    public Extractor(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Block block = worldIn.getBlockState(pos).getBlock();
        if(block instanceof IExtractable && !player.isSneaking()) {
            if(getLevel().isGreaterThan(((IExtractable)block).getNeededLevel()))
                ((IExtractable)block).extract(player, hand);
        }
        if(worldIn.getBlockState(pos).getBlock() instanceof BlockPlanks && !player.isSneaking()) {
            ItemStack item = player.getHeldItem(hand);

            if(!item.hasTagCompound()) {
                NBTTagCompound nbbbt = new NBTTagCompound();
                nbbbt.setInteger("clicks", 0);
                nbbbt.setInteger("mode", 0);
                item.setTagCompound(nbbbt);
            } else {
                item.damageItem(10, player);
                NBTTagCompound nbt = item.getTagCompound();
                if(nbt.getInteger("mode") == 0) {
                    Integer res = nbt.getInteger("clicks");
                    if(res < 14) {
                        nbt.setInteger("clicks", res + 1);
                        player.addItemStackToInventory(new ItemStack(Blocks.DIRT));
                    } else if(res == 14) {
                        player.addItemStackToInventory(new ItemStack(ItemsRegister.BIT_OF_IRON));
                        nbt.setInteger("clicks", 0);
                    }
                }
            }
        }
        if(player.isSneaking()) {
            modeSwitch(player, hand);

        }
        return EnumActionResult.SUCCESS;
    }

    protected void modeSwitch(EntityPlayer player, EnumHand hand){
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
