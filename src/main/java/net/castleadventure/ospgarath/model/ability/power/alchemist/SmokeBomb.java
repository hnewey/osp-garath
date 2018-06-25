package net.castleadventure.ospgarath.model.ability.power.alchemist;

import net.castleadventure.ospgarath.model.ability.power.Power;

public class SmokeBomb extends Power {

    public SmokeBomb() {
        name = "Smoke Bomb Spell Potion";
        description = "Choose one square within 4 spaces. This square and all adjacent squares become a zone clouded in smoke, and all attacks within are made as though hampered. This lasts for a number of rounds equal to a roll of (1- I Bonus). If used on your own current space, using this power does not provoke a free attack (Quick Action/once per game).";
        powerCost = ".5";
    }

}
