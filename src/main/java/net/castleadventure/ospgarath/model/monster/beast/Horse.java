package net.castleadventure.ospgarath.model.monster.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.PackAnimal;
import net.castleadventure.ospgarath.model.ability.power.beast.Spur;

public class Horse extends Beast {

    public Horse() {
        mount = true;

        strength = 16;
        quickness = 7;
        intelligence = 12;
        leadership = 10;
        endurance = 8;
        speed = 8;
        damage = 4;

        addPower(new Spur());
        addPower(new PackAnimal());
    }
}
