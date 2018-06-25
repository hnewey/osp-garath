package net.castleadventure.ospgarath.model.ability.power.brawler;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class BearHug extends Power {

    public BearHug() {
        name = "Bear Hug";
        description = "In place of making a grapple maneuver, you may force the enemy you are grappling to succeed on a S vs S roll against you or else suffer the weakened condition and a damage roll from you (Standard Action/once per game).";
        powerCost = ".5";
    }
}
