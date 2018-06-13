package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.factory.ItemFactory;
import org.junit.Test;

public class ItemTest {

    private int numItems = 10;

    @Test
    public void testWeaponCreation() throws Exception {
        itemCreationHelper("weapon");
    }

    @Test
    public void testArmorCreation() throws Exception {
        itemCreationHelper("armor");
    }

    @Test
    public void testPotionCreation() throws Exception {
        itemCreationHelper("potion");
    }

    @Test
    public void testTavernItemCreation() throws Exception {
        itemCreationHelper("tavern_item");
    }

    @Test
    public void testInstrumentCreation() throws Exception {
        itemCreationHelper("instrument");
    }

    @Test
    public void testBookCreation() throws Exception {
        itemCreationHelper("book");
    }

    @Test
    public void testRelicCreation() throws Exception {
        itemCreationHelper("relic");
    }

    @Test
    public void testOtherCreation() throws Exception {
        itemCreationHelper("other");
    }

    @Test(expected = Exception.class)
    public void testInvalidItemType() throws Exception {
        itemCreationHelper("invalidItem");
    }

    private void itemCreationHelper(String itemType) throws Exception {
        System.out.println("\n***Test " + itemType + "s***");
        for (int i = 0; i < numItems; i++) {
            System.out.println(ItemFactory.generateItem(itemType).toString());
        }
    }
}
