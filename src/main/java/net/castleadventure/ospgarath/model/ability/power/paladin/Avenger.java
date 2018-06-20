package net.castleadventure.ospgarath.model.ability.power.paladin;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Avenger extends Power {

    public Avenger() {
        name = "Avenger";
        description = "Once an attack has failed against you or a teammate within 6 spaces, you may declare the use of Avenger. You move up to your full movement speed if necessary, so long as you end your movement on a space adjacent to the enemy that failed their attack. That enemy must then succeed at a L vs S roll against you or else gain the paralyzed condition. Your movement when using Avenger provokes no free attacks (Free Action/1 time per game).";
    }
}
