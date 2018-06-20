package net.castleadventure.ospgarath.model.ability.power.captain;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class SoundTheHorn extends Power {

    public SoundTheHorn() {
        name = "Sound the Horn Command";
        description = "An aura extends out 3 spaces from the captain. No enemies may enter or stay in this zone unless they succeed on a quick action L vs L roll against the captain on their turn. This power can be maintained by the captain each round as an extra action as though it were a positive condition (Standard action/1 time per game).";
    }
}
