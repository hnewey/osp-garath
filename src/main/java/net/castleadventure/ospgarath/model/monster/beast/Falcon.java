package net.castleadventure.ospgarath.model.monster.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.Stoop;

public class Falcon extends Beast {

    public Falcon() {
        canSpecialAttack = false;
        canRidePlayer = true;

        strength = 5;
        quickness = 16;
        intelligence = 7;
        leadership = 10;
        endurance = 3;
        speed = 10;
        damage = 1;

        addPower(new Stoop());
    }
}
