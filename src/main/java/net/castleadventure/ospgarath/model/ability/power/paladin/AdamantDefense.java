package net.castleadventure.ospgarath.model.ability.power.paladin;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class AdamantDefense extends Power {

    public AdamantDefense() {
        name = "Adamant Defense";
        description = "Once an attack has been announced against you or a teammate within 6 spaces, you may declare the use of Adamant Defense. The attacking character gets a -5 to the subsequent attack roll. Once you have made this declaration, the attacker must follow through with their attack and cannot add to the attack or alter it. If the attacker fails this attack they gain the exhausted condition. (Free Action/1 time per game).";
    }
}
