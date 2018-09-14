package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.StatType;

public class Immobilized extends NegativeCondition {

    public Immobilized() {
        this.conditionType = Type.IMMOBILIZED;
    }

    @Override
    public void doEffect() {
        Integer currentMovement = GameState.getInstance().getPlayerCharacter().getMovement().getValue();
        GameState.getInstance().getPlayerCharacter().modifyStat(StatType.MOVEMENT, currentMovement*-1, "Immobilized");
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getPlayerCharacter().resetMovement();
    }
}
