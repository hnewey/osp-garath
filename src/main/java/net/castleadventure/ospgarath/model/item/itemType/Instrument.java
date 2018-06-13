package net.castleadventure.ospgarath.model.item.itemType;

import net.castleadventure.ospgarath.model.item.Item;

import java.util.Random;

public class Instrument extends Item {

    private enum InstrumentType {
        ONE_HANDED, TWO_HANDED
    }

    private InstrumentType instrumentType;

    public Instrument() {
        this.instrumentType = InstrumentType.values()[new Random().nextInt(InstrumentType.values().length)];
        setItemInfo(ItemType.MUSICAL_INSTRUMENT, false, true, null, this.toString());
    }

    @Override
    protected void use() {

    }

    @Override
    protected void equip() {

    }

    @Override
    protected void unequip() {

    }

    @Override
    protected void doEffect() {

    }

    @Override
    protected void endEffect() {

    }

    @Override
    public String toString() {
        return this.instrumentType.toString();
    }
}
