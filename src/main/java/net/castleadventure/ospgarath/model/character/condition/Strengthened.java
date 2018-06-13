package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.Stat;

public class Strengthened extends PositiveCondition {

    private Stat effectedStat;
    private Integer strengthenedAmount;

    @Override
    public void doEffect() {
        effectedStat = GameState.getInstance().getCharacter().getHighestStat();

        strengthenedAmount = Dice.d3() + Dice.d3();
        effectedStat.changeTemp(strengthenedAmount);
    }

    @Override
    public void endEffect() {
        effectedStat.changeTemp(strengthenedAmount * -1);
    }

}
