package net.castleadventure.ospgarath.model.ability.power.bard;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ClairvoyantChorus extends Power {

    public ClairvoyantChorus() {
        name = "Clairvoyant Chorus of Command";
        description = "Any time an enemy is preparing to roll a dice size smaller than a d20, you may attempt to guess the roll result on the face of the dice before it has actually been rolled. If you successfully guess the result, the dice result goes into effect, but you may then steal that dice and add it to your dice pool. At any time, you may add that stolen dice to a roll made by you or a teammate, but doing so causes you to lose the dice from your pool. (Free Action/ unlimited).";
    }
}
