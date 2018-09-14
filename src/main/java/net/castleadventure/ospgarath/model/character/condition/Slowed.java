package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;

public class Slowed extends NegativeCondition {

    public Slowed() {
        this.conditionType = Type.SLOWED;
    }

    @Override
    public void doEffect() {
        GameState.getInstance().getPlayerCharacter().halfMovement("Slowed");
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getPlayerCharacter().resetMovement();
    }
}
