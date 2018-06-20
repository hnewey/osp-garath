package net.castleadventure.ospgarath.model.ability.power.mage;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ArcaneTether extends Power {

    public ArcaneTether() {
        name = "Arcane Tether";
        description = "Pick an an enemy target within six spaces. That target must succeed on a S vs I roll against you or else be moved to a space adjacent to you. If the enemy succeeds on their S vs I roll, you may choose not to expend this power, but as a result you gain the immobilized condition (Quick Action/3 times per game).";
    }
}
