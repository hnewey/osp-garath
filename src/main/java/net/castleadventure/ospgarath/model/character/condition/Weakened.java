package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.Stat;

public class Weakened extends NegativeCondition {

    private Stat effectedStat;
    private Integer weakenedAmount;

    @Override
    public void doEffect() {
        effectedStat = GameState.getInstance().getCharacter().getHighestStat();

        weakenedAmount = Dice.d3() + Dice.d3();
        effectedStat.changeTemp(weakenedAmount * -1);
    }

    @Override
    public void endEffect() {
        effectedStat.changeTemp(weakenedAmount);
    }
}
