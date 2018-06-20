package net.castleadventure.ospgarath.model.ability.power.mariner;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class DirtyTrick extends Power {

    public DirtyTrick() {
        name = "Dirty Trick";
        description = "When an enemy ends its movement on a space adjacent to you and attempts to make an attack, you may immediately interrupt the attack to perform a dirty trick, so long as you can explain an appropriate dirty trick to the GM. The attacker must immediately succeed on an L vs L roll against you or else become exhausted and immediately end their turn. If they do succeed on this roll, their attack continues unhindered. Once you have announced that you are using this power, your attacker cannot rescind or change their attack (Free Action/3 times per game).";
    }
}
