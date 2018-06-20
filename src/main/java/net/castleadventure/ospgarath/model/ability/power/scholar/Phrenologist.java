package net.castleadventure.ospgarath.model.ability.power.scholar;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Phrenologist extends Power {

    public Phrenologist() {
        name = "Phrenologist Command";
        description = "If you have previously successfully evaluated an enemy, you may let a teammate make an attack against that enemy in place of your current turn. If the teammate’s attack is successful, the enemy suffers a unique depowered negative condition, and cannot use any class traits or powers until this condition is healed or resisted. Additionally, any rolls made to heal or resist this powerless condition are reduced by the amount of the scholar’s leadership bonus (Free Action/1 time per game).";
    }
}
