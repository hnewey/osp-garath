package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.StatType;

public class Immobilized extends NegativeCondition {
    @Override
    public void doEffect() {
        Integer currentMovement = GameState.getInstance().getCharacter().getMovement().getValue();
        GameState.getInstance().getCharacter().modifyStat(StatType.MOVEMENT, currentMovement*-1, "Immobilized");
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getCharacter().resetMovement();
    }
}
