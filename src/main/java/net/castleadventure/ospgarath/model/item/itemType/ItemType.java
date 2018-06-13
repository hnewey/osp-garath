package net.castleadventure.ospgarath.model.item.itemType;

import java.util.Random;

public enum ItemType {

    GOLD(1),                //30%
    WEAPON(2),              //30%
    ARMOR(3),               //8%
    TAVERN_ITEM(4),         //8%
    BOOK(5),                //5%
    POTION(6),              //5%
    MUSICAL_INSTRUMENT(7),  //3.9%
    RELIC(8),               //.1%
    OTHER(9);               //10%

    private int value;

    ItemType (int value) {
        this.value = value;
    }

    public static ItemType getItemType(int value) {
        for(ItemType itemType : ItemType.values()){
            if(itemType.value == value){
                return itemType;
            }
        }
        throw new IllegalArgumentException();
    }

    public static ItemType generateRandomItemType() {
        Random random = new Random();
        int value = random.nextInt(1000) + 1;

        if (value == 1000) {
            return RELIC;
        }
        if (value >= 961) {
            return MUSICAL_INSTRUMENT;
        }
        if (value >= 911) {
            return POTION;
        }
        if (value >= 861) {
            return BOOK;
        }
        if (value >= 781) {
            return TAVERN_ITEM;
        }
        if (value >= 701) {
            return ARMOR;
        }
        if (value >= 401) {
            return WEAPON;
        }
        if (value >= 101) {
            return GOLD;
        }
        return OTHER;
    }


}
