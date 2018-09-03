package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.StatType;

public class Steadied extends PositiveCondition {

    private Integer changeAmount;

    @Override
    public void doEffect() {
        changeAmount = Dice.d2() + Dice.d2();
        GameState.getInstance().getCharacter().modifyStat(StatType.DEFENSE, changeAmount, "Steadied");
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getCharacter().modifyStat(StatType.DEFENSE, changeAmount * -1, "Steadied ended");
    }
}
