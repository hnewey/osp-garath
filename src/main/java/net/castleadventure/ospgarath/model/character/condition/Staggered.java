package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.GameState;

public class Staggered extends NegativeCondition {

    private Integer changeAmount;

    @Override
    public void doEffect() {
        changeAmount = Dice.d2() + Dice.d2();
        GameState.getInstance().getCharacter().changeDefense(changeAmount * -1);
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getCharacter().changeDefense(changeAmount);
    }
}
