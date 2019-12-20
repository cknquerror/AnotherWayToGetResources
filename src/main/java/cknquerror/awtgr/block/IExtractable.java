package cknquerror.awtgr.block;

import cknquerror.awtgr.utils.InstrumentLevel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

public interface IExtractable {
    void extract(EntityPlayer player, EnumHand hand);
    InstrumentLevel getNeededLevel();
}
