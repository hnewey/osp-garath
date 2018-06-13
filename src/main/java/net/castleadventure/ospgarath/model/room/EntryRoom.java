package net.castleadventure.ospgarath.model.room;

import net.castleadventure.ospgarath.factory.ItemFactory;
import net.castleadventure.ospgarath.factory.RoomFactory;
import net.castleadventure.ospgarath.model.item.Item;

import java.util.List;

public class EntryRoom extends Room {

    private List<Item> starterItems;

    public EntryRoom() {
        roomType = RoomType.ENTRY;
        starterItems = ItemFactory.getStarterItems();
        this.numConnectingRooms = 3;
        roomIntro = "A large, cavernous room opens up before you. The sheer scope of the place is confusing due to the \n" +
                "diminutive nature of the building from outside. Four large pillars reach to the ceiling, surrounding a number \n" +
                "of small pedestals in the center of the room. As you approach, you notice different items on each \n" +
                "pedestal. You see the following: " + starterItemsToString();
    }

    @Override
    public void initializeRoom() {
        if (connectingRooms.isEmpty()) {
            addConnectingRooms();
        }
    }

    private String starterItemsToString() {
        StringBuilder itemsString = new StringBuilder();
        int pedestalNum = 1;
        for (Item item : starterItems) {
            itemsString.append("\nPedestal").append(pedestalNum++).append(": ");
            itemsString.append(item.toString());
        }
        return itemsString.toString();
    }

    public List<Item> getStarterItems() {
        return starterItems;
    }
}
