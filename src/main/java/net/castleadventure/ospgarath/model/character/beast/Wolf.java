package net.castleadventure.ospgarath.model.character.beast;

import net.castleadventure.ospgarath.model.ability.power.beast.Ferocious;

public class Wolf extends Beast {

    public Wolf() {
        untamed = true;

        strength = 16;
        quickness = 12;
        intelligence = 8;
        leadership = 10;
        endurance = 5;
        speed = 8;
        damage = 4;

        addPower(new Ferocious());
    }
}
