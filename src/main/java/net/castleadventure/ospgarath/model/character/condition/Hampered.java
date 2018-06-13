package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;

public class Hampered extends NegativeCondition {
    @Override
    public void doEffect() {
        GameState.getInstance().getCharacter().changeAttackDice(-1);
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getCharacter().changeAttackDice(1);
    }
}
