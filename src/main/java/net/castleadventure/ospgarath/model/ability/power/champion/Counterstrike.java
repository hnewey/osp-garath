package net.castleadventure.ospgarath.model.ability.power.champion;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Counterstrike extends Power {

    public Counterstrike() {
        name = "Counterstrike";
        description = "Once an attack has been announced against you from an adjacent space, you may declare the use of Counterstrike. You make an attack roll at the same time as your attacker.  If your attack roll is successful, your target’s attack fails, and any powers involved in their attack are expended and lost, while your attack succeeds. Once you have made this declaration, the attacker must follow through with their attack and cannot add to the attack or alter it. (Free Action/1 time per game).";
    }

}
