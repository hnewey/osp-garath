package net.castleadventure.ospgarath.model.ability.power.weaponmaster;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class Sunder extends Power {

    public Sunder() {
        name = "Sunder";
        description = "When wielding your weapon of choice, make any attack roll. If this attack is successful, your enemy has the choice of either:\n" +
                "(a) suffering a critical attack from you \n" +
                "(b) being subject to a damage roll and having an equipped weapon, item, armor or shield of your choice destroyed \n" +
                "(Standard Action/1 time per game)\n";
    }
}
