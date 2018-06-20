package net.castleadventure.ospgarath.model.ability.power.brawler;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Finisher extends Power {

    public Finisher() {
        name = "Finisher";
        description = "When grappled, perform a grapple maneuver. If successful, you deal an extra roll of damage, even if the maneuver is not the type that deals damage, and the target of the attack is paralyzed for one round and knocked over (Standard Action/1 time per game).";
    }
}
