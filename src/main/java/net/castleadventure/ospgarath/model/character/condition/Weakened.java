package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.Stat;

public class Weakened extends NegativeCondition {

    private Stat effectedStat;
    private Integer weakenedAmount;
    private String reason = "Weakened";

    @Override
    public void doEffect() {
        effectedStat = GameState.getInstance().getCharacter().getHighestStat();

        weakenedAmount = Dice.d3() + Dice.d3();
        effectedStat.addModifier(weakenedAmount * -1, reason);
    }

    @Override
    public void endEffect() {
        effectedStat.removeModifier(reason);
    }
}
