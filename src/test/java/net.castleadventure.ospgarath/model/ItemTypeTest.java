package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.model.item.itemType.ItemType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ItemTypeTest {

    private double testIterations = 10000000;

    private Map<ItemType, Integer> itemTypes = new HashMap<>();

    @Test
    public void getRandomItemType_Test() {
        for (int i = 0; i < testIterations; i++) {
            ItemType item = ItemType.generateRandomItemType();
            if (itemTypes.get(item) == null) {
                itemTypes.put(item, 1);
                continue;
            }
            Integer count = itemTypes.get(item) + 1;
            itemTypes.replace(item, count);
        }

        for (ItemType itemType : itemTypes.keySet()) {
            System.out.println(itemType + ": " + getPercentage(itemTypes.get(itemType)) + "%");
        }
    }

    private double getPercentage(int itemTypeCount) {
        return (itemTypeCount / testIterations) * 100f;
    }
}
