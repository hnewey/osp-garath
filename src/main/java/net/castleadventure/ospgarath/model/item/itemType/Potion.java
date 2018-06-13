package net.castleadventure.ospgarath.model.item.itemType;

import net.castleadventure.ospgarath.model.item.Item;

import java.util.Random;

public class Potion extends Item {

    private enum PotionType {
        HEAL("Healer's Potion"),
        CAELEB("Caeleb's Legacy"),
        JOY("Oh Be Joyful"),
        STRONG("Strong and Sturdy"),
        FOCUS("Unwavering Focus"),
        STEADY("Steady As She Goes"),
        CONVICTION("Conviction"),
        NIGHT("Up In The Night"),
        SMOKE("Smoke Rings"),
        ORC("Orc Draught"),
        POWDER("Alchemy Powder");

        private String value;
        PotionType(String value) {
            this.value = value;
        }
    }

    private PotionType potionType;

    public Potion() {
        this.potionType = PotionType.values()[new Random().nextInt(PotionType.values().length)];
        setItemInfo(ItemType.POTION, true, true, 1, this.toString());
    }

    @Override
    protected void use() {
        //TODO: Add use for each potion. (write methods to 'roll' for how much character is healed, etc)
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
        return this.potionType.value;
    }
}
