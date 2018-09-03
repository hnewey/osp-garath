package net.castleadventure.ospgarath.model.character.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.Infection;

public class Viper extends Beast {

    public Viper() {
        untamed = true;
        canSpecialAttack = false;
        canRidePlayer = true;

        strength = 13;
        quickness = 16;
        intelligence = 3;
        leadership = 2;
        endurance = 3;
        speed = 6;
        damage = 3;

        addPower(new Infection());
    }
}
