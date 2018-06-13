package net.castleadventure.ospgarath.factory;

import net.castleadventure.ospgarath.model.item.Item;
import net.castleadventure.ospgarath.model.item.itemType.*;
import net.castleadventure.ospgarath.model.item.itemType.relic.Relic;

import java.util.ArrayList;
import java.util.List;

public final class ItemFactory {

    public static List<Item> getStarterItems() {
        List<Item> starterItems = new ArrayList<>();
        starterItems.add(new Weapon());
        starterItems.add(new Weapon());
        starterItems.add(new Weapon());
        starterItems.add(new Armor());
        starterItems.add(new Armor());
        starterItems.add(new Potion());
        starterItems.add(new TavernItem());
        starterItems.add(new TavernItem());
        starterItems.add(new TavernItem());
        starterItems.add(new OtherItem());
        starterItems.add(new Book());
        return starterItems;
    }

    public static Item generateItem(String itemType) throws Exception {
        itemType = itemType.toUpperCase();
        switch(itemType) {
            case "WEAPON":
                return new Weapon();
            case "ARMOR":
                return new Armor();
            case "TAVERN_ITEM":
                return new TavernItem();
            case "POTION":
                return new Potion();
            case "BOOK":
                return new Book();
            case "INSTRUMENT":
                return new Instrument();
            case "RELIC":
                return new Relic();
            case "OTHER":
                return new OtherItem();
            default:
                throw new Exception("Unsupported item type");
        }
    }

}
