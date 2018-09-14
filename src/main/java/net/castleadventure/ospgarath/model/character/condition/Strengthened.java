package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.Stat;

public class Strengthened extends PositiveCondition {

    private Stat effectedStat;
    private Integer strengthenedAmount;
    private String reason = "Strengthened";

    public Strengthened() {
        this.conditionType = Type.STRENGTHENED;
    }

    @Override
    public void doEffect() {
        effectedStat = GameState.getInstance().getPlayerCharacter().getHighestStat();

        strengthenedAmount = Dice.d3() + Dice.d3();
        effectedStat.addModifier(strengthenedAmount, reason);
    }

    @Override
    public void endEffect() {
        effectedStat.removeModifier(reason);
    }

}
