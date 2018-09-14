package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;

public class Determined extends PositiveCondition {

    public Determined() {
        this.conditionType = Type.DETERMINED;
    }

    @Override
    public void doEffect() {
        GameState.getInstance().getPlayerCharacter().changeAttackDice(1);
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getPlayerCharacter().changeAttackDice(-1);
    }


}
