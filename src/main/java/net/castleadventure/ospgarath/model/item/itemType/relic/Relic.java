package net.castleadventure.ospgarath.model.item.itemType.relic;

import net.castleadventure.ospgarath.model.ability.Power;
import net.castleadventure.ospgarath.model.ability.Trait;
import net.castleadventure.ospgarath.model.item.Item;
import net.castleadventure.ospgarath.model.item.itemType.ItemType;
import net.castleadventure.ospgarath.model.item.itemType.relic.relicBehavior.RelicBehavior;

import java.util.List;

public class Relic extends Item {

    private List<Power> powers;
    private List<Trait> traits;

    private RelicBehavior relicBehavior;
    private ItemType itemType;

    @Override
    protected void use() {
        relicBehavior.use();
    }

    @Override
    protected void equip() {
        relicBehavior.equip();
    }

    @Override
    protected void unequip() {
        relicBehavior.unequip();
    }

    @Override
    protected void doEffect() {
        relicBehavior.doEffect();
    }

    @Override
    protected void endEffect() {
        relicBehavior.endEffect();
    }
}
