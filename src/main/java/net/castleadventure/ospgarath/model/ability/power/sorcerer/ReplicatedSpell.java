package net.castleadventure.ospgarath.model.ability.power.sorcerer;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class ReplicatedSpell extends Power {

    public ReplicatedSpell() {
        name = "Replicated Spell Power";
        description = "After an enemy within 8 spaces of you has used a power with the word “spell” in its title, you may immediately attempt an I 15 roll. If successful, you now have one use of that spell in addition to your own powers. Only one replicated spell may be stolen and stored at a time (Innate/unlimited).";
    }
}
