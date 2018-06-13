package net.castleadventure.ospgarath.model.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerEquippedItems {

    private Map<Integer, Item> equippedItems = new HashMap<>();
    public static Integer HAND_1 = 1;
    public static Integer HAND_2 = 2;
    public static Integer ARMOR = 3;
    public static Integer OTHER_1 = 4;
    public static Integer OTHER_2 = 5;
    public static Integer BODY = 6; //cape or cloak
    public static Integer HEAD = 7; //helmet, circlet, crown, etc.

    private static Integer SLOTS = 7;

    public PlayerEquippedItems() {
        equippedItems.put(HAND_1, null);
        equippedItems.put(HAND_2, null);
        equippedItems.put(ARMOR, null);
        equippedItems.put(OTHER_1, null);
        equippedItems.put(OTHER_2, null);
        equippedItems.put(BODY, null);
        equippedItems.put(HEAD, null);
    }

    public void setEquippedItem(Integer key, Item item) {
        if (equippedItems.get(key) == null) {
            equippedItems.put(key, item);
            item.doEffect();
        }
    }

    public Item getEquippedItem(Integer index) {
        return equippedItems.get(index);
    }

    public void addEffects() {
        for (Integer key : equippedItems.keySet()) {
            equippedItems.get(key).doEffect();
        }
    }

}
