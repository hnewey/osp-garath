package net.castleadventure.ospgarath.model.ability.power.shepherd;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class TamingBeast extends Power {

    public TamingBeast() {
        name = "Taming the Beast";
        description = "The shepherd may roll L vs L against enemies classified as beasts, taking a -1 penalty for each space that exists between himself and the beast. If the Shepherd succeeds this roll by 10 or more, the animal becomes one of his animal companions. Unless otherwise specified, animals added in this way are classified as “untamed” (Standard Action/unlimited).";
    }
}
