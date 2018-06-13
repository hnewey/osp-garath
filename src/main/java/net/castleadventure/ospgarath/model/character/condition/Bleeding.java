package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;

public class Bleeding extends NegativeCondition {
    @Override
    public void doEffect() {

    }

    @Override
    public void endEffect() {

    }

    @Override
    public void endTurn() {
        GameState.getInstance().getCharacter().takeDamage(1);
    }
}
