package net.castleadventure.ospgarath.model.monster.beast;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.model.ability.power.beast.Versatile;

import java.util.ArrayList;
import java.util.List;

public class Dog extends Beast {

    public Dog() {
        adjustAbilities();
        this.endurance = 4;
        this.speed = 8;

        if(this.strength > 10) {
            this.damage = 3;
        }
        else {
            this.damage = 2;
        }

        addPower(new Versatile());
    }

    private void adjustAbilities() {
        String[] abilities = new String[] {"s", "q", "i", "l"};
        Integer add = Dice.d4();
        Integer minus;

        do {
            minus = Dice.d4();
        } while (add.equals(minus));

        for (int i = 1; i<=abilities.length; i++) {
            int score = 10;
            if (i == add)
                score = 14;
            if (i == minus)
                score = 8;

            switch (abilities[i-1]) {
                case "s":
                    this.strength = score;
                    continue;
                case "q":
                    this.quickness = score;
                    continue;
                case "i":
                    this.intelligence = score;
                    continue;
                default:
                    this.leadership = score;
            }
        }
    }
}
