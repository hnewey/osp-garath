package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;

public class Immobilized extends NegativeCondition {
    @Override
    public void doEffect() {
        GameState.getInstance().getCharacter().setMovement(0);
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getCharacter().resetMovement();
    }
}
