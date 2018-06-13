package net.castleadventure.ospgarath.model.item;

import net.castleadventure.ospgarath.model.item.itemType.ItemType;
import net.castleadventure.ospgarath.game.GameState;

public abstract class Item {

    private ItemType type;
    private Boolean useable;
    private Boolean equippable;
    private Integer uses;
    private String name;

    public ItemType getType() {
        return type;
    }

    public Integer getUses() {
        return uses;
    }

    public String getName() {
        return name;
    }

    public Boolean isUseable() {
        if (useable != null) {
            return useable;
        }
        return false;
    }

    public Boolean isEquippable() {
        if (equippable != null) {
            return equippable;
        }
        return false;
    }

    protected abstract void use();
    protected abstract void equip();
    protected abstract void unequip();
    protected abstract void doEffect();
    protected abstract void endEffect();

    public void useItem() {
        uses--;
        use();
        if (uses == 0) {
            GameState.getInstance().printMessage(name + " used up");
        }
    }

    protected void setItemInfo(ItemType type, Boolean useable, Boolean equippable, Integer uses, String name) {
        if (uses != null && uses == -1) {
            System.out.println("-1 found on type: " + type);;
        }
        this.type = type;
        this.useable = useable;
        this.equippable = equippable;
        this.uses = uses;
        this.name = name;
    }
}
