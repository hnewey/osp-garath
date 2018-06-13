package net.castleadventure.ospgarath.model.item.itemType;

import net.castleadventure.ospgarath.model.item.Item;

import java.util.Random;

public class TavernItem extends Item {

    private enum TavernItemType {
        WAYBREAD, ATHELAS, FIREWOOD, BEDROLL, TORCH, HEALING_HERBS, ROPE
    }

    private TavernItemType tavernItemType;

    public TavernItem() {
        this.tavernItemType = TavernItemType.values()[new Random().nextInt(TavernItemType.values().length)];

        switch (tavernItemType) {
            case WAYBREAD:
                setItemInfo(ItemType.TAVERN_ITEM, true, false, 3, tavernItemType.toString());
                break;
            case ATHELAS:
                setItemInfo(ItemType.TAVERN_ITEM, true, false, 2, tavernItemType.toString());
                break;
            case FIREWOOD:
                setItemInfo(ItemType.TAVERN_ITEM, true, false, 1, tavernItemType.toString());
                break;
            case BEDROLL:
                setItemInfo(ItemType.TAVERN_ITEM, false, false, null, tavernItemType.toString());
                break;
            case TORCH:
                setItemInfo(ItemType.TAVERN_ITEM, false, true, null, tavernItemType.toString());
                break;
            case HEALING_HERBS:
                setItemInfo(ItemType.TAVERN_ITEM, true, false, 1, tavernItemType.toString());
                break;
            case ROPE:
                setItemInfo(ItemType.TAVERN_ITEM, false, false, null, tavernItemType.toString());
        }
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
        return this.tavernItemType.toString();
    }
}
