package net.castleadventure.ospgarath.model.item;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {

    private static int INVENTORY_SIZE = 5;
    private List<Item> inventory;

    public PlayerInventory() {
        this.inventory = new ArrayList<>(INVENTORY_SIZE);
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public void addItem(Item item) throws Exception {
        if (inventory.size() < INVENTORY_SIZE) {
            inventory.add(item);
        }
        else {
            throw new Exception("Inventory is full");
        }
    }

    public void removeItem(int index) throws Exception {
        if (inventory.size() >= index) {
            inventory.remove(index);
        }
        else {
            throw new Exception("Invalid item index");
        }
    }

    public void clearInventory() {
        inventory.clear();
    }

    public void useItem(int index) throws Exception {
        if (inventory.size() >= index) {
            Item item = inventory.get(index);
            if (item.isUseable()) {
                item.useItem();
                if (item.getUses() == 0) {
                    inventory.remove(index);
                }
            }
        }
        else {
            throw new Exception("Invalid item index");
        }
    }
}
