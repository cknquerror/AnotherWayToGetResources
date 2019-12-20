package cknquerror.awtgr.utils;

public enum InstrumentLevel {
    WOOD, IRON;
    public boolean isGreaterThan(InstrumentLevel level){
        return this.ordinal() >= level.ordinal();
    }
}
