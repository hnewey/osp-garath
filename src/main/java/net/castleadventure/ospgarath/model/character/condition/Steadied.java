package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.GameState;

public class Steadied extends PositiveCondition {

    private Integer changeAmount;

    @Override
    public void doEffect() {
        changeAmount = Dice.d2() + Dice.d2();
        GameState.getInstance().getCharacter().changeDefense(changeAmount);
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getCharacter().changeDefense(changeAmount * -1);
    }
}
