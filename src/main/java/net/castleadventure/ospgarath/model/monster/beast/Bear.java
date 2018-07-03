package net.castleadventure.ospgarath.model.monster.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.Maul;

public class Bear extends Beast {

    public Bear() {
        untamed = true;

        strength = 21;
        quickness = 6;
        intelligence = 11;
        leadership = 5;
        endurance = 10;
        speed = 4;
        damage = 5;

        addPower(new Maul());
    }
}
