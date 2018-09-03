package net.castleadventure.ospgarath.model.character.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.Pester;

public class Bird extends Beast {

    public Bird() {
        canSpecialAttack = false;
        canRidePlayer = true;

        strength = 2;
        quickness = 20;
        intelligence = 5;
        leadership = 3;
        endurance = 1;
        speed = 10;
        damage = 0;

        addPower(new Pester());
    }
}
