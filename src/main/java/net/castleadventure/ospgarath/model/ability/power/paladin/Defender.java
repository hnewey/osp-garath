package net.castleadventure.ospgarath.model.ability.power.paladin;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Defender extends Power {

    public Defender() {
        name = "Defender";
        description = "May immediately make a movement and take half or full damage for a teammate within 6 spaces so long as you can end your movement on a space adjacent to that teammate. This movement provokes no free attacks (Movement and Free Action/3 times per game).";
    }
}
