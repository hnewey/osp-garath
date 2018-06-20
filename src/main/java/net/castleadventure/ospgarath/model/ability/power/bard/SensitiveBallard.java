package net.castleadventure.ospgarath.model.ability.power.bard;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class SensitiveBallard extends Power {

    public SensitiveBallard() {
        name = "Sensitive Power Ballad of Command";
        description = "As a standard action, roll a four sided dice. Then, as a second roll, roll a number of four sided dice equal to the result of your first roll. Add up the total of the numbers rolled, and roll that many four sided dice as a third roll. The total of this third roll is equal to the number of spaces in a radius that make up an aura centered around the bard.  These spaces move with the bard, and all creatures within them fall into the zone of the Sensitive Power Ballad of Command. Other than the bard, any creature within this aura that makes a roll of the 20 sided dice rolls an extra 20 sided dice as well. The bard then chooses the result that he finds more favorable. This effect can be maintained each round as a quick action by succeeding on an L roll of 5, then 10 the following round, then 15, then 20, then 25, etc., so long as the bard does not un-equip the musical instrument he is using, fall unconscious, or use any other powers (Standard Action/1 time per game).";
    }
}
