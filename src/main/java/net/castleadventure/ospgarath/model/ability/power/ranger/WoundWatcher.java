package net.castleadventure.ospgarath.model.ability.power.ranger;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class WoundWatcher extends Power {

    public WoundWatcher() {
        name = "Wound of the Watcher";
        description = "Pick one target within 6 spaces. If you choose to activate the power this turn, you make a ranged attack against that target, adding 1d3 to your attack roll and rolling damage as though it were a melee attack. However, if you choose to charge this power instead of activating it, each turn that you charge it adds an extra 1d3 to the attack roll, and one additional damage roll from you. If you are successfully attacked while charging this power, you must succeed on a L10 roll or else the power fails and is lost. (Standard Action/1 time per game).";
    }
}
