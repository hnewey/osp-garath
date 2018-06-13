package net.castleadventure.ospgarath.model.item.itemType;

import net.castleadventure.ospgarath.model.item.Item;

import java.util.Random;

public class Armor extends Item {

    private enum ArmorType {
        LIGHT, HEAVY, SHIELD
    }

    private ArmorType armorType;

    public Armor() {
        this.armorType = ArmorType.values()[new Random().nextInt(ArmorType.values().length)];

        setItemInfo(ItemType.ARMOR, false, true, null, this.toString());
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
        return this.armorType.toString();
    }
}
