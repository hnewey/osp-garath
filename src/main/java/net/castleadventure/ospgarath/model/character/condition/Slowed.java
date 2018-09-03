package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;

public class Slowed extends NegativeCondition {
    @Override
    public void doEffect() {
        GameState.getInstance().getCharacter().halfMovement("Slowed");
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getCharacter().resetMovement();
    }
}
