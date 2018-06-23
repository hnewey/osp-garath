package net.castleadventure.ospgarath.model.ability.power.racialPowers;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Bloodlust extends Power {

    public Bloodlust() {
        name = "Bloodlust";
        description = "If you can succeed on a S 15 roll, you can use a quick action to eat a portion of one of your adjacent kills, regaining Endurance ranging from (1-L Bonus of your target)+2. If done in battle, this provokes a free attack, but causes all enemies within 4 spaces to become shaken. If the roll fails, this power is not used (Quick Action/1 time per game).";
        powerCost = "0";
    }
}
