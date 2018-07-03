package net.castleadventure.ospgarath.model.monster.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.SneakThief;

public class Weasel extends Beast {

    public Weasel() {
        canSpecialAttack = false;
        canRidePlayer = true;

        strength = 5;
        quickness = 18;
        intelligence = 8;
        leadership = 4;
        endurance = 2;
        speed = 8;
        damage = 1;

        addPower(new SneakThief());
    }
}
