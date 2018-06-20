package net.castleadventure.ospgarath.model.ability.power.alchemist;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ImprovisedBomb extends Power {

    public ImprovisedBomb() {
        name = "Improvised Spell Potion Bomb";
        description = "You may transform any potion in your inventory into a bomb. This bomb may be thrown up to 6 spaces and will detonate upon impact, but at the time it is thrown, you must roll a 4 sided dice. If you roll a 1, the bomb detonates on your space. You may also set the bomb with a fuse and pick a number of rounds from 1-4 for the fuse to go off. Once the fuse is lit, it cannot be put out, and the bomb will detonate at the end of the fuse time (at beginning of turn), or if it is hit with an attack roll of 8 or higher. Once it has detonated, all creatures within 4 spaces of the bomb must succeed on an L 15 roll or else be subject to 2 damage rolls ranging from (1-I Bonus)+1.  Regardless of whether or not they succeed on their L 15 roll, all creatures within 4 spaces of the detonation must make a roll of the six sided dice and be subject to the following condition depending on the result:\n" +
                "1- Paralyzed               2- Weakened            3- Bleeding                \n" +
                "4- Exhausted             5- Immobilized         6- Nothing\n" +
                "(Standard Action/1 time per game).\n";
    }

}
