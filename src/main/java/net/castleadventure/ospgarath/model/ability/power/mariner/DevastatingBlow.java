package net.castleadventure.ospgarath.model.ability.power.mariner;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class DevastatingBlow extends Power {

    public DevastatingBlow() {
        name = "Devastating Blow";
        description = "When attacking an enemy that is adjacent to one of your teammates, and who has attacked or been attacked by that teammate within the last round, you may make an attack that deals an extra damage roll if successful, even if it is not a type of attack that normally deals damage. If your attack is successful, all of your enemies within 6 spaces of the target gain the shaken and weakened conditions (Standard Action/1 time per game).";
    }
}
