package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.StatType;

public class Staggered extends NegativeCondition {

    private Integer changeAmount;

    public Staggered() {
        this.conditionType = Type.STAGGERED;
    }

    @Override
    public void doEffect() {
        changeAmount = Dice.d2() + Dice.d2();
        GameState.getInstance().getPlayerCharacter().modifyStat(StatType.DEFENSE, changeAmount * -1, "Staggered");
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getPlayerCharacter().modifyStat(StatType.DEFENSE, changeAmount, "Staggered ended");
    }
}
