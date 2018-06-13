package net.castleadventure.ospgarath.model.item.itemType;

import net.castleadventure.ospgarath.model.item.Item;

import java.util.Random;

public class OtherItem extends Item{

    private enum OtherItemType {
        NECKLACE, CLOAK, CAPE, HELMET, CROWN, RING, PENDANT, ARMBAND, BANNER, HAT, CIRCLET, KEY
    }

    private OtherItemType otherItemType;

    public OtherItem() {
        this.otherItemType = OtherItemType.values()[new Random().nextInt(OtherItemType.values().length)];
        setItemInfo(ItemType.OTHER, false, true, null, otherItemType.toString());
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
        return otherItemType.toString();
    }
}
