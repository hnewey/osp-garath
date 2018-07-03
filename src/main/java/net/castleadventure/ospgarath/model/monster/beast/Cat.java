package net.castleadventure.ospgarath.model.monster.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.Snuggling;

public class Cat extends Beast {

    public Cat() {
        canSpecialAttack = false;
        canRidePlayer = true;

        strength = 4;
        quickness = 16;
        intelligence = 14;
        leadership = 2;
        endurance = 2;
        speed = 8;
        damage = 0;

        addPower(new Snuggling());
    }
}
