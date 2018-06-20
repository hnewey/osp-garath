package net.castleadventure.ospgarath.model.ability.power.necromancer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Lifesap extends Power {

    public Lifesap() {
        name = "Lifesap Spell";
        description = "Whenever another character within 6 spaces is damaged, you or your Shadow Servant can immediately acquire the amount of damaged Endurance points and add them to your Endurance, even exceeding maximum Endurance. To do this, you must succeed on a I vs S roll against the damaged target. If your roll fails, this power is not expended (Free Action/3 times per game).";
    }
}
