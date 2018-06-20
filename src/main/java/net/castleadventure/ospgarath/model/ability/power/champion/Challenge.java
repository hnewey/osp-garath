package net.castleadventure.ospgarath.model.ability.power.champion;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Challenge extends Power {

    public Challenge() {
        name = "Challenge";
        description = "After a successful melee attack, you may immediately challenge an enemy within 6 spaces. While you or that enemy is conscious, both roll as though hampered on all rolls made against any target other than each other (Free Action/unlimited)";
    }
}
