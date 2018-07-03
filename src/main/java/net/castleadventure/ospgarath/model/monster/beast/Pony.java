package net.castleadventure.ospgarath.model.monster.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.PackAnimal;
import net.castleadventure.ospgarath.model.ability.power.beast.Spur;

public class Pony extends Beast {

    public Pony() {
        mount = true;

        strength = 14;
        quickness = 9;
        intelligence = 12;
        leadership = 10;
        endurance = 7;
        speed = 7;
        damage = 3;

        addPower(new Spur());
        addPower(new PackAnimal());
    }
}
